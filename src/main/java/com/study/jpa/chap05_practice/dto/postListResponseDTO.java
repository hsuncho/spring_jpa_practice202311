package com.study.jpa.chap05_practice.dto;

import lombok.*;

import java.util.List;

@Setter @Getter
@ToString @EqualsAndHashCode
@NoArgsConstructor @AllArgsConstructor
@Builder
public class postListResponseDTO { // DTO for return post list
    
    private int count; // 총 게시물 수
    private PageResponseDTO pageInfo; // 페이지 렌더링 정보(시작 페이지, 이전 다음 버튼 등)
    private List<PostDetailResponseDTO> posts; // 게시물 렌더링 정보

}
