package ebnatural.bizcurator.apiserver.dto;

import com.fasterxml.jackson.databind.PropertyNamingStrategy;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import ebnatural.bizcurator.apiserver.domain.SellDocument;
import ebnatural.bizcurator.apiserver.domain.constant.StateType;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotBlank;

@Getter
@Setter
@JsonNaming(PropertyNamingStrategy.SnakeCaseStrategy.class)
public class SellDocumentDto {
    Long id;
    String businessName;
    String ceoName;
    String businessNumber;
    String managerPhoneNumber;
    Long category;
    String productDetail;
    int companyAge;
    String introduction;
    String imageDirectory;
    StateType stateType = StateType.WAIT;

    public SellDocumentDto(Long id, String businessName, String ceoName, String businessNumber, String managerPhoneNumber, Long category, String productDetail, int companyAge, String introduction, String imageDirectory, StateType stateType) {
        this.id = id;
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

    public static SellDocumentDto from(SellDocument entity) {
        return new SellDocumentDto(
                entity.getId(),
                entity.getBusinessName(),
                entity.getCeoName(),
                entity.getBusinessNumber(),
                entity.getManagerPhoneNumber(),
                entity.getCategory().getId(),
                entity.getProductDetail(),
                entity.getCompanyAge(),
                entity.getIntroduction(),
                entity.getImageDirectory(),
                entity.getStateType()
        );
    }
}
