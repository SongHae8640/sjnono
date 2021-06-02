package com.sjnono.demo.domain.rsnbPrc;

import java.util.List;

public interface RsnbPrcRepositoryCustom {

    List<RsnbPr> findByConditions(RsnPrcRestController.RscnPrcInquiryRequestDto requestDto);
}
