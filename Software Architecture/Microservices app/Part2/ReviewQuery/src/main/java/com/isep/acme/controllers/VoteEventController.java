package com.isep.acme.controllers;

import com.isep.acme.model.event.EventVoteDTO;
import com.isep.acme.model.event.VoteCommandEvent;
import com.isep.acme.services.ReviewService;
import com.isep.acme.services.VoteEventService;
import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;
import com.rabbitmq.client.DeliverCallback;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;

import java.nio.charset.StandardCharsets;
import java.util.Optional;

@Controller
public class VoteEventController {

    private static final Logger logger = LoggerFactory.getLogger(VoteEventController.class);

    @Autowired
    private VoteEventService eventService;

    @Autowired
    private ReviewService reviewService;

    public VoteEventController(@Value("${rabbitmq.consumer.vote.exchange.name}") String exchange_name,
                               @Value("${rabbitmq.consumer.exchange.type}") String exchange_type,
                               @Value("${rabbitmq.consumer.host}") String host,
                               @Value("${rabbitmq.consumer.port}") Integer port) {
        try {
            ConnectionFactory connectionFactory = new ConnectionFactory();
            connectionFactory.setHost(host);
            connectionFactory.setPort(port);

            Connection connection = connectionFactory.newConnection();
            Channel channel = connection.createChannel();

            channel.exchangeDeclare(exchange_name, exchange_type);
            String queueName = channel.queueDeclare().getQueue();

            channel.queueBind(queueName, exchange_name, "");

            logger.info(" [*] Waiting for messages");

            DeliverCallback deliverCallback = ((consumerTag, messageProductEvent) -> {
                String strProductEvent = new String(messageProductEvent.getBody(), StandardCharsets.UTF_8);
                Optional<VoteCommandEvent> voteCommandEvent = eventService.processEvent(strProductEvent);

                if (voteCommandEvent.isPresent()) {
                    VoteCommandEvent voteEvent = voteCommandEvent.get();

                    EventVoteDTO eventVoteDTO = voteEvent.getVote();
                    switch (voteEvent.getType()) {
                        case ADDED_DOWN_VOTE_TO_REVIEW:
                        case ADDED_UP_VOTE_TO_REVIEW:
                            try {
                                reviewService.addVoteToReview(eventVoteDTO.getVoteId(), eventVoteDTO.getVote(), eventVoteDTO.getUserId(), eventVoteDTO.getReviewId());
                            } catch (Exception ex) {
                                logger.error(" [x] Error while adding vote to review", ex);
                                break;
                            }
                            logger.info(" [x] Processed ADDED_DOWN_VOTE_TO_REVIEW/ADDED_UP_VOTE_TO_REVIEW message");
                            break;
                    }
                }
            });

            channel.basicConsume(queueName, true, deliverCallback, consumerTag -> {
            });
        } catch (Exception ex) {
            logger.error(
                    String.format("Error trying to establish connection with RabbitMQ. " +
                            "EXCHANGE_NAME=%s, EXCHANGE_TYPE=%s", exchange_name, exchange_type), ex);
        }

    }

}
