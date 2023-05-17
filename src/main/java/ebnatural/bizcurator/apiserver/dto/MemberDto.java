package ebnatural.bizcurator.apiserver.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.databind.PropertyNamingStrategy;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import ebnatural.bizcurator.apiserver.domain.Member;
import ebnatural.bizcurator.apiserver.domain.constant.MemberRole;
import lombok.*;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import javax.validation.constraints.Pattern;


@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonNaming(PropertyNamingStrategy.SnakeCaseStrategy.class)
public class MemberDto {
    private Long id;
    @Pattern(regexp = "^[a-zA-Z0-9+-\\_.]+@[a-zA-Z0-9-]+\\.[a-zA-Z0-9-.]+$",
            message = "이메일을 올바르게 작성해주세요.")
    @NonNull
    private String username;
    @Pattern(regexp = "[a-zA-Z1-9!@#$%^&*()]{8,16}",
            message = "비밀번호는 영어, 숫자, 특수문자(!@#$%^&*())를 포함한 8~16자리로 입력해주세요.")
    @NonNull
    String password;
    @NonNull
    String passwordConfirm;
    @NonNull
    MemberRole memberRole = MemberRole.ROLE_USER;
    @NonNull
    String businessName;
    @NonNull
    String businessNumber;
    @NonNull
    String postalCode;
    @NonNull
    String address;
    @NonNull
    String businessRegistration;
    @NonNull
    String manager;
    @NonNull
    String managerEmail;
    @NonNull
    String managerPhoneNumber;

    private TokenDto tokenDto;

    public static MemberDto from(Member member, TokenDto tokenDto) {
        MemberDto memberDto = new MemberDto();
        memberDto.setId(member.getId());
        memberDto.setUsername(member.getUsername());
        memberDto.setMemberRole(member.getMemberRole());
        memberDto.setTokenDto(tokenDto);
        return memberDto;
    }

    public Member toEntity () {
        return Member.of(username, password, memberRole, businessName, businessNumber, postalCode, address,
                businessRegistration, manager, managerEmail, managerPhoneNumber);
    }
    public void encodePrivacy(BCryptPasswordEncoder passwordEncoder) {
        this.password = passwordEncoder.encode(password);
    }

    //아래는 by 슬찬
    private MemberDto(Long id) {
        this.id = id;
    }

    public static MemberDto of(Long id) {
        return new MemberDto(id);
    }
}
