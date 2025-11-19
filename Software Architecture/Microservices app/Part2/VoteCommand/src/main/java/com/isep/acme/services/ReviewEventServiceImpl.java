package com.isep.acme.services;

import com.google.gson.Gson;
import com.isep.acme.model.event.ReviewCommandEvent;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ReviewEventServiceImpl implements ReviewEventService {

    private static final Logger logger = LoggerFactory.getLogger(ReviewEventServiceImpl.class);

    private final Gson gson = new Gson();

    @Override
    public Optional<ReviewCommandEvent> processEvent(String productEventMessage) {
        ReviewCommandEvent reviewEvent = gson.fromJson(productEventMessage, ReviewCommandEvent.class);
        logger.info(" [x] Received '" + reviewEvent + "'");

        return Optional.of(reviewEvent);
    }
}
