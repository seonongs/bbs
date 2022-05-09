package io.bbs.repository;

import io.bbs.model.BbsEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BbsRepository extends JpaRepository<BbsEntity, Long> {

}