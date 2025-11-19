package com.isep.acme.repositories;

import com.isep.acme.model.TemporaryVote;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface TemporaryVoteRepository extends JpaRepository<TemporaryVote, String> {

}
