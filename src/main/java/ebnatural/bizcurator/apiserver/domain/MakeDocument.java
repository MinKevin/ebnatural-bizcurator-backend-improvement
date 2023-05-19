package ebnatural.bizcurator.apiserver.domain;

import ebnatural.bizcurator.apiserver.domain.constant.StateType;
import ebnatural.bizcurator.apiserver.dto.PurchaseMakeDocumentDto;
import ebnatural.bizcurator.apiserver.dto.request.PurchaseMakeDocumentRequest;
import lombok.Getter;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.Date;

@Entity
@Getter
public class MakeDocument extends RequestDocumentEntity{
    @NotNull
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "purpose_category_id")
    private PurposeCategory purposeCategory;

    public MakeDocument(){}
    private MakeDocument(Member member, String managerName, String managerCall, PurposeCategory category, String productName, String productDetail,
                         int quantity, String requestMessage, Date desiredEstimateDate, Date desiredDeliveryDate, String storedPath, StateType stateType){
        this.member = member;
        this.managerName = managerName;
        this.managerCall = managerCall;
        this.purposeCategory = category;
        this.productName = productName;
        this.productDetail = productDetail;
        this. quantity = quantity;
        this.requestMessage = requestMessage;
        this.desiredEstimateDate = desiredEstimateDate;
        this.desiredDeliveryDate = desiredDeliveryDate;
        this.imageDirectory = storedPath;
        this.stateType = stateType;
    }
    public static MakeDocument of(Member member, PurchaseMakeDocumentRequest docDto, PurposeCategory category, String storedPath){
        return new MakeDocument(member, docDto.getManagerName(), docDto.getManagerCall(), category, docDto.getProductName(), docDto.getProductDetail(),
                docDto.getQuantity(), docDto.getRequestMessage(), docDto.getDesiredEstimateDate(), docDto.getDesiredDeliveryDate(), storedPath, docDto.getStateType());
    }

    public MakeDocument update(Member member, PurposeCategory category, PurchaseMakeDocumentRequest docDto){
        this.member = member;
        this.managerName = docDto.getManagerName();
        this.managerCall = docDto.getManagerCall();
        this.purposeCategory = category;
        this.productName = docDto.getProductName();
        this.productDetail = docDto.getProductDetail();
        this. quantity = docDto.getQuantity();
        this.requestMessage = docDto.getRequestMessage();
        this.desiredEstimateDate = docDto.getDesiredEstimateDate();
        this.desiredDeliveryDate = docDto.getDesiredDeliveryDate();
        this.imageDirectory = docDto.getImageDirectory();
        this.stateType = docDto.getStateType();
        return this;
    }
}
