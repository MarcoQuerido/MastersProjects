package com.isep.acme.controllers;

import com.google.gson.Gson;
import com.isep.acme.model.event.ProductCommandEvent;
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

@Controller
public class ProductEventController {

    private static final Logger logger = LoggerFactory.getLogger(ProductEventController.class);

    private final Gson gson;

    @Autowired
    private ProductService service;

    public ProductEventController(@Value("${rabbitmq.consumer.exchange.name}") String exchange_name,
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

                ProductCommandEvent productEvent = gson.fromJson(strProductEvent, ProductCommandEvent.class);
                logger.info(" [x] Received '" + productEvent + "'");

                switch (productEvent.getType()) {
                    case PRODUCT_CREATED:
                        try {
                            this.service.create(productEvent.getProduct());
                        } catch (Exception ex) {
                            logger.error(" [x] Error while creating product", ex);
                            break;
                        }
                        logger.info(" [x] PRODUCT_CREATED message successfully processed");
                        break;
                    case PRODUCT_UPDATED:
                        try {
                            this.service.updateBySku(productEvent.getProduct().getSku(), productEvent.getProduct());
                        } catch (Exception ex) {
                            logger.error(" [x] Error while updating product", ex);
                            break;
                        }
                        logger.info(" [x] Processed PRODUCT_UPDATED message");
                        break;
                    case PRODUCT_DELETED:
                        try {
                            this.service.deleteBySku(productEvent.getProduct().getSku());
                        } catch (Exception ex) {
                            logger.error(" [x] Error while deleting product", ex);
                            break;
                        }
                        logger.info(" [x] Processed PRODUCT_DELETED message");
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
