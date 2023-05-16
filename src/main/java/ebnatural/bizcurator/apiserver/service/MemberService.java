package ebnatural.bizcurator.apiserver.service;

import ebnatural.bizcurator.apiserver.common.exception.custom.AlreadyRegisteredUserException;
import ebnatural.bizcurator.apiserver.common.exception.custom.BadRequestException;
import ebnatural.bizcurator.apiserver.common.exception.custom.ErrorCode;
import ebnatural.bizcurator.apiserver.domain.Member;
import ebnatural.bizcurator.apiserver.domain.MemberLoginLog;
import ebnatural.bizcurator.apiserver.dto.MemberPrincipalDetails;
import ebnatural.bizcurator.apiserver.dto.MemberDto;
import ebnatural.bizcurator.apiserver.repository.MemberLoginLogRepository;
import ebnatural.bizcurator.apiserver.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class MemberService implements UserDetailsService {
    private final MemberRepository memberRepository;
    private final MemberLoginLogRepository memberLoginLogRepository;
    private final BCryptPasswordEncoder passwordEncoder;


    @Transactional
    public Boolean signup(MemberDto memberDto) {
        String username = memberDto.getUsername();;
        Optional.ofNullable(memberRepository.findByUsername(username))
                .ifPresent(foundedMember -> {
                    throw new AlreadyRegisteredUserException();
                });

        memberDto.encodePrivacy(passwordEncoder);
        Member member = memberDto.toEntity();

        return !Optional.of(memberRepository.save(member))
                .isEmpty();
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return new MemberPrincipalDetails(
                Optional.ofNullable(memberRepository.findByUsername(username))
                .orElseThrow(() -> new UsernameNotFoundException("Count not found user" + username))
        );
    }

    public void logSuccessfulLogin(MemberDto memberDto, String userAgent, String ipAddress) {
        Member member = Optional.ofNullable(memberRepository.findByUsername((String) memberDto.getUsername()))
                .orElseThrow(() -> new BadRequestException(ErrorCode.USER_NOT_FOUND));

        memberLoginLogRepository.save(MemberLoginLog.of(member, userAgent, ipAddress));
    }
}
