package com.sjnono.demo.domain.stckPrc;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class StckPrcService {

    private final StckRepository stckRepository;

    public StckPrc saveStckPrc(StckPrc stckPrc) {

        this.stckRepository.save(stckPrc);

        return stckPrc;
    }
}
