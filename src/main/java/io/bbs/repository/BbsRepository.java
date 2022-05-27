package io.bbs.repository;

import io.bbs.model.BbsEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Optional;

public interface BbsRepository extends JpaRepository<BbsEntity, Long> {
    Page<BbsEntity> findByTitleContains(String keyword, Pageable pageable);

}
