package ebnatural.bizcurator.apiserver.domain;

import com.amazonaws.services.ec2.model.StatusType;
import ebnatural.bizcurator.apiserver.domain.constant.StateType;
import ebnatural.bizcurator.apiserver.dto.request.PurchaseMakeDocumentRequest;
import ebnatural.bizcurator.apiserver.dto.request.SellDocumentRequest;
import lombok.Getter;
import lombok.ToString;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.Date;

@Entity
@Getter
public class SellDocument extends TimeEntity{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    @JoinColumn(name = "member_id")
    @ManyToOne(fetch = FetchType.LAZY)
    private Member member;
    @NotBlank
    String businessName;
    @NotBlank
    String ceoName;
    @NotBlank
    String businessNumber;
    @NotBlank
    String managerPhoneNumber;
    @NotNull
    @JoinColumn(name = "category_id")
    @ManyToOne(fetch = FetchType.LAZY)
    private Category category;
    @NotBlank
    String productDetail;
    @NotBlank
    String companyAge;
    @NotBlank
    String introduction;
    @NotBlank
    String imageDirectory;
    @NotNull
    @Column(columnDefinition = "ENUM('WAIT', 'APPROVE', 'REJECT')")
    @Enumerated(EnumType.STRING)
    StateType stateType = StateType.WAIT;

    private SellDocument(Member member, String businessName, String ceoName, String businessNumber, String managerPhoneNumber, Category category,
                        String productDetail, String companyAge, String introduction, String imageDirectory, StateType stateType) {
        this.member = member;
        this.businessName = businessName;
        this.ceoName = ceoName;
        this.businessNumber = businessNumber;
        this.managerPhoneNumber = managerPhoneNumber;
        this.category = category;
        this.productDetail = productDetail;
        this.companyAge = companyAge;
        this.introduction = introduction;
        this.imageDirectory = imageDirectory;
        this.stateType = stateType;
    }

    public SellDocument() { }

    public static SellDocument of(Member member, SellDocumentRequest docDto, Category category, String storedPath){
        return new SellDocument(member, docDto.getBusinessName(), docDto.getCeoName(), docDto.getBusinessNumber(), docDto.getManagerPhoneNumber(),
                category, docDto.getProductDetail(), docDto.getCompanyAge(), docDto.getIntroduction(), storedPath, docDto.getStateType());
    }

    public void update(Member member, Category category, SellDocumentRequest docDto) {
        this.member = member;
        this.businessName = docDto.getBusinessName();
        this.ceoName = docDto.getCeoName();;
        this.businessNumber = docDto.getBusinessNumber();
        this.managerPhoneNumber = docDto.getManagerPhoneNumber();
        this.category = category;
        this.productDetail = docDto.getProductDetail();
        this.companyAge = docDto.getCompanyAge();
        this.introduction = docDto.getIntroduction();
        this.imageDirectory = docDto.getImageDirectory();
        this.stateType = docDto.getStateType();
    }
}
