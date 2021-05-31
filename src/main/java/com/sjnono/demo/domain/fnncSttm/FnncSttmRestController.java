package com.sjnono.demo.domain.fnncSttm;


import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class FnncSttmRestController {

    private final FnncSttmService fnncSttmService;

    private final ModelMapper modelMapper;


    /**
     * 재무제표 크롤링 프로그램에서 보낸 재무제표 데이터를 받아 저장
     */
    @PostMapping
    public ResponseEntity saveFnnSttm(FnncSttmRequsetDto fnncSttmRequsetDto){
        //validate


        FnncSttm fnncSttm = modelMapper.map(fnncSttmRequsetDto, FnncSttm.class);

        //service
        fnncSttmService.save(fnncSttm);

        FnncSttmResponseDto fnncSttmResponseDto = modelMapper.map(fnncSttm, FnncSttmResponseDto.class);



        //response


        return null;
    }


    @Data
    private class FnncSttmRequsetDto {


    }

    private class FnncSttmResponseDto {
    }
}
