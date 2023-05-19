package ebnatural.bizcurator.apiserver.domain.constant;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public enum StateType {
    APPROVE("승인"),
    REJECT("반려"),
    WAIT("대기");

    private final String status;

    public String getStatus() {
        return status;
    }
}
