package com.isep.acme.publisher;

import com.google.gson.Gson;
import com.isep.acme.model.event.ReviewCommandEvent;
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
public class VoteQueueCommandEventPublisher {

    private static final Logger logger = LoggerFactory.getLogger(VoteQueueCommandEventPublisher.class);

    private final String queue_name;

    private Channel channel;

    private final Gson gson;

    public VoteQueueCommandEventPublisher(@Value("${rabbitmq.review.publisher.queue.name}") String queue_name,
                                          @Value("${rabbitmq.review.publisher.host}") String host,
                                          @Value("${rabbitmq.review.publisher.port}") Integer port) {
        this.gson = new Gson();
        this.queue_name = queue_name;

        try {
            ConnectionFactory connectionFactory = new ConnectionFactory();
            connectionFactory.setHost(host);
            connectionFactory.setPort(port);
            Connection connection = connectionFactory.newConnection();

            channel = connection.createChannel();
            channel.queueDeclare(queue_name, false, false, false, null);
        } catch (Exception ex) {
            logger.error(
                    String.format("Error trying to establish connection with RabbitMQ. " +
                            "QUEUE_NAME=%s", queue_name), ex);
        }
    }

    public void publishEvent(VoteCommandEvent event) {
        try {
            String jsonEvent = gson.toJson(event);
            channel.basicPublish("", queue_name, null, jsonEvent.getBytes(StandardCharsets.UTF_8));
            logger.info(" [x] Sent '" + jsonEvent + "'");
        } catch (Exception ex) {
            logger.error(String.format("Error sending event. Event=%s", event), ex);
        }
    }
}
