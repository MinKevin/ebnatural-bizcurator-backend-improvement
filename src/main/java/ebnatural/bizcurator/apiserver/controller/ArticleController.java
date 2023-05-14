package ebnatural.bizcurator.apiserver.controller;

import ebnatural.bizcurator.apiserver.domain.constant.BoardType;
import ebnatural.bizcurator.apiserver.dto.ArticleDto;
import ebnatural.bizcurator.apiserver.dto.MemberDto;
import ebnatural.bizcurator.apiserver.dto.request.ArticleRequest;
import ebnatural.bizcurator.apiserver.dto.response.CommonResponse;
import ebnatural.bizcurator.apiserver.service.ArticleService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;

@Slf4j
@RestController
@RequiredArgsConstructor
public class ArticleController {

    private final ArticleService articleService;

    @GetMapping("/api/notices")
    public ResponseEntity<CommonResponse> getNoticesLowerThanId(@RequestParam("lastArticleId") Long lastArticleId, @RequestParam("size") Integer size) {
        List<ArticleDto> notices = articleService.fetchArticlePagesBy(lastArticleId, BoardType.NOTICE, size);
        HashMap<String, Object> noticeMap = new HashMap<>();
        noticeMap.put("notices", notices);
        return CommonResponse.ok(HttpStatus.OK.value(), "공지사항 조회가 완료되었습니다.", noticeMap);
    }

    @GetMapping("/api/faqs")
    public ResponseEntity<CommonResponse> getFaqsLowerThanId(@RequestParam("lastArticleId") Long lastArticleId, @RequestParam("size") Integer size) {
        List<ArticleDto> faqs = articleService.fetchArticlePagesBy(lastArticleId, BoardType.FAQ, size);
        HashMap<String, Object> faqsMap = new HashMap<>();
        faqsMap.put("faqs", faqs);
        return CommonResponse.ok(HttpStatus.OK.value(), "자주 묻는 질문 조회가 완료되었습니다.", faqsMap);
    }

    @PostMapping("/api/notices")
    public ResponseEntity<CommonResponse> postNewNotice(@RequestBody ArticleRequest articleRequest) {
        // TODO: 로그인 완성되면 MemberDto.of() 수정
        articleService.saveArticle(articleRequest.toDto(MemberDto.of(1L)));
        return CommonResponse.ok(HttpStatus.OK.value(), "공지사항 등록이 완료되었습니다.");
    }

    @PutMapping("/api/notices/{articleId}")
    public ResponseEntity<CommonResponse> updateNotice(@PathVariable("articleId") Long articleId, @RequestBody ArticleRequest articleRequest) {
        // TODO: 로그인 완성되면 MemberDto.of() 수정
        articleService.updateArticle(articleId, articleRequest.toDto(MemberDto.of(1L)));
        return CommonResponse.ok(HttpStatus.OK.value(), "공지사항 수정이 완료되었습니다.");
    }

    @DeleteMapping("/api/notices/{articleId}")
    public ResponseEntity<CommonResponse> deleteNotice(@PathVariable("articleId") Long articleId) {
        articleService.deleteArticle(articleId);
        return CommonResponse.ok(HttpStatus.OK.value(), "공지사항 삭제가 완료되었습니다.");
    }
}
