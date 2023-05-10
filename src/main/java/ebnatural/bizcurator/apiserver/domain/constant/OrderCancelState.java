package ebnatural.bizcurator.apiserver.domain.constant;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public enum OrderCancelState {
    WAIT("신청접수"),
    APPROVE("승인"),
    REJECTED("거부"),
    FINISHED("취소가 완료됨");

    private final String meaning;
}
