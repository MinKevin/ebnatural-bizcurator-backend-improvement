package ebnatural.bizcurator.apiserver.service;


import ebnatural.bizcurator.apiserver.domain.Cart;
import ebnatural.bizcurator.apiserver.domain.Member;
import ebnatural.bizcurator.apiserver.domain.Product;
import ebnatural.bizcurator.apiserver.dto.CartProductDto;
import ebnatural.bizcurator.apiserver.dto.request.CartProductRequest;
import ebnatural.bizcurator.apiserver.repository.CartRepository;
import ebnatural.bizcurator.apiserver.repository.MemberRepository;
import ebnatural.bizcurator.apiserver.repository.ProductImageRepository;
import ebnatural.bizcurator.apiserver.repository.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

@RequiredArgsConstructor
@Service
public class CartService {
    private final ProductService productService;
    private final CartRepository cartRepository;
    private final MemberRepository memberRepository;
    private final ProductRepository productRepository;
    private final ProductImageRepository productImageRepository;

    //장바구니 조회
    @Transactional(readOnly = true)
    public List<CartProductDto> getCartsList() {
        Long memberId = getMember().getId();

        List<Cart> cartList = cartRepository.findByMemberId(memberId);
        List<CartProductDto> cartProductDtos = new ArrayList<>();
        for (Cart carts: cartList) {
            Product product = carts.getProduct();
            //ProductImage productMainImage = productService.getProductMainImage(product.getId());
            String mainImageUrl = productService.getProductMainImage(product.getId()).getImgUrl();

            cartProductDtos.add(new CartProductDto(product.getName(), product.getCostWithDiscount(),
                    product.getRegularPrice(), carts.getQuantity(), mainImageUrl)) ;
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
        if (!(cartProductRequest.getQuantity()<=0)){
            Product product = productRepository.findById(cartProductRequest.getProductId()).orElseThrow(() -> new NoSuchElementException("No value present"));
            Cart newCart = Cart.createCart(member, product, cartProductRequest.getQuantity());
            cartRepository.save(newCart);
        }
    }

    //장바구니 상품 수량 수정
    public void updateProductQuantity(CartProductRequest productRequest) {
        int updateQuantity = productRequest.getQuantity();//수정될 수량
        //예외처리필요
        Cart cart = cartRepository.findByProduct_Id(productRequest.getProductId());
        cart.updateCount(updateQuantity);
        cartRepository.save(cart);
    }

    //장바구니 상품 삭제
    public void deleteProductsByCart(Long productId) {
        //Cart cart = checkExist(cartProductRequest.getProductId());
        //예외처리필요
        cartRepository.deleteByProduct_Id(productId);
    }

    public Member getMember() { // 로그인한 유저의 로그인정보 반환
        // Long memberId = MemberUtil.getMemberId();
        Long memberId = 1L;
        return memberRepository.findById(memberId).orElseThrow(NoSuchElementException::new);
    }

    //Cart에 Request로 들어온 ProductId가 있는지 체크
//    private Cart checkExist(Long productId) {
//        Cart cart = cartRepository.findByProduct_Id(productId).orElseThrow(() -> new NoSuchElementException());
//        return cart;
//    }


}
