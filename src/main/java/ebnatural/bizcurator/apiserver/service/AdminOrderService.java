package ebnatural.bizcurator.apiserver.service;

import ebnatural.bizcurator.apiserver.dto.AdminHomeInfoDto;
import ebnatural.bizcurator.apiserver.repository.MemberRepository;
import java.time.LocalDate;
import java.time.LocalDateTime;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class AdminOrderService {

    private final MemberRepository memberRepository;
    /**
     * 관리자페이지 홈 화면 정보를 반환
     * @return
     */
    public AdminHomeInfoDto showHomeInformation() {
        return AdminHomeInfoDto.of(
                (int) memberRepository.count(),
                memberRepository.countByLastLoginTime(LocalDate.now())
        );
    }
}
