package ebnatural.bizcurator.apiserver.common.constants;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public enum ORDER_CANCEL_STATE {
    WAIT("신청접수"),
    APPROVE("승인"),
    REJECTED("거부"),
    FINISHED("취소가 완료됨");

    private final String meaning;
}
