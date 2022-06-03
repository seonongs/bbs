package io.bbs.model;

import lombok.*;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;

import javax.persistence.*;
import java.time.LocalDateTime;

@Data
@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "bbs")
public class BbsEntity {

    @Id @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long id;
    private String title;
    private String content;
    private String writer;

    @CreatedDate
    private LocalDateTime createdDate = LocalDateTime.now();

    @LastModifiedDate
    private LocalDateTime modifiedDate = LocalDateTime.now();

    public BbsEntity updateBbs(Long id, BbsResult bbsResult) {

        this.id = id;
        this.title = bbsResult.getTitle();
        this.content = bbsResult.getContent();
        this.writer = bbsResult.getWriter();
        this.modifiedDate = LocalDateTime.now();

        return this;

    }

}
