package com.isep.acme.controllers;

import com.isep.acme.model.ReviewDTO;
import com.isep.acme.model.VoteDTO;
import com.isep.acme.model.event.EventReviewDTO;
import com.isep.acme.model.event.ReviewCommandEvent;
import com.isep.acme.services.ReviewEventService;
import com.isep.acme.services.ReviewService;
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
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Controller
public class ReviewEventController {

    private static final Logger logger = LoggerFactory.getLogger(ReviewEventController.class);

    @Autowired
    private ReviewEventService eventService;

    @Autowired
    private ReviewService reviewService;

    public ReviewEventController(@Value("${rabbitmq.consumer.review.exchange.name}") String exchange_name,
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
                Optional<ReviewCommandEvent> reviewCommandEvent = eventService.processEvent(strProductEvent);

                if (reviewCommandEvent.isPresent()) {
                    ReviewCommandEvent reviewEvent = reviewCommandEvent.get();

                    EventReviewDTO eventReviewDTO = reviewEvent.getReview();
                    switch (reviewEvent.getType()) {
                        case REVIEW_CREATED:
                            try {
                                List<VoteDTO> upVotes = new ArrayList<>();
                                List<VoteDTO> downVotes = new ArrayList<>();

                                if ("downVote".equalsIgnoreCase(eventReviewDTO.getVote())) {
                                    downVotes.add(new VoteDTO(eventReviewDTO.getVoteId(), eventReviewDTO.getVote(), eventReviewDTO.getUserId()));
                                }

                                if ("upVote".equalsIgnoreCase(eventReviewDTO.getVote())) {
                                    upVotes.add(new VoteDTO(eventReviewDTO.getVoteId(), eventReviewDTO.getVote(), eventReviewDTO.getUserId()));
                                }

                                ReviewDTO reviewDTO = ReviewDTO.builder()
                                        .reviewText(eventReviewDTO.getReviewText())
                                        .idUser(eventReviewDTO.getUserId())
                                        .rating(eventReviewDTO.getRating())
                                        .productSku(eventReviewDTO.getProductSku())
                                        .approvalStatus(eventReviewDTO.getApprovalStatus())
                                        .upVotes(upVotes)
                                        .downVotes(downVotes)
                                        .build();
                                this.reviewService.addReview(reviewDTO);
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
