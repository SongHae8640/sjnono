package com.sjnono.demo.domain.ex;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class ExService {

    @Autowired
    ExRepository exRepository;


    public Example findById(Long exId) {

        return exRepository.findByIdJoinStock(exId);
    }

    public Page<Example> search(Pageable pageable) {
        return exRepository.search(pageable);

    }

    public Example insertEx(Example example) {

        return exRepository.save(example);
    }
}
