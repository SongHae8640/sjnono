package com.sjnono.demo.domain.stckPrc;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/stckPrc")
@RequiredArgsConstructor
public class StckPrcRestController {

    private final StckPrcService stckPrcService;

    @PostMapping
    public ResponseEntity saveStockPrc(SaveStockPrcDto saveStockPrcDtp){

        //TODO dto to entity
        StckPrc stckPrc = null;

        this.stckPrcService.saveStckPrc(stckPrc);

        return null;
    }

    private class SaveStockPrcDto{


    }
}
