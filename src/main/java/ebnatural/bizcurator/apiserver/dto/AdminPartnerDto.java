package ebnatural.bizcurator.apiserver.dto;

import ebnatural.bizcurator.apiserver.domain.Category;
import ebnatural.bizcurator.apiserver.domain.SellDocument;
import ebnatural.bizcurator.apiserver.domain.constant.StateType;
import lombok.Getter;

@Getter
public class AdminPartnerDto {
    String businessName;
    String category;
    String businessNumber;
    String ceoName;
    String managerPhoneNumber;
    int companyAge;

    private AdminPartnerDto(String businessName, String category, String businessNumber, String ceoName, String managerPhoneNumber, int companyAge) {
        this.businessName = businessName;
        this.category = category;
        this.businessNumber = businessNumber;
        this.ceoName = ceoName;
        this.managerPhoneNumber = managerPhoneNumber;
        this.companyAge = companyAge;
    }

    public static AdminPartnerDto from(SellDocument entity) {
        return new AdminPartnerDto(
                entity.getBusinessName(),
                entity.getCategory().getName(),
                entity.getBusinessNumber(),
                entity.getCeoName(),
                entity.getManagerPhoneNumber(),
                entity.getCompanyAge()
        );
    }
}
