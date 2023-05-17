package ebnatural.bizcurator.apiserver.repository;

import ebnatural.bizcurator.apiserver.domain.Cart;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface CartRepository extends JpaRepository<Cart, Long> {

    Optional<List<Cart>> findByMemberId(Long memberId);//memberId로 유저에 해당하는 장바구니 리스트 조회
    Cart findByProduct_Id(Long productId);

    void deleteByProduct_Id(Long productId);
}
