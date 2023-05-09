package ebnatural.bizcurator.apiserver.domain;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.Objects;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import org.hibernate.Hibernate;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;

@Entity
@Table(name = "product")
@Getter
@ToString
@RequiredArgsConstructor
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Setter
    @Column(name = "name", nullable = false)
    private String name;

    @Setter
    @Column(name = "main_image")
    private String mainImage;

    @Setter
    @Column(name = "detail_image")
    private String detailImage;

    @Setter
    @Column(name = "regular_price", precision = 10, scale = 2)
    private BigDecimal regularPrice;

    @Setter
    @Column(name = "min_quantity")
    private Integer minQuantity;

    @Setter
    @Column(name = "max_quantity")
    private Integer maxQuantity;

    @Setter
    @Column(name = "discount_rate", precision = 3, scale = 2)
    private BigDecimal discountRate;

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

    @ManyToOne
    @JoinColumn(name = "category_id")
    private Category category;

    @ManyToOne
    @JoinColumn(name = "manufacturer_id")
    private Manufacturer manufacturer;

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(
                o)) {
            return false;
        }
        Product product = (Product) o;
        return getId() != null && Objects.equals(getId(), product.getId());
    }

    @Override
    public int hashCode() {
        return getClass().hashCode();
    }
}
