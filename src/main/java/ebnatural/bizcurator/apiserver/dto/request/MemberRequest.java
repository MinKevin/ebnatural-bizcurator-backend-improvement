package ebnatural.bizcurator.apiserver.dto.request;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.databind.PropertyNamingStrategy;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import ebnatural.bizcurator.apiserver.domain.Member;
import ebnatural.bizcurator.apiserver.domain.constant.MemberRole;
import ebnatural.bizcurator.apiserver.dto.TokenDto;
import lombok.*;
import org.hibernate.validator.constraints.Length;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.multipart.MultipartFile;

import javax.validation.constraints.Email;
import javax.validation.constraints.Pattern;


@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonNaming(PropertyNamingStrategy.SnakeCaseStrategy.class)
public class MemberRequest {
    private Long id;
    @Email(message = "이메일 형식에 맞지 않습니다.")
    @Length(max = 320, message = "이메일은 320자리를 넘을 수 없습니다.")
    private String username;
    @Pattern(regexp = "[a-zA-Z1-9!@#$%^&*()]{8,16}",
            message = "비밀번호는 영어, 숫자, 특수문자(!@#$%^&*())를 포함한 8~16자리로 입력해주세요.")
    String password;
    String passwordConfirm;
    MemberRole memberRole = MemberRole.ROLE_USER;
    String businessName;
    String representative;
    String businessNumber;
    String postalCode;
    String address;
    String businessRegistration;
    String manager;
    String managerEmail;
    String managerPhoneNumber;

    public static MemberRequest from(Member member, TokenDto tokenDto) {
        MemberRequest memberRequest = new MemberRequest();
        memberRequest.setId(member.getId());
        memberRequest.setUsername(member.getUsername());
        memberRequest.setMemberRole(member.getMemberRole());
        return memberRequest;
    }

    public Member toEntity () {
        return Member.of(username, password, memberRole, businessName, businessNumber, postalCode, address,
                businessRegistration, manager, managerEmail, managerPhoneNumber);
    }
    public void encodePrivacy(BCryptPasswordEncoder passwordEncoder) {
        this.password = passwordEncoder.encode(password);
    }

    public boolean checkPassword() {
        return !password.equals(passwordConfirm);
    }
}
