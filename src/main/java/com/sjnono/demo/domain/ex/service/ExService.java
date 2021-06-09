package com.sjnono.demo.domain.ex.service;


import com.sjnono.demo.domain.ex.controller.ExRestController;
import com.sjnono.demo.domain.ex.entity.Example;
import com.sjnono.demo.domain.ex.repository.ExRepository;
import com.sjnono.demo.domain.stock.Stock;
import com.sjnono.demo.domain.stock.StockRepository;
import com.sjnono.demo.domain.stock.StockService;
import com.sjnono.demo.global.error.exception.NotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class ExService {

    private final ExRepository exRepository;
    private final StockRepository stockRepository;

    public Example findById(Long exId) {
        Example byIdJoinStock = exRepository.findByIdJoinStock(exId);
        if (byIdJoinStock == null) {
            throw new NotFoundException(
                    linkTo(methodOn(ExRestController.class).getExampleOne(exId)).withSelfRel()
            );
        }
        return byIdJoinStock;
    }

    public Page<Example> search(Pageable pageable) {
        return exRepository.search(pageable);
    }

    @Transactional
    public Example insertEx(String standardCode) {
        Stock findStock = stockRepository.findById(standardCode)
                .orElseThrow(() -> {
                    throw new NotFoundException(
                            linkTo(ExRestController.class).withSelfRel());
                });

        Example example = Example.createExample(findStock);
        return exRepository.save(example);
    }
}
