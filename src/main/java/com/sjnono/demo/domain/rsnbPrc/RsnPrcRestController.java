package com.sjnono.demo.domain.rsnbPrc;

import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.lang.NonNull;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequiredArgsConstructor
@RequestMapping("/api/rsnPrc")
public class RsnPrcRestController {

    private final RsnbPrcService rsnbPrcService;

    /**
    * 적정가격을 조회하는 메서드
    * 조건을 파라미터로 받아서 해당 조건에 맞는 결과를 리턴
    * 주식기준코드는 필수
    * */
    @GetMapping
    public ResponseEntity inquiryRsnbPrc(@RequestParam RscnPrcInquiryRequestDto requestDto){

        List<RsnbPr> rsnbPrList = this.rsnbPrcService.inquiryRsnbPrc(requestDto);

        return null;
    }

    @Data
    protected class RscnPrcInquiryRequestDto{
        @NonNull
        String stockStndCode;

        String rsnbPrcClclMthdName;


    }

    /**
     * 적정가격을 산정하는 메서드
     * 파라미터로 재무제표의 id를 받아서 해당 재무재표를 이용한 적정자격 산정
     * 재무제표 id는 필수
     * */
    @PostMapping
    public ResponseEntity calRsnPrc(@NonNull @RequestParam Long fnncSttmId){

        List<RsnbPr> rsnbPrList = rsnbPrcService.calRsnbPrc(fnncSttmId);

        return null;
    }





}
