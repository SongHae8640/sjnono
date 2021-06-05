package com.sjnono.demo.domain.fnncSttm;


import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/fnncSttm")
public class FnncSttmRestController {

    private final FnncSttmService fnncSttmService;


    /**
     * 재무제표 크롤링 프로그램에서 보낸 재무제표 데이터를 받아 저장
     */
    @PostMapping
    public ResponseEntity saveFnnSttm(FnncSttmRequsetDto fnncSttmRequsetDto){
        //validate


        //requestDto to Entity
        FnncSttm fnncSttm = null;

        //service
        fnncSttmService.save(fnncSttm);


        //Entity to responseDto
        FnncSttmResponseDto fnncSttmResponseDto = null;



        //response


        return null;
    }


    @Data
    private class FnncSttmRequsetDto {


    }

    private class FnncSttmResponseDto {
    }
}
