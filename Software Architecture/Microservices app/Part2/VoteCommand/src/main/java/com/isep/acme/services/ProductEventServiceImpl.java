package com.isep.acme.services;

import com.google.gson.Gson;
import com.isep.acme.model.event.ProductCommandEvent;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ProductEventServiceImpl implements ProductEventService {

    private static final Logger logger = LoggerFactory.getLogger(ProductEventServiceImpl.class);

    private final Gson gson = new Gson();

    @Override
    public Optional<ProductCommandEvent> processEvent(String productEventMessage) {
        ProductCommandEvent productEvent = gson.fromJson(productEventMessage, ProductCommandEvent.class);
        logger.info(" [x] Received '" + productEvent + "'");

        return Optional.of(productEvent);
    }
}
