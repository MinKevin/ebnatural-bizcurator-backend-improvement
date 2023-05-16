package ebnatural.bizcurator.apiserver.dto.request;

import ebnatural.bizcurator.apiserver.domain.constant.BoardType;
import ebnatural.bizcurator.apiserver.dto.ArticleDto;
import ebnatural.bizcurator.apiserver.dto.MemberDto;
import lombok.Getter;
@Getter
public class ArticleRequest {
    private String title;
    private String content;
    private Boolean isFixed;

    public ArticleRequest() {
    }

    private ArticleRequest(String title, String content, Boolean isFixed) {
        this.title = title;
        this.content = content;
        this.isFixed = isFixed;
    }

    public static ArticleRequest of(String title, String content, Boolean isFixed) {
        return new ArticleRequest(title, content, isFixed);
    }

    public ArticleDto toDto(MemberDto memberDto) {
        return ArticleDto.of(memberDto, title, content, BoardType.NOTICE, isFixed);
    }
}
