package com.isep.acme.controllers;

import com.isep.acme.model.CreateReviewDTO;
import com.isep.acme.model.event.EventReviewDTO;
import com.isep.acme.model.event.ReviewCommandEvent;
import com.isep.acme.services.ReviewService;
import com.nimbusds.jose.shaded.gson.Gson;
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
public class ReviewEventController {

    private static final Logger logger = LoggerFactory.getLogger(ReviewEventController.class);

    private final Gson gson;



    @Autowired
    private ReviewService reviewService;

    public ReviewEventController(@Value("${rabbitmq.consumer.review.exchange.name}") String exchange_name,
                                 @Value("${rabbitmq.consumer.exchange.type}") String exchange_type,
                                 @Value("${rabbitmq.consumer.host}") String host,
                                 @Value("${rabbitmq.consumer.port}") Integer port) {
        gson = new Gson();
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

                ReviewCommandEvent reviewEvent = gson.fromJson(strProductEvent, ReviewCommandEvent.class);
                logger.info(" [x] Received '" + reviewEvent + "'");

                EventReviewDTO eventReviewDTO = reviewEvent.getReview();
                switch (reviewEvent.getType()) {
                        case REVIEW_CREATED:
                            try {
                                CreateReviewDTO createReviewDTO = new CreateReviewDTO(
                                        eventReviewDTO.getReviewText(),
                                        eventReviewDTO.getUserId(),
                                        eventReviewDTO.getRating());
                                this.reviewService.create(createReviewDTO, eventReviewDTO.getProductSku());
                            } catch (Exception ex) {
                                logger.error(" [x] Error while creating review", ex);
                                break;
                            }
                            logger.info(" [x] REVIEW_CREATED message successfully processed");
                            break;
                        case REVIEW_MODERATED:
                            try {
                                this.reviewService.moderateReview(eventReviewDTO.getReviewId(), eventReviewDTO.getApprovalStatus());
                            } catch (Exception ex) {
                                logger.error(" [x] Error while updating review", ex);
                                break;
                            }
                            logger.info(" [x] Processed REVIEW_MODERATED message");
                            break;
                        case REVIEW_DELETED:
                            try {
                                this.reviewService.deleteReview(eventReviewDTO.getReviewId());
                            } catch (Exception ex) {
                                logger.error(" [x] Error while deleting review", ex);
                                break;
                            }
                            logger.info(" [x] Processed REVIEW_DELETED message");
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
