package ebnatural.bizcurator.apiserver.domain;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter
@Table(name = "cart")
@NoArgsConstructor
@RequiredArgsConstructor
public class Cart {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    @Setter
    //Member_id 추가 필요
    @ManyToOne (fetch = FetchType.LAZY)
    @JoinColumn(name = "member_id")
    private Member member;

    @Setter
    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "product_id")
    private Product product;

    @Setter
    private int quantity; //장바구니에 담을 제품갯수

    public static Cart createCart(Member member, Product product, int quantity) {
        Cart cart = new Cart();
        cart.setMember(member);
        cart.setProduct(product);
        cart.setQuantity(quantity);
        return cart;
    }
    public void addCount(int quantity){
        this.quantity += quantity;
    }

    public void updateCount(int quantity){
        this.quantity = quantity;
    }
}
