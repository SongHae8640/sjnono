package com.sjnono.demo.domain.stckPrc;


import java.util.List;

public interface StckPrcRepositoryCustom {

    public List<StckPrc> findAllByStandardCode(String standardCode);
}
