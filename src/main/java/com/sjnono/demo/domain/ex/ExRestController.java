package com.sjnono.demo.domain.ex;

import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.server.mvc.WebMvcLinkBuilder;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.*;

@RestController
@RequestMapping("/api/ex")
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


    @GetMapping
    public ResponseEntity getExampleList(@PageableDefault(sort = "id", direction = Sort.Direction.ASC, size = 3)Pageable pageable){
        this.exValidator.getListValidate(pageable);

        Page<Example> search = this.exService.search(pageable);

        EntityModel<Page<Example>> model = EntityModel.of(search).add(linkTo(this.getClass()).withSelfRel());

        return ResponseEntity.ok(model);
    }


}
