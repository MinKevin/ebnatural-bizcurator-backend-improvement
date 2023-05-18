package ebnatural.bizcurator.apiserver.service;


import ebnatural.bizcurator.apiserver.domain.Cart;
import ebnatural.bizcurator.apiserver.domain.Member;
import ebnatural.bizcurator.apiserver.domain.Product;
import ebnatural.bizcurator.apiserver.domain.ProductImage;
import ebnatural.bizcurator.apiserver.dto.CartProductDto;
import ebnatural.bizcurator.apiserver.dto.ProductImageDto;
import ebnatural.bizcurator.apiserver.dto.request.CartProductRequest;
import ebnatural.bizcurator.apiserver.repository.CartRepository;
import ebnatural.bizcurator.apiserver.repository.MemberRepository;
import ebnatural.bizcurator.apiserver.repository.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Service
public class CartService {
    private final CartRepository cartRepository;
    private final MemberRepository memberRepository;
    private final ProductRepository productRepository;

    //장바구니 조회
    @Transactional(readOnly = true)
    public List<CartProductDto> getCartsList() {//cart DB에 회원번호에 맞는 cart 를 찾아서 cart안에있는 product들을 리스트로 반환해줘야함
        Long memberId = 1L;
        //예외처림필요
        List<Cart> cartList = cartRepository.findByMemberId(memberId);
        List<CartProductDto> cartProductDtos = new ArrayList<>();
        for (Cart carts: cartList) {
            Product product = carts.getProduct();
            List<ProductImageDto> productImage = product.getProductImages()
                    .stream().map(productImage1 -> {
                         return new ProductImageDto(productImage1.getImgUrl());
                    }).collect(Collectors.toList());
            cartProductDtos.add(new CartProductDto(product.getName(), product.getCostWithDiscount(),
                    product.getRegularPrice(), carts.getQuantity(), productImage)) ;
        }
        /*cartList.orElseThrow(() -> new NoSuchElementException("No value present"))
                .stream().map(cart -> {
                    Product product = cart.getProduct();
                    return new CartProductDto(product.getName(), product.getCostWithDiscount(),
                            product.getRegularPrice(), cart.getQuantity(), product.getProductImages());
                }).collect(Collectors.toList());*/
        return cartProductDtos;
    }

    //장바구니에 제품 담기
    public void containingCartProducts(CartProductRequest cartProductRequest) {
        Member member = getMember();
        //예외처림필요
        Product product = productRepository.findById(cartProductRequest.getProductId()).orElseThrow(() -> new NoSuchElementException("No value present"));
        Cart newCart = Cart.createCart(member, product, cartProductRequest.getQuantity());

        cartRepository.save(newCart);
    }

    //장바구니 상품 수량 수정
    public void updateProductQuantity(CartProductRequest productRequest) {
        int updateQuantity = productRequest.getQuantity();//수정될 수량
        //예외처림필요
        Cart cart = cartRepository.findByProduct_Id(productRequest.getProductId());
        cart.updateCount(updateQuantity);

    }

    //장바구니 상품 삭제
    public void deleteProductsByCart(Long productId) {
        //Cart cart = checkExist(cartProductRequest.getProductId());
        //예외처림필요
        cartRepository.deleteByProduct_Id(productId);
    }

    public Member getMember() { // 로그인한 유저의 로그인정보 반환
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        System.out.println("@@@@@@@@@@@@@@@1" + authentication.getPrincipal());
        System.out.println("@@@@@@@@@@@@@@@2" + authentication.getPrincipal().toString());
        return (Member) authentication.getPrincipal();
    }

    //Cart에 Request로 들어온 ProductId가 있는지 체크
//    private Cart checkExist(Long productId) {
//        Cart cart = cartRepository.findByProduct_Id(productId).orElseThrow(() -> new NoSuchElementException());
//        return cart;
//    }


}
