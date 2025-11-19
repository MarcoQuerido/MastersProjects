package com.isep.acme.bootstrapper;

import com.isep.acme.services.ProductService;
import com.isep.acme.services.ReviewService;
import com.isep.acme.services.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.io.IOException;

@Component
public class Bootstrapper implements CommandLineRunner {

    private static final Logger logger = LoggerFactory.getLogger(Bootstrapper.class);

    @Autowired
    private UserService userService;

    @Autowired
    private ProductService productService;

    @Autowired
    private ReviewService reviewService;

    @Autowired
    private RpcClient rpcClient;

    @Override
    public void run(String... args) throws IOException, InterruptedException {

        RpcResponse rpcResponse = rpcClient.call();

        rpcResponse.users.forEach(userDTO -> {
                    try {
                        logger.info(String.format("Adding the following user: %s", userDTO.toString()));
                        userService.addUser(userDTO);
                    } catch (Exception e) {
                        logger.error(e.getMessage());
                    }
                }
        );

        rpcResponse.products.forEach(productDTO -> {
                    try {
                        logger.info(String.format("Adding the following product: %s", productDTO.toString()));
                        productService.addProduct(productDTO.getId(), productDTO.getSku());
                    } catch (Exception e) {
                        logger.error(e.getMessage());
                    }
                }
        );

        rpcResponse.reviews.forEach(reviewDTO -> {
                    try {
                        logger.info(String.format("Adding the following review: %s", reviewDTO.toString()));
                        reviewService.addReview(reviewDTO);
                    } catch (Exception e) {
                        logger.error(e.getMessage());
                    }
                }
        );
    }
}
