package ebnatural.bizcurator.apiserver.domain;

import ebnatural.bizcurator.apiserver.domain.constant.MemberType;
import ebnatural.bizcurator.apiserver.domain.constant.TimeEntity;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.lang.Nullable;

import javax.persistence.*;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
import java.time.LocalDate;
import java.util.Date;
import java.util.List;


@Entity
@RequiredArgsConstructor
@Getter
public class Member extends TimeEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(length = 15)
    @Size(min = 2, max = 15)
    String username;

    @Pattern(regexp="[a-zA-Z1-9!@#$%^&*()]{8,16}",
    message = "비밀번호는 영어, 숫자, 특수문자(!@#$%^&*())를 포함한 8~16자리로 입력해주세요.")
    String password;

    @Column(name = "role", columnDefinition = "ENUM('ROLE_USER', 'ROLE_ADMIN')")
    @Enumerated(EnumType.STRING)
    private MemberType memberType;

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
}
