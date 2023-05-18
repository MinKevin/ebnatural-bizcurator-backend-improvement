package ebnatural.bizcurator.apiserver.domain;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;

@Entity
@Table(name = "product")
@Getter
@ToString
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Setter
    @Column(name = "name", nullable = false)
    private String name;

    @Setter
    @Column(name = "regular_price")
    private Integer regularPrice;

    @Setter
    @Column(name = "min_quantity")
    private Integer minQuantity;

    @Setter
    @Column(name = "max_quantity")
    private Integer maxQuantity;

    @Setter
    @Column(name = "discount_rate")
    private Integer discountRate;

    @CreatedDate
    @Column(name = "created_at", nullable = false, updatable = false)
    private LocalDateTime createdAt;

    @LastModifiedDate
    @Column(name = "updated_at", nullable = false, updatable = true)
    private LocalDateTime updatedAt;

    @Column(name = "weekly_clicks")
    private Integer weeklyClicks;

    @Column(name = "monthly_clicks")
    private Integer monthlyClicks;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "category_id")
    private Category category;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "manufacturer_id")
    private Manufacturer manufacturer;

    //fetchType이 LAZY이면 proxy를 읽지 못하는 문제가 있음, 근대 EAGER을 쓰면 무한반복
    @OneToMany(mappedBy = "product",fetch = FetchType.LAZY)
    private List<ProductImage> productImages = new ArrayList<>();

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Product product = (Product) o;
        return getId() != null && Objects.equals(getId(), product.getId());
    }


    @Override
    public int hashCode() {
        return getClass().hashCode();
    }
    /**
     *
     * @return 할인율을 포함한 물건 가격 반환
     */
    public int getCostWithDiscount() {
        return this.regularPrice * (100 - this.discountRate)/100;
    }
}
