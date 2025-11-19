package com.isep.acme.bootstrapper;

import com.isep.acme.model.ProductDTO;
import com.isep.acme.services.ProductService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.util.List;

@Component
public class ProductBootstrapper implements CommandLineRunner {

    private static final Logger logger = LoggerFactory.getLogger(ProductBootstrapper.class);

    @Autowired
    private ProductService service;

    @Autowired
    private RpcClient rpcClient;

    @Override
    public void run(String... args) throws IOException, InterruptedException {

        List<ProductDTO> productDTOS = rpcClient.call();

        productDTOS.forEach(productDTO -> {
                    try {
                        logger.info(String.format("Adding the following product: %s", productDTO.toString()));
                        service.create(productDTO);
                    } catch (Exception e) {
                        logger.error(e.getMessage());
                    }
                }
        );
    }
}
