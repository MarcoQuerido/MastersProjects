package com.isep.acme.services;

import com.google.gson.Gson;
import com.isep.acme.model.event.ReviewCommandEvent;
import com.isep.acme.repositories.ReviewCommandEventRepository;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ReviewEventServiceImpl implements ReviewEventService {

    private static final Logger logger = LoggerFactory.getLogger(ProductEventServiceImpl.class);

    private final Gson gson = new Gson();

    @Autowired
    private ReviewCommandEventRepository repository;

    @Override
    public Optional<ReviewCommandEvent> processEvent(String productEventMessage) {
        ReviewCommandEvent reviewEvent = gson.fromJson(productEventMessage, ReviewCommandEvent.class);
        logger.info(" [x] Received '" + reviewEvent + "'");

        Optional<ReviewCommandEvent> persistedProductEventOpt = repository.findById(reviewEvent.getId());
        if (persistedProductEventOpt.isPresent()) {
            logger.warn(" [x] Received already existing ReviewEvent");
            return Optional.empty();
        } else {
            ReviewCommandEvent savedEvent = repository.save(reviewEvent);
            logger.info(String.format(" [x] Stored new event in DB with id: %s", reviewEvent.getId()));
            return Optional.of(savedEvent);
        }
    }
}
