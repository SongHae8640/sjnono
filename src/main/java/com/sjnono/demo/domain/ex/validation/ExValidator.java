package com.sjnono.demo.domain.ex.validation;

import com.sjnono.demo.domain.ex.controller.ExRestController;
import com.sjnono.demo.global.error.exception.BadRequestException;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Component;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

@Component
public class ExValidator {
    public void getOneValidate(Long exId) {
        if (exId == null || exId <= 0 ){
            throw new BadRequestException(
                    linkTo(methodOn(ExRestController.class).getExampleOne(exId)).withSelfRel()
            );
        }
    }

    public void getListValidate(Pageable pageable) {
        if(pageable.getPageNumber() <1){

        }
    }

    public void saveValidate(String standardCode) {
        // Validation
    }
}
