package ebnatural.bizcurator.apiserver.common.constants;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public enum OrderType {
    IMMEDIATE("바로구매"),
    REQUEST_DOCUMENT("구매의뢰서");

    private final String meaning;

}
