package ebnatural.bizcurator.apiserver.domain;

import ebnatural.bizcurator.apiserver.dto.request.PurchaseMakeDocumentRequest;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import java.util.Date;

@Entity
@Getter
public class PurchaseDocument extends RequestDocumentEntity{
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "category_id")
    private Category category;

    public PurchaseDocument(){}
    private PurchaseDocument(String managerName, String managerCall, Category category, String productName, String productDetail,
                             int quantity, Date desiredEstimateDate, Date desiredDeliveryDate){
        this.managerName = managerName;
        this.managerCall = managerCall;
        this.category = category;
        this.productName = productName;
        this.productDetail = productDetail;
        this. quantity = quantity;
        this.desiredEstimateDate = desiredEstimateDate;
        this.desiredDeliveryDate = desiredDeliveryDate;
    }
    public static PurchaseDocument of(PurchaseMakeDocumentRequest docDto, Category category){
        return new PurchaseDocument(docDto.getManagerName(), docDto.getManagerCall(), category, docDto.getProductName(), docDto.getProductDetail(),
                docDto.getQuantity(), docDto.getDesiredEstimateDate(), docDto.getDesiredDeliveryDate());
    }
}
