package ebnatural.bizcurator.apiserver.dto;

import ebnatural.bizcurator.apiserver.domain.SellDocument;
import lombok.Getter;

@Getter
public class AdminSellDocumentDto {

    Long id;
    String category;

    String productDetail;
    int companyAge;
    String ceoName;
    String businessName;

    String businessNumber;

    String phoneNumber;

    String state;


    public AdminSellDocumentDto(Long id, String category, String productDetail, int companyAge,
            String ceoName, String businessName, String businessNumber, String phoneNumber,
            String state) {
        this.id = id;
        this.category = category;
        this.productDetail = productDetail;
        this.companyAge = companyAge;
        this.ceoName = ceoName;
        this.businessName = businessName;
        this.businessNumber = businessNumber;
        this.phoneNumber = phoneNumber;
        this.state = state;
    }

    public static AdminSellDocumentDto from(SellDocument entity) {
        return new AdminSellDocumentDto(
                entity.getId(),
                entity.getCategory().getName(),
                entity.getProductDetail(),
                entity.getCompanyAge(),
                entity.getCeoName(),
                entity.getBusinessName(),
                entity.getBusinessNumber(),
                entity.getManagerPhoneNumber(),
                entity.getStateType().getStatus()
        );
    }
}
