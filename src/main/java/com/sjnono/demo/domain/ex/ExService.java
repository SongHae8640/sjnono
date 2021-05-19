package com.sjnono.demo.domain.ex;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ExService {

    @Autowired
    ExRepository exRepository;


    public Example findById(Long exId) {

        return exRepository.findById(exId).get();
    }
}
