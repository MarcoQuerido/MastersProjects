package com.isep.acme.controllers;

import com.isep.acme.model.Review;
import com.isep.acme.model.event.EventProductDTO;
import com.isep.acme.model.event.EventReviewDTO;
import com.isep.acme.model.event.ProductCommandEvent;
import com.isep.acme.model.event.ReviewCommandEvent;
import com.isep.acme.model.event.ReviewCommandEventTypeEnum;
import com.isep.acme.publisher.ReviewCommandEventPublisher;
import com.isep.acme.services.ProductEventService;
import com.isep.acme.services.ProductService;
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
import java.util.List;
import java.util.Optional;

@Controller
public class ProductEventController {

    private static final Logger logger = LoggerFactory.getLogger(ProductEventController.class);

    @Autowired
    private ProductEventService eventService;

    @Autowired
    private ProductService productService;

    @Autowired
    private ReviewCommandEventPublisher reviewEventPublisher;

    public ProductEventController(@Value("${rabbitmq.consumer.product.exchange.name}") String exchange_name,
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
                Optional<ProductCommandEvent> productCommandEvent = eventService.processEvent(strProductEvent);

                if (productCommandEvent.isPresent()) {
                    ProductCommandEvent productEvent = productCommandEvent.get();

                    EventProductDTO eventProductDTO = productEvent.getProduct();

                    try {
                        switch (productEvent.getType()) {
                            case PRODUCT_CREATED:
                                try {
                                    this.productService.addProduct(eventProductDTO.getId(), eventProductDTO.getSku());
                                } catch (Exception ex) {
                                    logger.error(" [x] Error while creating product", ex);
                                    break;
                                }
                                logger.info(" [x] PRODUCT_CREATED message successfully processed");
                                break;
                            case PRODUCT_DELETED:
                                try {
                                    List<Review> deletedReviews = this.productService.deleteProductBySku(eventProductDTO.getSku());

                                    deletedReviews.forEach(review -> {
                                        EventReviewDTO eventReviewDTO = EventReviewDTO.builder().reviewId(review.getIdReview()).build();
                                        ReviewCommandEvent event = new ReviewCommandEvent(ReviewCommandEventTypeEnum.REVIEW_DELETED, eventReviewDTO);
                                        reviewEventPublisher.publishEvent(event);
                                    });

                                } catch (Exception ex) {
                                    logger.error(" [x] Error while deleting product", ex);
                                    break;
                                }
                                logger.info(" [x] Processed PRODUCT_DELETED message");
                                break;
                        }
                    } catch (NullPointerException ex) {
                        logger.error(" [x] ProductCommandEventTypeEnum not supported", ex);
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
