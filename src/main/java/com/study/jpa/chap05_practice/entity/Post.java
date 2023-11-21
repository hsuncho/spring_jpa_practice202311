package com.study.jpa.chap05_practice.entity;

import lombok.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import java.awt.print.PrinterAbortException;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Getter @Setter
@ToString(exclude = {"hashTags"})
@EqualsAndHashCode(of = "id")
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "tbl_post")
public class Post {

    @Id
    @Column(name = "post_no")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id; // 글 번호

    @Column(nullable = false)
    private String writer; // 작성자

    private String content; // 내용

    @CreationTimestamp
    @Column(updatable = false) // not allowed to be modified after insert
    private LocalDateTime createDate; // 작성 시간

    @UpdateTimestamp
    private LocalDateTime updateDate; // 수정 시간

    @OneToMany(mappedBy = "post")
    private List<HashTag> hashTags = new ArrayList<>();



}
