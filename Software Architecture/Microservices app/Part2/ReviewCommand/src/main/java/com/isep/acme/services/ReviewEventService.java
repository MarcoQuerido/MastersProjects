package com.isep.acme.services;

import com.isep.acme.model.event.ReviewCommandEvent;

import java.util.Optional;

public interface ReviewEventService {

    Optional<ReviewCommandEvent> processEvent(String reviewEventMessage);

}
