package ebnatural.bizcurator.apiserver.dto.request;

import com.fasterxml.jackson.databind.PropertyNamingStrategy;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import ebnatural.bizcurator.apiserver.domain.PurchaseDocument;
import ebnatural.bizcurator.apiserver.domain.constant.DocumentType;
import ebnatural.bizcurator.apiserver.domain.constant.StateType;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
@JsonNaming(PropertyNamingStrategy.SnakeCaseStrategy.class)
public class PurchaseMakeDocumentRequest {
    DocumentType documentType;
    String managerName;
    String managerCall;
    long category;
    String productName;
    String productDetail;
    int quantity;
    Date desiredEstimateDate;
    Date DesiredDeliveryDate;

    String requestMessage;
    StateType stateType = StateType.WAIT;
}
