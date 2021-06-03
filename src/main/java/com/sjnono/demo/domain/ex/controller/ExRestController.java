package com.sjnono.demo.domain.ex.controller;

import com.sjnono.demo.domain.ex.entity.Example;
import com.sjnono.demo.domain.ex.service.ExService;
import com.sjnono.demo.domain.ex.validation.ExValidator;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.data.web.PagedResourcesAssembler;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.PagedModel;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static java.util.stream.Collectors.toList;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

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

    @GetMapping
    public ResponseEntity getExampleAll(@PageableDefault(sort = "id", direction = Sort.Direction.ASC, size = 3)
                                                Pageable pageable, PagedResourcesAssembler<ExampleAllResponse> assembler) {
        exValidator.getListValidate(pageable);

        Page<Example> search = exService.search(pageable);

        // convert to ExampleAllResponse
        List<ExampleAllResponse> toDto = search.getContent()
                .stream()
                .map(example -> new ExampleAllResponse(example.getId(), example.getStock().getStandardCode(), example.getStock().getKoreanStockName()))
                .collect(toList());

        // create HATEOAS
        PagedModel<EntityModel<ExampleAllResponse>> entityModels =
                assembler.toModel(new PageImpl<>(toDto, search.getPageable(), search.getTotalElements()),
                        entity -> EntityModel.of(entity)
                                .add(linkTo(ExRestController.class).slash(entity.getId()).withSelfRel()));
        return ResponseEntity.ok(entityModels);
    }

    @Data
    @AllArgsConstructor
    static class ExampleAllResponse {
        private Long id;
        private String standardCode;
        private String koreanStockName;
    }


    @PostMapping
    public ResponseEntity saveExample(@RequestBody SaveExampleRequest request) {
        exValidator.saveValidate(request.getStandardCode());

        Example savedExample = exService.insertEx(request.getStandardCode());

        // Entity to Dto
        SaveExampleResponse response = new SaveExampleResponse(savedExample.getStock().getStandardCode(),
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

    @Data
    @AllArgsConstructor
    static class SaveExampleResponse {
        private String standardCode;
        private String koreanStockName;
    }

}
