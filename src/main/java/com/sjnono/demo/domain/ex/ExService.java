package com.sjnono.demo.domain.ex;


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
    public Example insertEx(Example example) {
        return exRepository.save(example);
    }
}
