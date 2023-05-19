package ebnatural.bizcurator.apiserver.domain;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.Min;

@Entity
@Getter
@Table(name = "cart")
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Cart {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;


    @ManyToOne (targetEntity = Member.class, fetch = FetchType.LAZY)
    @JoinColumn(name = "member_id")
    private Member member;

//    @Column(name = "member_id")
//    Long member_id;

    @OneToOne(targetEntity = Product.class, fetch = FetchType.LAZY)
    @JoinColumn(name = "product_id")
    private Product product;

//    @Column(name = "product_id")
//    Long product_id;

    @Min(value = 1, message = "최소 1개 이상 담아주세요")
    private int quantity; //장바구니에 담을 제품갯수


    public Cart(Member member, Product product, int quantity) {
        this.member = member;
        this.product = product;
        this.quantity = quantity;
    }

    public static Cart of(Member member, Product product, int quantity) {
        return new Cart(member, product, quantity);
    }
    public void addCount(int quantity){
        this.quantity += quantity;
    }

    public void updateCount(int quantity){
        this.quantity = quantity;
    }

    public void addQuantity(int addQuantity){
        this.quantity += addQuantity;
    }

    public Cart updateQuantity(int updateQuantity) {
        this.quantity = updateQuantity;
        return this;
    }
}
