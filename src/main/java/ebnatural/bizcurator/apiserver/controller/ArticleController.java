package ebnatural.bizcurator.apiserver.controller;

import ebnatural.bizcurator.apiserver.domain.constant.BoardType;
import ebnatural.bizcurator.apiserver.dto.ArticleDto;
import ebnatural.bizcurator.apiserver.dto.MemberDto;
import ebnatural.bizcurator.apiserver.dto.request.ArticleRequest;
import ebnatural.bizcurator.apiserver.dto.response.ArticleResponse;
import ebnatural.bizcurator.apiserver.service.ArticleService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RestController
@RequiredArgsConstructor
public class ArticleController {

    private final ArticleService articleService;

    @GetMapping("/api/testaws")
    public ResponseEntity<ArticleResponse> testAws() {
        return ArticleResponse.ok("공지사항 조회가 완료되었습니다.", null);
    }

    @GetMapping("/api/notices")
    public ResponseEntity<ArticleResponse> getNoticesLowerThanId(@RequestParam("lastArticleId") Long lastArticleId, @RequestParam("size") Integer size) {
        List<ArticleDto> notices = articleService.fetchArticlePagesBy(lastArticleId, BoardType.NOTICE, size);
        return ArticleResponse.ok("공지사항 조회가 완료되었습니다.", notices);
    }

    @GetMapping("/api/faqs")
    public ResponseEntity<ArticleResponse> getFaqsLowerThanId(@RequestParam("lastArticleId") Long lastArticleId, @RequestParam("size") Integer size) {
        List<ArticleDto> faqs = articleService.fetchArticlePagesBy(lastArticleId, BoardType.FAQ, size);
        return ArticleResponse.ok("자주 묻는 질문 조회가 완료되었습니다.", faqs);
    }

    @PostMapping("/api/notices")
    public ResponseEntity<ArticleResponse> postNewNotice(@RequestBody ArticleRequest articleRequest) {
        // TODO: 로그인 완성되면 MemberDto.of() 수정
        articleService.saveArticle(articleRequest.toDto(MemberDto.of(1L)));
        return ArticleResponse.ok("공지사항 등록이 완료되었습니다.");
    }

    @PutMapping("/api/notices/{articleId}")
    public ResponseEntity<ArticleResponse> updateNotice(@PathVariable("articleId") Long articleId, @RequestBody ArticleRequest articleRequest) {
        // TODO: 로그인 완성되면 MemberDto.of() 수정
        articleService.updateArticle(articleId, articleRequest.toDto(MemberDto.of(1L)));
        return ArticleResponse.ok("공지사항 수정이 완료되었습니다.");
    }

    @DeleteMapping("/api/notices/{articleId}")
    public ResponseEntity<ArticleResponse> deleteNotice(@PathVariable("articleId") Long articleId) {
        articleService.deleteArticle(articleId);
        return ArticleResponse.ok("공지사항 삭제가 완료되었습니다.");
    }
}
