package com.isep.acme.controllers;

import com.google.gson.Gson;
import com.isep.acme.model.CreateVoteReviewDTO;
import com.isep.acme.model.TemporaryVote;
import com.isep.acme.model.VoteDTO;
import com.isep.acme.model.Vote;
import com.isep.acme.services.VoteService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@Tag(name = "Vote", description = "Endpoints for managing Vote")
@RestController
public class VoteController {

    @Autowired
    private VoteService service;

    @Operation(summary = "add vote")
    @PostMapping("/reviews/{reviewID}/vote")
    public ResponseEntity<VoteDTO> addVote(@PathVariable(value = "reviewID") final Long reviewID,
                                           @RequestBody VoteDTO createVoteDTO) {

        Vote addedVote = this.service.addVoteToReviewAndPublish(reviewID, createVoteDTO);
        return new ResponseEntity<>(addedVote.toDto(), HttpStatus.CREATED);

    }

    @Operation(summary = "add vote to a non existing review")
    @PostMapping("/vote")
    public ResponseEntity<VoteDTO> addVoteAndReview(@RequestBody CreateVoteReviewDTO voteReviewDTO) {

        //TODO - Add Review
        TemporaryVote addedVote = this.service.addVoteWithoutReviewAndPublish(voteReviewDTO);

        return new ResponseEntity<>(addedVote.toDto(), HttpStatus.CREATED);
    }

}
