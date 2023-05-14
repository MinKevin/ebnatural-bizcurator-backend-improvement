package ebnatural.bizcurator.apiserver.dto.request;

import ebnatural.bizcurator.apiserver.domain.constant.BoardType;
import ebnatural.bizcurator.apiserver.dto.ArticleDto;
import ebnatural.bizcurator.apiserver.dto.MemberDto;
import lombok.Getter;

@Getter
public class ArticleRequest {
    private String title;
    private String content;

    public ArticleRequest() {
    }

    private ArticleRequest(String title, String content) {
        this.title = title;
        this.content = content;
    }

    public static ArticleRequest of(String title, String content) {
        return new ArticleRequest(title, content);
    }

    public ArticleDto toDto(MemberDto memberDto) {
        return ArticleDto.of(memberDto, title, content, BoardType.NOTICE);
    }
}
