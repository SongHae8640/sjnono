package com.sjnono.demo.domain.ex.controller;

import com.sjnono.demo.domain.ex.service.ExService;
import com.sjnono.demo.domain.ex.validation.ExValidator;
import com.sjnono.demo.domain.ex.entity.Example;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.hateoas.EntityModel;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.*;

@RestController
@RequestMapping("/api/ex")
@RequiredArgsConstructor
public class ExRestController {

    private final ExService exService;
    private final ExValidator exValidator;

    @GetMapping("/{exId}")
    public ResponseEntity getExampleOne(@PathVariable Long exId) {
        exValidator.getOneValidate(exId);

        Example example = exService.findById(exId);

        ExampleDto exampleDto = new ExampleDto(example.getStock().getStandardCode(), example.getStock().getKoreanStockName());

        EntityModel<ExampleDto> model = EntityModel.of(exampleDto)
                .add(linkTo(methodOn(ExRestController.class).getExampleOne(exId)).withSelfRel());
        return ResponseEntity.ok(model);
    }

    @Data
    @AllArgsConstructor
    static class ExampleDto {
        private String standardCode;
        private String koreanStockName;
    }

    // TODO getExampleList 리팩터링 필요
    @GetMapping
    public ResponseEntity getExampleList(@PageableDefault(sort = "id", direction = Sort.Direction.ASC, size = 3)
                                                 Pageable pageable) {
        this.exValidator.getListValidate(pageable);

        Page<Example> search = this.exService.search(pageable);

        EntityModel<Page<Example>> model = EntityModel.of(search)
                .add(linkTo(this.getClass()).withSelfRel());

        return ResponseEntity.ok(model);
    }

    @PostMapping
    public ResponseEntity saveExample(@RequestBody SaveExampleRequest request) {
        exValidator.saveValidate(request.getStandardCode());

        Example savedExample = exService.insertEx(request.getStandardCode());

        // Entity to Dto
        SaveExampleResponse response = new SaveExampleResponse(
                savedExample.getStock().getStandardCode(),
                savedExample.getStock().getKoreanStockName());
        // create HATEOAS
        EntityModel<SaveExampleResponse> model = EntityModel.of(response)
                .add(linkTo(ExRestController.class).slash(savedExample.getId()).withSelfRel());
        return ResponseEntity.ok(model);
    }

    @Data
    static class SaveExampleRequest {
        private String standardCode;
    }

    @Data @AllArgsConstructor
    static class SaveExampleResponse {
        private String standardCode;
        private String koreanStockName;
    }

}
