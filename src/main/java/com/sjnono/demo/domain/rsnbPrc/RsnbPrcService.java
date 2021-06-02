package com.sjnono.demo.domain.rsnbPrc;

import com.sjnono.demo.domain.fnncSttm.FnncSttm;
import com.sjnono.demo.domain.fnncSttm.FnncSttmRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class RsnbPrcService {

    private final RsnbPrcRepository rsnbPrcRepository;

    private final FnncSttmRepository fnncSttmRepository;

    private final RsnbPrcClclMdl rsnbPrcClclMdl;

    public List<RsnbPr> calRsnbPrc(Long fnncSttmId){

        FnncSttm fnncSttm = fnncSttmRepository.findById(fnncSttmId).get();

        List<RsnbPr> rsnbPrList = rsnbPrcClclMdl.calRsnbPrcAll(fnncSttm);


        rsnbPrcRepository.saveAll(rsnbPrList);
        return rsnbPrList;
    }

    public List<RsnbPr> inquiryRsnbPrc(RsnPrcRestController.RscnPrcInquiryRequestDto requestDto) {


        return null;
    }
}
