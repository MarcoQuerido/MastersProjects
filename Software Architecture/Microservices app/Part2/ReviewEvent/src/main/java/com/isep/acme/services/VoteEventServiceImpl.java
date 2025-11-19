package com.isep.acme.services;

import com.google.gson.Gson;
import com.isep.acme.model.event.VoteCommandEvent;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class VoteEventServiceImpl implements VoteEventService {

    private static final Logger logger = LoggerFactory.getLogger(VoteEventServiceImpl.class);

    private final Gson gson = new Gson();

    @Override
    public Optional<VoteCommandEvent> processEvent(String productEventMessage) {
        VoteCommandEvent voteEvent = gson.fromJson(productEventMessage, VoteCommandEvent.class);
        logger.info(" [x] Received '" + voteEvent + "'");

        return Optional.of(voteEvent);
    }
}
