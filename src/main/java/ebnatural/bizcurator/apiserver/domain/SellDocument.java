package ebnatural.bizcurator.apiserver.domain;

import ebnatural.bizcurator.apiserver.domain.constant.StateType;
import ebnatural.bizcurator.apiserver.dto.request.SellDocumentRequest;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

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
    @NotNull
    int establishYear;
    @NotBlank
    String introduction;
    @NotBlank
    String imageDirectory;
    @Setter
    @NotNull
    @Enumerated(EnumType.STRING)
    StateType stateType = StateType.WAIT;

    private SellDocument(Member member, String businessName, String ceoName, String businessNumber, String managerPhoneNumber, Category category,
                         String productDetail, int establishYear, String introduction, String imageDirectory, StateType stateType) {
        this.member = member;
        this.businessName = businessName;
        this.ceoName = ceoName;
        this.businessNumber = businessNumber;
        this.managerPhoneNumber = managerPhoneNumber;
        this.category = category;
        this.productDetail = productDetail;
        this.establishYear = establishYear;
        this.introduction = introduction;
        this.imageDirectory = imageDirectory;
        this.stateType = stateType;
    }

    public SellDocument() { }

    public static SellDocument of(Member member, SellDocumentRequest docDto, Category category, String storedPath){
        return new SellDocument(member, docDto.getBusinessName(), docDto.getCeoName(), docDto.getBusinessNumber(), docDto.getManagerPhoneNumber(),
                category, docDto.getProductDetail(), docDto.getEstablishYear(), docDto.getIntroduction(), storedPath, docDto.getStateType());
    }

    public void update(Member member, Category category, SellDocumentRequest docDto) {
        this.member = member;
        this.businessName = docDto.getBusinessName();
        this.ceoName = docDto.getCeoName();;
        this.businessNumber = docDto.getBusinessNumber();
        this.managerPhoneNumber = docDto.getManagerPhoneNumber();
        this.category = category;
        this.productDetail = docDto.getProductDetail();
        this.establishYear = docDto.getEstablishYear();
        this.introduction = docDto.getIntroduction();
        this.imageDirectory = docDto.getImageDirectory();
        this.stateType = docDto.getStateType();
    }
}