package ebnatural.bizcurator.apiserver.controller;

import ebnatural.bizcurator.apiserver.dto.request.MemberRequest;
import ebnatural.bizcurator.apiserver.service.MemberService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/users")
public class MemberController {
    private final MemberService memberService;

    @PostMapping("/signup")
    public ResponseEntity signup(@Valid @RequestBody MemberRequest memberRequest, BindingResult bindingResult) throws Exception {
        if (bindingResult.hasErrors()){
            throw new Exception("안됨");
        }

        memberService.signup(memberRequest);
        return new ResponseEntity(HttpStatus.OK);
    }
}
