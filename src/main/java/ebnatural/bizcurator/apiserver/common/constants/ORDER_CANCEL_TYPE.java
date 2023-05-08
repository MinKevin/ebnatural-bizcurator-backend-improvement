package ebnatural.bizcurator.apiserver.common.constants;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public enum ORDER_CANCEL_TYPE {
    UNSELECTED("선택안됨"),
    CHANGE_OF_MIND("고객변심"),
    UNSATISFIED("서비스 불만족"),
    DELIVERY_DELAYED("배송지연");

    private final String meaning;
}
