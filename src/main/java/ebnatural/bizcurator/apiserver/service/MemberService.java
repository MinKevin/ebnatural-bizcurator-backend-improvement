package ebnatural.bizcurator.apiserver.service;

import ebnatural.bizcurator.apiserver.common.exception.custom.AlreadyRegisteredUserException;
import ebnatural.bizcurator.apiserver.domain.Member;
import ebnatural.bizcurator.apiserver.dto.MemberPrincipalDetails;
import ebnatural.bizcurator.apiserver.dto.request.MemberRequest;
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
    private final BCryptPasswordEncoder passwordEncoder;

    @Transactional
    public Member signup(MemberRequest memberRequest) {
        String username = memberRequest.getUsername();;
        Optional.ofNullable(memberRepository.findByUsername(username))
                .ifPresent(foundedMember -> {
                    throw new AlreadyRegisteredUserException();
                });

        memberRequest.encodePrivacy(passwordEncoder);
        Member member = memberRequest.toEntity();

        return Optional.of(memberRepository.save(member))
                .orElseThrow();
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return new MemberPrincipalDetails(
                Optional.ofNullable(memberRepository.findByUsername(username))
                .orElseThrow(() -> new UsernameNotFoundException("Count not found user" + username))
        );
    }
}
