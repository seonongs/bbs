package io.bbs.service;

import io.bbs.exception.ResourceNotFoundException;
import io.bbs.model.BbsEntity;
import io.bbs.model.BbsResult;
import io.bbs.repository.BbsRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
@Transactional
public class BbsService {

    private final BbsRepository bbsRepository;

    public BbsService(BbsRepository bbsRepository) {
        this.bbsRepository = bbsRepository;
    }

    public BbsEntity create(BbsEntity bbs) {
        return bbsRepository.save(bbs);
    }

    public Page<BbsEntity> read(Pageable pageable) {
        return bbsRepository.findAll(pageable);
    }

    public Optional<BbsEntity> findById(Long id) {
        return bbsRepository.findById(id);
    }

    public BbsResult update(Long id, BbsResult bbsResult) {

        BbsEntity bbsEntity = bbsRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("등록된 글이 없습니다."));;
        BbsEntity saveBbs = bbsEntity.updateBbs(id, bbsResult);

        return BbsResult.builder()
                .id(saveBbs.getId())
                .title(saveBbs.getTitle())
                .content(saveBbs.getContent())
                .build();
    }

    public BbsEntity delete(Long id) {
        BbsEntity bbs = bbsRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("BBS", "id", id));
        bbsRepository.delete(bbs);
        return bbs;
    }

    public Page<BbsEntity> findByTitleContains(String keyword, Pageable pageable) {
        return bbsRepository.findByTitleContains(keyword, pageable);
    }
}
