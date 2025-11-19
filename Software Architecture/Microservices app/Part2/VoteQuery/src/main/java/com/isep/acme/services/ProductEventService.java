package com.isep.acme.services;

import com.isep.acme.model.event.ProductCommandEvent;

import java.util.Optional;

public interface ProductEventService {

    Optional<ProductCommandEvent> processEvent(String productEventMessage);

}
