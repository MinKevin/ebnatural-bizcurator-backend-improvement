package ebnatural.bizcurator.apiserver.controller;

import ebnatural.bizcurator.apiserver.common.exception.custom.ErrorCode;
import ebnatural.bizcurator.apiserver.common.exception.custom.FieldValidationException;
import ebnatural.bizcurator.apiserver.common.util.MemberUtil;
import ebnatural.bizcurator.apiserver.dto.TokenDto;
import ebnatural.bizcurator.apiserver.dto.MemberDto;
import ebnatural.bizcurator.apiserver.dto.response.CommonResponse;
import ebnatural.bizcurator.apiserver.service.MemberAuthService;
import ebnatural.bizcurator.apiserver.service.MemberService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.HashMap;
import java.util.Map;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/users")
public class MemberController {
    private final MemberService memberService;
    private final MemberAuthService memberAuthService;

    /**
     * 로그인 시 access 토큰, refresh 토큰 모두 새로 만들어준다.
     *
     * @param user
     * @return
     * @throws Exception
     */
    @PostMapping("/login")
    public ResponseEntity<CommonResponse> login(@Valid @RequestBody MemberDto user, BindingResult bindingResult) throws Exception {
        if (bindingResult.hasErrors())
            throw new FieldValidationException(ErrorCode.FIELD_VALIDATION_FAILED);

        MemberDto member = memberAuthService.login(user);
        Map<String, Object> mp = new HashMap<>();
        mp.put("login", member);
        return CommonResponse.ok(200, "login Success", mp);
    }

    /**
     * access토큰 내부의 유저 정보를 확인한 후 access 토큰 새로 만들어준다.
     *
     * @param accessToken 엑세스 토큰
     * @return
     * @throws Exception
     */
    @PostMapping("/refresh")
    public ResponseEntity<CommonResponse> refresh(@RequestBody Map<String, String> accessToken) throws Exception {
        Map<String, Object> mp = new HashMap<>();
        TokenDto tokenDto = memberAuthService.refreshToken(accessToken.get("accessToken"));
        mp.put("result", tokenDto);
        return CommonResponse.ok(200, "refresh success", mp);
    }

    /**
     * accessToken에 담긴 유저정보를 꺼내서 refresh token을 지워준다.
     *
     * @param accessToken 엑세스 토큰
     * @return
     */
    @PostMapping("/logout")
    public ResponseEntity<CommonResponse> logout(@RequestBody Map<String, String> accessToken) {
        return CommonResponse.ok(200, "logout success",
                Map.of("result", (Object)(memberAuthService.logout(accessToken.get("accessToken")))));
    }

    @PostMapping("/signup")
    public ResponseEntity<CommonResponse> signup(@Valid @RequestBody MemberDto memberDto, BindingResult bindingResult) throws Exception {
        if (bindingResult.hasErrors()) {
            throw new IllegalArgumentException();
        }
        return CommonResponse.ok(200, "signup success",
                Map.of("result", (Object)(memberService.signup(memberDto))));
    }
}
