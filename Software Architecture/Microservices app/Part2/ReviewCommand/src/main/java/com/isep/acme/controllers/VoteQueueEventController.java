package com.isep.acme.controllers;

import com.isep.acme.model.CreateReviewDTO;
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
public class VoteQueueEventController {

    private static final Logger logger = LoggerFactory.getLogger(VoteQueueEventController.class);

    @Autowired
    private VoteEventService eventService;

    @Autowired
    private ReviewService reviewService;

    public VoteQueueEventController(@Value("${rabbitmq.consumer.queue.name}") String queue_name,
                                    @Value("${rabbitmq.consumer.host}") String host,
                                    @Value("${rabbitmq.consumer.port}") Integer port) {
        try {
            ConnectionFactory connectionFactory = new ConnectionFactory();
            connectionFactory.setHost(host);
            connectionFactory.setPort(port);

            Connection connection = connectionFactory.newConnection();
            Channel channel = connection.createChannel();

            channel.queueDeclare(queue_name, false, false, false, null);

            logger.info(" [*] Waiting for messages");

            DeliverCallback deliverCallback = ((consumerTag, messageProductEvent) -> {
                String strProductEvent = new String(messageProductEvent.getBody(), StandardCharsets.UTF_8);
                Optional<VoteCommandEvent> voteCommandEvent = eventService.processEvent(strProductEvent);

                if (voteCommandEvent.isPresent()) {
                    VoteCommandEvent voteEvent = voteCommandEvent.get();

                    EventVoteDTO eventVoteDTO = voteEvent.getVote();
                    switch (voteEvent.getType()) {
                        case TEMPORARY_VOTE_CREATED:
                            try {
                                CreateReviewDTO createReviewDTO = new CreateReviewDTO(eventVoteDTO.getReviewText(), eventVoteDTO.getUserId(), eventVoteDTO.getReviewRating());
                                reviewService.createWithVoteAndPublish(createReviewDTO, eventVoteDTO.getProductSku(), eventVoteDTO.getVote(), eventVoteDTO.getVoteId());
                            } catch (Exception ex) {
                                logger.error(" [x] Error while creating review from temporary vote", ex);
                                break;
                            }
                            logger.info(" [x] TEMPORARY_VOTE_CREATED message successfully processed");
                            break;
                    }
                }
            });

            channel.basicConsume(queue_name, true, deliverCallback, consumerTag -> {
            });
        } catch (Exception ex) {
            logger.error(
                    String.format("Error trying to establish connection with RabbitMQ. " +
                            "QUEUE_NAME=%s", queue_name), ex);
        }

    }

}
