package io.bbs.controller;

import io.bbs.model.BbsEntity;
import io.bbs.model.BbsResult;
import io.bbs.service.BbsService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Optional;

@CrossOrigin(origins = "*")
@RestController
@RequiredArgsConstructor
@RequestMapping(value = "/api/bbs")
public class BbsController {
    private final BbsService bbsService;

    @PostMapping
    public BbsEntity create(@Valid @RequestBody BbsEntity bbs) {
        return bbsService.create(bbs);
    }
    @GetMapping("")
    public Page<BbsEntity> findByTitleContains(String keyword, Pageable pageable) {
        return bbsService.findByTitleContains(keyword, pageable);
    }
    @GetMapping("/{id}")
    public Optional<BbsEntity> read(@PathVariable(value = "id") Long id) {
        return bbsService.findById(id);
    }
    @PatchMapping("/{id}")
    public BbsResult update(@PathVariable(value = "id") Long id, @Valid @RequestBody BbsResult bbsResult) {
        return bbsService.update(id, bbsResult);
    }
    @DeleteMapping("/{id}")
    public BbsEntity delete (@PathVariable(value = "id") Long id) {
        return bbsService.delete(id);
    }

}

