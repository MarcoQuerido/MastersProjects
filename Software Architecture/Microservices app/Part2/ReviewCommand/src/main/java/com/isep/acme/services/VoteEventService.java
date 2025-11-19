package com.isep.acme.services;

import com.isep.acme.model.event.VoteCommandEvent;

import java.util.Optional;

public interface VoteEventService {

    Optional<VoteCommandEvent> processEvent(String reviewEventMessage);

}
