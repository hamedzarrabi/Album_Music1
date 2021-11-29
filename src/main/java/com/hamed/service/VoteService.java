package com.hamed.service;

import com.hamed.model.Votes;
import com.hamed.repository.VoteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class VoteService {

    @Autowired private VoteRepository voteRepository;

    public void saveVote(Votes votes) {
        voteRepository.save(votes);
    }
}
