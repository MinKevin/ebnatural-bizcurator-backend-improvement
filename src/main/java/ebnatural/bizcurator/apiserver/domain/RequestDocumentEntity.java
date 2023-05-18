package ebnatural.bizcurator.apiserver.domain;

import ebnatural.bizcurator.apiserver.domain.constant.StateType;
import lombok.Getter;
import lombok.ToString;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
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
    private Member member;
    String productName;
    String productDetail;
    int quantity;
    Date desiredEstimateDate;
    Date desiredDeliveryDate;
    String managerName;
    String managerCall;
    String requestMessage;
    String imageDirectory;
    @Column(name = "state_type", columnDefinition = "ENUM('APPROVE', 'REJECT', 'WAIT')")
    @Enumerated(EnumType.STRING)
    StateType stateType;

}
