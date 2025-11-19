package com.isep.acme.services;

import com.isep.acme.model.*;

import java.util.List;

public interface VoteService {

    Vote addVoteToReview(Long reviewID, VoteDTO voteDTO);

    TemporaryVote addVoteWithoutReview(String voteId, String vote, Long userId);

    List<Vote> getVotesOfReview(Long reviewID);

    List<Vote> getVotes();
}
