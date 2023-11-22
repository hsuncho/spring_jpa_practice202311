package com.study.jpa.chap05_practice.dto;

import com.study.jpa.chap05_practice.entity.Post;
import lombok.*;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.util.List;

@Setter @Getter
@ToString @EqualsAndHashCode
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class PostCreateDTO {

    // use Command Object
    // JSON type data's name should correspond with field name of PostCreateDTO

    // Validation(dependency) provides annotation - @NotBlank, @Size, etc
    
    // @NotNull -> null을 허용하지 않음. "", " "은 허용
    // @NotEmpty -> null, ""을 허용하지 않음. " "은 허용
    @NotBlank // -> null, "", " " 모두를 허용하지 않음
    @Size(min = 2, max = 5)
    private String writer;

    @NotBlank
    @Size(min = 1, max = 20)
    private String title;

    private String content;

    private List<String> hashTags;

    // DTO를 엔터티로 변환하는 메서드(return 해야 함)
    public Post toEntity() {
        return Post.builder()
                .writer(this.writer)
                .content(this.content)
                .title(this.title)
                // 해시태그는 여기서 넣는 게 아니에요~
                .build();
    }


}
