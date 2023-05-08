package ebnatural.bizcurator.apiserver.service;


import ebnatural.bizcurator.apiserver.model.Cart;
import ebnatural.bizcurator.apiserver.repository.CartRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor
@Service
public class CartService {
    private final CartRepository cartRepository;
    public List<Cart> getCartsList() {

        return cartRepository.findAll();
    }
}
