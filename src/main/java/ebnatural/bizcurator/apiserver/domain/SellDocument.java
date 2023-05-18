package ebnatural.bizcurator.apiserver.domain;

import com.amazonaws.services.ec2.model.StatusType;
import ebnatural.bizcurator.apiserver.domain.constant.StateType;
import lombok.Getter;
import lombok.ToString;

import javax.persistence.*;

@Entity
@Getter
public class SellDocument {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @JoinColumn(name = "member_id")
    @ManyToOne(fetch = FetchType.LAZY)
    private Member member;
    String businessName;
    String ceoName;
    String businessNumber;
    String managerPhoneNumber;
    @JoinColumn(name = "category_id")
    @ManyToOne(fetch = FetchType.LAZY)
    private Category category;
    String productDetail;
    int companyAge;
    String introduction;
    String imageDirectory;
    @Column(columnDefinition = "ENUM('APPROVE', 'REJECT', 'WAIT')")
    @Enumerated(EnumType.STRING)
    StateType stateType;
}
