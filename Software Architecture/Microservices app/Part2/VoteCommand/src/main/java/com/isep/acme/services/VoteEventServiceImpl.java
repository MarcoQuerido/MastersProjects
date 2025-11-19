package com.isep.acme.services;

import com.google.gson.Gson;
import com.isep.acme.model.event.VoteCommandEvent;
import com.isep.acme.repositories.VoteCommandEventRepository;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class VoteEventServiceImpl implements VoteEventService {

    private static final Logger logger = LoggerFactory.getLogger(VoteEventServiceImpl.class);

    private final Gson gson = new Gson();

    @Autowired
    private VoteCommandEventRepository repository;

    @Override
    public Optional<VoteCommandEvent> processEvent(String voteEventMessage) {
        VoteCommandEvent voteEvent = gson.fromJson(voteEventMessage, VoteCommandEvent.class);
        logger.info(" [x] Received '" + voteEvent + "'");

        Optional<VoteCommandEvent> persistedProductEventOpt = repository.findById(voteEvent.getId());
        if (persistedProductEventOpt.isPresent()) {
            logger.warn(" [x] Received already existing VoteEvent");
            return Optional.empty();
        } else {
            VoteCommandEvent savedEvent = repository.save(voteEvent);
            logger.info(String.format(" [x] Stored new event in DB with id: %s", voteEvent.getId()));
            return Optional.of(savedEvent);
        }
    }
}
