package com.sjnono.demo.domain.ex;

import lombok.RequiredArgsConstructor;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.server.mvc.WebMvcLinkBuilder;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.*;

@RestController
@RequestMapping("/ex")
@RequiredArgsConstructor
public class ExRestController {

    private final ExService exService;
    private final ExValidator exValidator;

//    @GetMapping
//    public ResponseEntity getExamples(){
//
//        return null;
//    }


    @GetMapping("/{exId}")
    public ResponseEntity getExampleOne(@PathVariable Long exId){
        this.exValidator.getOneValidate(exId);

        Example example = this.exService.findById(exId);


        EntityModel<Example> model = EntityModel.of(example).add(linkTo(this.getClass()).slash(example.id).withSelfRel());


        return ResponseEntity.ok(model);
    }


}
