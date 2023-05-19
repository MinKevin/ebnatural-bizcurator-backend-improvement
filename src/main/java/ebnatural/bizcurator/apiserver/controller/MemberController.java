package ebnatural.bizcurator.apiserver.controller;

import ebnatural.bizcurator.apiserver.dto.MemberDto;
import ebnatural.bizcurator.apiserver.dto.TokenDto;
import ebnatural.bizcurator.apiserver.dto.request.LoginRequest;
import ebnatural.bizcurator.apiserver.dto.request.MemberRequest;
import ebnatural.bizcurator.apiserver.dto.request.UpdateMemberRequest;
import ebnatural.bizcurator.apiserver.dto.response.CommonResponse;
import ebnatural.bizcurator.apiserver.service.MemberAuthService;
import ebnatural.bizcurator.apiserver.service.MemberService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

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
     * @param loginDto
     * @return
     * @throws Exception
     */
    @PostMapping("/login")
    public ResponseEntity<CommonResponse> login(@Valid @RequestBody LoginRequest loginDto) throws Exception {
        MemberDto member = memberAuthService.login(loginDto);
        Map<String, Object> mp = new HashMap<>();
        mp.put("login", member);
        return CommonResponse.ok(HttpStatus.OK.value(), "login Success", mp);
    }

    /**
     * accessToken에 담긴 유저정보를 꺼내서 refresh token을 지워준다.
     *
     * @param accessToken 엑세스 토큰
     * @return
     */
    @PostMapping("/logout")
    public ResponseEntity<CommonResponse> logout(@RequestBody Map<String, String> accessToken) {
        return CommonResponse.ok(HttpStatus.OK.value(), "logout success",
                Map.of("result", (Object) (memberAuthService.logout(accessToken.get("accessToken")))));
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
        return CommonResponse.ok(HttpStatus.OK.value(), "refresh success", mp);
    }

    /**
     * 전체 회원 정보 조회(관리자만 가능)
     * todo
     * 사업자 등록증 확인을 원할 시 따로 처리해야됨
     * https://www.sunny-son.space/spring/Springboot%EB%A1%9C%20S3%20%ED%8C%8C%EC%9D%BC%20%EC%97%85%EB%A1%9C%EB%93%9C/
     *
     * @return
     */
    @GetMapping()
    public ResponseEntity<CommonResponse> getAllMember() {
        return CommonResponse.ok(HttpStatus.OK.value(), "get all member info success",
                Map.of("result", (memberService.getAllMember())));
    }

    /**
     * 회원정보 수정 페이지에 기본값을 채워주기 위한
     * 로그인한 사용자의 개인 정보 조회
     *
     * @return
     */
    @GetMapping("/check")
    public ResponseEntity<CommonResponse> getMyInfo() {
        return CommonResponse.ok(HttpStatus.OK.value(), "getInfo success",
                Map.of("info", (memberService.getMyInfo())));
    }

    @PostMapping("/signup")
    public ResponseEntity<CommonResponse> signup(@Valid @RequestPart(value = "post", required = true) MemberRequest memberDto,
                                                 @RequestPart(value = "image", required = true) MultipartFile image) {
        memberService.signup(memberDto, image);
        return CommonResponse.ok(HttpStatus.CREATED.value(), "signup success");
    }

    @PatchMapping
    public ResponseEntity<CommonResponse> updateMember(@Valid @RequestPart(value = "post", required = true) UpdateMemberRequest memberDto,
                                                       @RequestPart(value = "image") MultipartFile image) {
        memberService.updateMember(memberDto, image);
        return CommonResponse.ok(HttpStatus.CREATED.value(), "update success");
    }

    @DeleteMapping
    public ResponseEntity<CommonResponse> deleteMember() {
        memberService.delete();

        return CommonResponse.ok(HttpStatus.OK.value(), "deleteMember success");
    }
}
