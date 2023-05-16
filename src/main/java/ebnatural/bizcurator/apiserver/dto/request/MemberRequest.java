package ebnatural.bizcurator.apiserver.dto.request;

import ebnatural.bizcurator.apiserver.domain.Member;
import ebnatural.bizcurator.apiserver.domain.constant.MemberRole;
import lombok.*;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import javax.validation.constraints.Pattern;


@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class MemberRequest {
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

    public Member toEntity () {
        return Member.of(username, password, memberRole, businessName, businessNumber, postalCode, address,
                businessRegistration, manager, managerEmail, managerPhoneNumber);
    }
    public void encodePrivacy(BCryptPasswordEncoder passwordEncoder) {
        this.password = passwordEncoder.encode(password);
    }
}
