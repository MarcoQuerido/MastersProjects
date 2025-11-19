package com.isep.acme.controllers;

import com.isep.acme.model.VoteDTO;
import com.isep.acme.model.Vote;
import com.isep.acme.services.VoteService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;

@Tag(name = "Vote", description = "Endpoints for managing Vote")
@RestController
public class VoteController {

    @Autowired
    private VoteService service;

    @Operation(summary = "get votes of a specific review")
    @GetMapping("/reviews/{reviewID}/vote")
    public ResponseEntity<List<VoteDTO>> getVotesOfReview(@PathVariable(value = "reviewID") final Long reviewID) {
        List<Vote> votes = this.service.getVotesOfReview(reviewID);
        return new ResponseEntity<>(votes.stream().map(Vote::toDto).collect(Collectors.toList()), HttpStatus.FOUND);
    }

    @Operation(summary = "get votes")
    @GetMapping("/vote")
    public ResponseEntity<List<VoteDTO>> getVotes() {
        List<Vote> votes = this.service.getVotes();
        return new ResponseEntity<>(votes.stream().map(Vote::toDto).collect(Collectors.toList()), HttpStatus.FOUND);
    }

}
