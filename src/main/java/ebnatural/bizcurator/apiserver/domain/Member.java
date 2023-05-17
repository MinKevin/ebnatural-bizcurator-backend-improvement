package ebnatural.bizcurator.apiserver.domain;

import ebnatural.bizcurator.apiserver.domain.constant.MemberRole;
import ebnatural.bizcurator.apiserver.domain.constant.TimeEntity;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
import java.time.LocalDate;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;


@Entity
@Getter
public class Member extends TimeEntity{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(length = 15)
    @Size(min = 2, max = 15)
    String username;
    @Pattern(regexp="[a-zA-Z1-9!@#$%^&*()]{8,16}",
    message = "비밀번호는 영어, 숫자, 특수문자(!@#$%^&*())를 포함한 8~16자리로 입력해주세요.")
    String password;
    @Column(name = "member_role", columnDefinition = "ENUM('ROLE_USER', 'ROLE_ADMIN')")
    @Enumerated(EnumType.STRING)
    private MemberRole memberRole;
    @Column(nullable = false)
    String businessName;
    @Column(nullable = false)
    String businessNumber;
    @Column(nullable = false)
    String postalCode;
    @Column(nullable = false)
    String address;
    @Column(nullable = false)
    String businessRegistration;
    String manager;
    String managerEmail;
    String managerPhoneNumber;

    @OneToMany(fetch=FetchType.LAZY)
    @JoinColumn(name = "order_detail_id")
    private List<OrderDetail> orderDetail;

    @OrderBy("loginTime DESC")
    @JoinColumn(name = "member_login_logs_id")
    @OneToMany(cascade = CascadeType.ALL)
    private final Set<MemberLoginLog> memberLoginLogs = new LinkedHashSet<>();

    // todo: 로그인 기능 머지되면 삭제 예정
    @Column
    LocalDate lastLoginTime = LocalDate.now();

    @Setter
    @Column
    private String refreshToken;
    private Member(String username, String password, MemberRole memberRole, String businessName, String businessNumber, String postalCode, String address,
                  String businessRegistration, String manager, String managerEmail, String managerPhoneNumber) {
        this.username = username;
        this.password = password;
        this.memberRole = memberRole;
        this.businessName = businessName;
        this.businessNumber = businessNumber;
        this.postalCode = postalCode;
        this.address = address;
        this.businessRegistration = businessRegistration;
        this.manager = manager;
        this.managerEmail = managerEmail;
        this.managerPhoneNumber = managerPhoneNumber;
    }

    public Member() {}


    public static Member of(String username,
                            String password,
                            MemberRole memberRole,
                            String businessName,
                            String businessNumber,
                            String postalCode,
                            String address,
                            String businessRegistration,
                            String manager,
                            String managerEmail,
                            String managerPhoneNumber){
        return new Member(username,
                password,
                memberRole,
                businessName,
                businessNumber,
                postalCode,
                address,
                businessRegistration,
                manager,
                managerEmail,
                managerPhoneNumber);
    }
}
