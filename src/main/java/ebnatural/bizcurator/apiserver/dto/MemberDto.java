package ebnatural.bizcurator.apiserver.dto;

import lombok.Getter;

@Getter
public class MemberDto {

    private Long memberId;

    public MemberDto() {
    }

    private MemberDto(Long memberId) {
        this.memberId = memberId;
    }

    public static MemberDto of(Long memberId) {
        return new MemberDto(memberId);
    }
}
