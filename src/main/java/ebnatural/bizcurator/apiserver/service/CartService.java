package ebnatural.bizcurator.apiserver.service;


import ebnatural.bizcurator.apiserver.domain.Cart;
import ebnatural.bizcurator.apiserver.domain.Member;
import ebnatural.bizcurator.apiserver.domain.Product;
import ebnatural.bizcurator.apiserver.dto.request.CartProductRequest;
import ebnatural.bizcurator.apiserver.dto.response.CartProductResponse;
import ebnatural.bizcurator.apiserver.repository.CartRepository;
import ebnatural.bizcurator.apiserver.repository.MemberRepository;
import ebnatural.bizcurator.apiserver.repository.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Transactional
@Service
public class CartService {
    private final CartRepository cartRepository;
    private final MemberRepository memberRepository;
    private final ProductRepository productRepository;

    //장바구니 조회
    @Transactional(readOnly = true)
    /*public List<CartProductResponse> getCartsList() {//cart DB에 회원번호에 맞는 cart 를 찾아서 cart안에있는 product들을 리스트로 반환해줘야함
        Long memberId = getMember().getId();

        return cartRepository.findByMemberId(memberId)
                .orElseThrow(() -> new NoSuchElementException("No value present"))
                .stream().map(cart -> {
                    Product product = cart.getProduct(); //TODO : Product가 아니라 ProductDto로 받을 예정
                    return new CartProductResponse(product.getName(), product.discountPrice(),
                            product.getRegularPrice(), cart.getQuantity(),CartProductResponse.builder().productImage());
                }).collect(Collectors.toList());
    }*/

    //장바구니에 제품 담기
    public void containingCartProducts(CartProductRequest cartProductRequest) {
        //상품id 만 cartRepository에 저장
        Member member = getMember();
        Product product = productRepository.findById(cartProductRequest.getProductId()).orElseThrow(() -> new NoSuchElementException("No value present"));
        Cart newCart = Cart.createCart(member, product, cartProductRequest.getQuantity());

        cartRepository.save(newCart);
    }

    public Member getMember() { // 로그인한 유저의 로그인정보 반환
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        return (Member) authentication.getPrincipal();

    }

    public void deleteProductsByCart(CartProductRequest cartProductRequest) {
        //Cart cart = checkExist(cartProductRequest.getProductId());

        cartRepository.deleteById(cartProductRequest.getProductId());
    }

    //Cart에 Request로 들어온 ProductId가 있는지 체크
    private Cart checkExist(Long productId) {
        Cart cart = cartRepository.findByProduct_Id(productId).orElseThrow(() -> new NoSuchElementException());
        return cart;
    }
}
