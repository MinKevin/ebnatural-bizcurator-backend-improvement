package ebnatural.bizcurator.apiserver.dto;

import java.time.LocalDateTime;
import lombok.Getter;

@Getter
public class MyPageDocumentDto {

    private Long requestId;
    private LocalDateTime createdAt;
    private String requestType;
    private String state;
    private String category;

    private MyPageDocumentDto(Long requestId, LocalDateTime createdAt, String requestType, String state,
            String category) {
        this.requestId = requestId;
        this.createdAt = createdAt;
        this.requestType = requestType;
        this.state = state;
        this.category = category;
    }

    public static MyPageDocumentDto of(Long requestId, LocalDateTime createdAt, String requestType, String state,
            String category) {
        return new MyPageDocumentDto(requestId, createdAt, requestType, state, category);
    }
}
