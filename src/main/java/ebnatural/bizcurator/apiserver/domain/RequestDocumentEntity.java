package ebnatural.bizcurator.apiserver.domain;

import ebnatural.bizcurator.apiserver.domain.constant.StateType;
import lombok.Getter;
import lombok.ToString;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.util.Date;

@Getter
@EntityListeners(AuditingEntityListener.class)
@MappedSuperclass
public abstract class RequestDocumentEntity extends TimeEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "member_id")
    Member member;
    @NotBlank
    String managerName;
    @NotBlank
    String managerCall;
    @NotBlank
    String productName;
    @NotBlank
    String productDetail;
    @NotBlank
    int quantity;
    @NotBlank
    Date desiredEstimateDate;
    @NotBlank
    Date desiredDeliveryDate;
    @NotBlank
    String requestMessage;
    @NotBlank
    String imageDirectory;
    @Column(name = "state_type", columnDefinition = "ENUM('WAIT', 'APPROVE', 'REJECT')")
    @Enumerated(EnumType.STRING)
    StateType stateType = StateType.WAIT;

}
