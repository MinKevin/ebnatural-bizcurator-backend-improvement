package ebnatural.bizcurator.apiserver.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.querydsl.core.annotations.QueryProjection;
import ebnatural.bizcurator.apiserver.domain.Article;
import ebnatural.bizcurator.apiserver.domain.Member;
import ebnatural.bizcurator.apiserver.domain.constant.BoardType;
import lombok.Getter;

import java.time.LocalDateTime;

@Getter
public class ArticleDto {

    private Long id;
    private MemberDto memberDto;
    private String title;
    private String content;
    private BoardType boardType;
    private Boolean isFixed;
    @JsonFormat(pattern = "yyyy-MM-dd")
    private LocalDateTime createdAt;

    public ArticleDto() {
    }

    @QueryProjection
    public ArticleDto(Long id, String title, String content, Boolean isFixed, LocalDateTime createdAt) {
        this.id = id;
        this.title = title;
        this.content = content;
        this.isFixed = isFixed;
        this.createdAt = createdAt;
    }

    private ArticleDto(MemberDto memberDto, String title, String content, BoardType boardType, Boolean isFixed) {
        this.memberDto = memberDto;
        this.title = title;
        this.content = content;
        this.boardType = boardType;
        this.isFixed = isFixed;
    }

    public static ArticleDto of(MemberDto memberDto, String title, String content, BoardType boardType, Boolean isFixed) {
        return new ArticleDto(memberDto, title, content, boardType, isFixed);
    }

    public Article toEntity(Member member) {
        return Article.of(member, title, content, boardType, isFixed);
    }
}