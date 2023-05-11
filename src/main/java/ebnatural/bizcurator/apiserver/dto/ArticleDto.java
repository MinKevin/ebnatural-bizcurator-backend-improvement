package ebnatural.bizcurator.apiserver.dto;

import com.querydsl.core.annotations.QueryProjection;
import ebnatural.bizcurator.apiserver.domain.Article;
import ebnatural.bizcurator.apiserver.domain.Member;
import ebnatural.bizcurator.apiserver.domain.constant.BoardType;
import lombok.Getter;

@Getter
public class ArticleDto {

    private Long id;
    private MemberDto memberDto;
    private String title;
    private String content;
    private BoardType boardType;

    public ArticleDto() {
    }

    @QueryProjection
    public ArticleDto(Long id, String title, String content) {
        this.id = id;
        this.title = title;
        this.content = content;
    }

    private ArticleDto(MemberDto memberDto, String title, String content, BoardType boardType) {
        this.memberDto = memberDto;
        this.title = title;
        this.content = content;
        this.boardType = boardType;
    }

    public static ArticleDto of(MemberDto memberDto, String title, String content, BoardType boardType) {
        return new ArticleDto(memberDto, title, content, boardType);
    }

    public Article toEntity(Member member) {
        return Article.of(member, title, content, boardType);
    }
}