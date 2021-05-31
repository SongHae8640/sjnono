package com.sjnono.demo.domain.fnncSttm;


import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class FnncSttmService {

    private final FnncSttmRepository fnncSttmRepository;


    public void save(FnncSttm fnncSttm) {

        //재무제표를 통해 산정되는 값 계산
        fnncSttm.calCrntAsts();


        //재무제표 저장
        fnncSttmRepository.save(fnncSttm);


    }
}
