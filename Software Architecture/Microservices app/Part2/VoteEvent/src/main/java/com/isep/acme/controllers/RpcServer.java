package com.isep.acme.controllers;

import com.google.gson.Gson;
import com.isep.acme.model.ProductDTO;
import com.isep.acme.bootstrapper.RpcResponse;
import com.isep.acme.model.ReviewDTO;
import com.isep.acme.model.UserDTO;
import com.isep.acme.model.VoteDTO;
import com.isep.acme.services.ProductService;
import com.isep.acme.services.ReviewService;
import com.isep.acme.services.UserService;
import com.isep.acme.services.VoteService;
import com.rabbitmq.client.AMQP;
import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;
import com.rabbitmq.client.DeliverCallback;
import org.apache.commons.lang3.SerializationUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;

import java.io.IOException;
import java.util.List;
import java.util.concurrent.TimeoutException;

@Controller
public class RpcServer {

    private static final Logger logger = LoggerFactory.getLogger(RpcServer.class);

    private final Gson gson;

    @Autowired
    private ReviewService reviewService;

    @Autowired
    private VoteService voteService;

    @Autowired
    private UserService userService;

    @Autowired
    private ProductService productService;

    public RpcServer(@Value("${rabbitmq.rpc.queue.name}") String rpc_queue_name,
                     @Value("${rabbitmq.rpc.host}") String host,
                     @Value("${rabbitmq.rpc.port}") Integer port) throws IOException, TimeoutException {

        gson = new Gson();

        ConnectionFactory factory = new ConnectionFactory();
        factory.setHost(host);
        factory.setPort(port);
        Connection connection = factory.newConnection();
        Channel channel = connection.createChannel();

        channel.queueDeclare(rpc_queue_name, false, false, false, null);
        channel.basicQos(1);

        logger.info("RPC server listening on " + rpc_queue_name);

        Object monitor = new Object();

        DeliverCallback deliverCallback = (consumerTag, delivery) -> {
            AMQP.BasicProperties replyProps = new AMQP.BasicProperties
                    .Builder()
                    .correlationId(delivery.getProperties().getCorrelationId())
                    .build();

            String responseJson = null;

            try {
                List<UserDTO> users = userService.getUsers();
                List<ProductDTO> products = productService.getProducts();
                List<ReviewDTO> reviews = reviewService.getReviews();
                List<VoteDTO> votes = voteService.getVotes();

                RpcResponse response = new RpcResponse(users, products, reviews, votes);

                responseJson = gson.toJson(response);
                logger.info(String.format("Received request - Sending %d users, %d products, %d reviews and %d votes", users.size(), products.size(), reviews.size(), votes.size()));

            } finally {
                channel.basicPublish("", delivery.getProperties().getReplyTo(), replyProps,
                        SerializationUtils.serialize(responseJson)
                );
                channel.basicAck(delivery.getEnvelope().getDeliveryTag(), false);
                synchronized (monitor) {
                    monitor.notify();
                }
            }
        };

        channel.basicConsume(rpc_queue_name, false, deliverCallback, consumerTag -> {
        });
    }

}

