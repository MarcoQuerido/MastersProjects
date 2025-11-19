package com.isep.acme.publisher;

import com.google.gson.Gson;
import com.isep.acme.model.event.VoteCommandEvent;
import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Repository;

import java.nio.charset.StandardCharsets;

@Repository
public class VoteCommandEventPublisher {

    private static final Logger logger = LoggerFactory.getLogger(VoteCommandEventPublisher.class);

    private final String exchange_name;

    private Channel channel;

    private final Gson gson;

    public VoteCommandEventPublisher(@Value("${rabbitmq.vote.publisher.exchange.name}") String exchange_name,
                                     @Value("${rabbitmq.vote.publisher.exchange.type}") String exchange_type,
                                     @Value("${rabbitmq.vote.publisher.host}") String host,
                                     @Value("${rabbitmq.vote.publisher.port}") Integer port) {
        this.gson = new Gson();
        this.exchange_name = exchange_name;

        try {
            ConnectionFactory connectionFactory = new ConnectionFactory();
            connectionFactory.setHost(host);
            connectionFactory.setPort(port);
            Connection connection = connectionFactory.newConnection();

            channel = connection.createChannel();
            channel.exchangeDeclare(exchange_name, exchange_type);
        } catch (Exception ex) {
            logger.error(
                    String.format("Error trying to establish connection with RabbitMQ. " +
                            "EXCHANGE_NAME=%s, EXCHANGE_TYPE=%s", exchange_name, exchange_type), ex);
        }
    }

    public void publishEvent(VoteCommandEvent event) {
        try {
            String jsonEvent = gson.toJson(event);
            channel.basicPublish(exchange_name, "", null, jsonEvent.getBytes(StandardCharsets.UTF_8));
            logger.info(" [x] Sent '" + jsonEvent + "'");
        } catch (Exception ex) {
            logger.error(String.format("Error sending event. Event=%s", event), ex);
        }
    }
}
