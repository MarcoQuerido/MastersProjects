package com.isep.acme.services;

import com.isep.acme.model.*;

public interface VoteService {

    Vote addVoteToReview(Long reviewID, VoteDTO voteDTO);

    Vote addVoteToReviewAndPublish(Long reviewID, VoteDTO voteDTO);

    TemporaryVote addVoteWithoutReview(String voteId, String vote, Long userId, String productSku);

    TemporaryVote addVoteWithoutReviewAndPublish(CreateVoteReviewDTO voteReviewDTO);

}
