package ebnatural.bizcurator.apiserver.dto.request;

import com.fasterxml.jackson.databind.PropertyNamingStrategy;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@JsonNaming(PropertyNamingStrategy.SnakeCaseStrategy.class)
public class SellDocumentRequest {
    String businessName;
    String ceoName;
    String businessNumber;
    String managerPhoneNumber;
    String category;
    String productDetail;
    int companyAge;
    int introduction;
}
