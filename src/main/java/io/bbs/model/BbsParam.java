package io.bbs.model;

import lombok.*;

import java.time.LocalDateTime;

@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
public class BbsParam {

    Long id;
    String title;
    String content;
    private String writer;
    private LocalDateTime createdDate;
    private LocalDateTime modifiedDate;

}
