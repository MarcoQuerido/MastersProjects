package com.isep.acme.controllers;

import com.google.gson.Gson;
import com.isep.acme.model.VoteDTO;
import com.isep.acme.model.event.VoteCommandEvent;
import com.isep.acme.model.event.VoteEventDTO;
import com.isep.acme.services.VoteService;
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

@Controller
public class VoteEventController {

    private static final Logger logger = LoggerFactory.getLogger(VoteEventController.class);

    @Autowired
    private VoteService voteService;

    private final Gson gson;

    public VoteEventController(@Value("${rabbitmq.vote.consumer.exchange.name}") String exchange_name,
                               @Value("${rabbitmq.vote.consumer.exchange.type}") String exchange_type,
                               @Value("${rabbitmq.vote.consumer.host}") String host,
                               @Value("${rabbitmq.vote.consumer.port}") Integer port) {
        this.gson = new Gson();

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

                VoteCommandEvent voteEvent = gson.fromJson(strProductEvent, VoteCommandEvent.class);

                VoteEventDTO voteEventDTO = voteEvent.getVote();

                switch (voteEvent.getType()) {
                    case TEMPORARY_VOTE_CREATED:
                        try {
                            this.voteService.addVoteWithoutReview(voteEventDTO.getVoteId(), voteEventDTO.getVote(), voteEventDTO.getUserId());
                        } catch (Exception ex) {
                            logger.error(" [x] Error while creating temporary vote", ex);
                            break;
                        }
                        logger.info(" [x] TEMPORARY_VOTE_CREATED message successfully processed");
                        break;
                    case ADDED_UP_VOTE_TO_REVIEW:
                    case ADDED_DOWN_VOTE_TO_REVIEW:
                        try {
                            VoteDTO voteDTO = VoteDTO.builder()
                                    .reviewId(voteEventDTO.getReviewId())
                                    .userId(voteEventDTO.getUserId())
                                    .vote(voteEventDTO.getVote())
                                    .build();

                            this.voteService.addVoteToReview(voteDTO.getReviewId(), voteDTO);
                        } catch (Exception ex) {
                            logger.error(" [x] Error while adding vote to review", ex);
                            break;
                        }
                        logger.info(" [x] ADDED_UP_VOTE_TO_REVIEW/ADDED_DOWN_VOTE_TO_REVIEW message successfully processed");
                        break;
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
