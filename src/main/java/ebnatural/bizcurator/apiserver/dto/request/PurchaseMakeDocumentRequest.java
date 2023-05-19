package ebnatural.bizcurator.apiserver.dto.request;

import com.fasterxml.jackson.databind.PropertyNamingStrategy;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import ebnatural.bizcurator.apiserver.domain.PurchaseDocument;
import ebnatural.bizcurator.apiserver.domain.constant.DocumentType;
import ebnatural.bizcurator.apiserver.domain.constant.StateType;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.Date;

@Getter
@Setter
@JsonNaming(PropertyNamingStrategy.SnakeCaseStrategy.class)
public class PurchaseMakeDocumentRequest {
    //@Enum(enumClass = DocumentType.class, ignoreCase = true)
    String documentType;
    @NotBlank
    String managerName;
    @NotBlank
    String managerCall;
    @NotNull
    long category;
    @NotBlank
    String productName;
    @NotBlank
    String productDetail;
    @NotNull
    int quantity;
    @NotBlank
    Date desiredEstimateDate;
    @NotBlank
    Date DesiredDeliveryDate;
    @NotBlank
    String requestMessage;
    String imageDirectory;
    StateType stateType = StateType.WAIT;
}
