package ebnatural.bizcurator.apiserver.domain;

import ebnatural.bizcurator.apiserver.domain.constant.MemberRole;
import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.Pattern;
import java.time.LocalDate;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

@ToString(callSuper = true)
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Entity
@Getter
public class Member extends TimeEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    String username;
    String password;
    @Column(name = "member_role", columnDefinition = "ENUM('ROLE_USER', 'ROLE_ADMIN')")
    @Enumerated(EnumType.STRING)
    private MemberRole memberRole;
    String representative;
    String businessName;
    String businessNumber;
    String postalCode;
    String address;
    String businessRegistration;
    String manager;
    String managerEmail;
    String managerPhoneNumber;

    @ToString.Exclude
    @OneToMany(fetch = FetchType.LAZY)
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
                            String managerPhoneNumber) {
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
