package com.isep.acme.bootstrapper;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.isep.acme.model.ProductDTO;
import com.rabbitmq.client.AMQP;
import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;
import org.apache.commons.lang3.SerializationUtils;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.List;
import java.util.UUID;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.TimeoutException;

@Component
public class RpcClient {

    private final Channel channel;
    private final String replyQueueName;
    private final Gson gson;
    private final String rpc_queue_name;

    public RpcClient(@Value("${rabbitmq.rpc.queue.name}") String rpc_queue_name,
                     @Value("${rabbitmq.rpc.host}") String host,
                     @Value("${rabbitmq.rpc.port}") Integer port) throws IOException, TimeoutException {

        this.gson = new Gson();
        this.rpc_queue_name = rpc_queue_name;

        ConnectionFactory factory = new ConnectionFactory();
        factory.setHost(host);
        factory.setPort(port);

        Connection connection = factory.newConnection();
        channel = connection.createChannel();
        replyQueueName = channel.queueDeclare().getQueue();
    }

    public List<ProductDTO> call() throws IOException, InterruptedException {
        String correlationId = UUID.randomUUID().toString();

        AMQP.BasicProperties props = new AMQP.BasicProperties
                .Builder()
                .correlationId(correlationId)
                .replyTo(replyQueueName)
                .build();

        channel.basicPublish("", rpc_queue_name, props, "".getBytes(StandardCharsets.UTF_8));

        BlockingQueue<String> responseQueue = new ArrayBlockingQueue<>(1);

        String ctag = channel.basicConsume(replyQueueName, true, (consumerTag, delivery) -> {
            if (delivery.getProperties().getCorrelationId().equals(correlationId)) {
                responseQueue.offer(SerializationUtils.deserialize(delivery.getBody()));
            }
        }, consumerTag -> {
        });

        String response = responseQueue.take();
        channel.basicCancel(ctag);

        return gson.fromJson(response, new TypeToken<List<ProductDTO>>() {
        }.getType());
    }

}



