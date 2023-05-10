package ebnatural.bizcurator.apiserver.domain.constant;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public enum DeliveryState {
    PAID("결제완료"),
    DELIVERING("배송중"),
    DELIVER_DONE("배송완료"),
    FINISH("구매확정");

    private final String meaning;
}
