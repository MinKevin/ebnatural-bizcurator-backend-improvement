package ebnatural.bizcurator.apiserver.domain;

import ebnatural.bizcurator.apiserver.dto.request.PurchaseMakeDocumentRequest;
import lombok.Getter;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import java.util.Date;

@Entity
@Getter
public class MakeDocument extends RequestDocumentEntity{
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "purpose_category_id")
    private PurposeCategory purposeCategory;

    public MakeDocument(){}
    private MakeDocument(String managerName, String managerCall, PurposeCategory purposeCategory, String productName, String productDetail,
                             int quantity, Date desiredEstimateDate, Date desiredDeliveryDate){
        this.managerName = managerName;
        this.managerCall = managerCall;
        this.purposeCategory = purposeCategory;
        this.productName = productName;
        this.productDetail = productDetail;
        this. quantity = quantity;
        this.desiredEstimateDate = desiredEstimateDate;
        this.desiredDeliveryDate = desiredDeliveryDate;
    }
    public static MakeDocument of(PurchaseMakeDocumentRequest docDto, PurposeCategory purposeCategory){
        return new MakeDocument(docDto.getManagerName(), docDto.getManagerCall(), purposeCategory, docDto.getProductName(), docDto.getProductDetail(),
                docDto.getQuantity(), docDto.getDesiredEstimateDate(), docDto.getDesiredDeliveryDate());
    }
}
