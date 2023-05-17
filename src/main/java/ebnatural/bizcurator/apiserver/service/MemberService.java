package ebnatural.bizcurator.apiserver.service;

import ebnatural.bizcurator.apiserver.common.exception.custom.AlreadyRegisteredUserException;
import ebnatural.bizcurator.apiserver.common.exception.custom.BadRequestException;
import ebnatural.bizcurator.apiserver.common.exception.custom.ErrorCode;
import ebnatural.bizcurator.apiserver.common.util.MemberUtil;
import ebnatural.bizcurator.apiserver.domain.Member;
import ebnatural.bizcurator.apiserver.domain.MemberLoginLog;
import ebnatural.bizcurator.apiserver.dto.MemberPrincipalDetails;
import ebnatural.bizcurator.apiserver.dto.MemberDto;
import ebnatural.bizcurator.apiserver.dto.request.MemberRequest;
import ebnatural.bizcurator.apiserver.repository.MemberLoginLogRepository;
import ebnatural.bizcurator.apiserver.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.Optional;

import static org.apache.tika.mime.MediaType.image;

@Service
@RequiredArgsConstructor
@Transactional
public class MemberService implements UserDetailsService {
    private final MemberRepository memberRepository;
    private final MemberLoginLogRepository memberLoginLogRepository;
    private final BCryptPasswordEncoder passwordEncoder;

    private final S3ImageUploadService s3ImageUploadService;

    /**
     * https://seop00.tistory.com/39
     * @param memberDto
     * @param image
     * @return
     */

    public Boolean signup(MemberRequest memberDto, MultipartFile image)  {
        //String storedPath = s3ImageUploadService.uploadImage("businessRegistration", image);
        String storedPath = "businessTest" + image.getOriginalFilename();
        try{
            File storeImage = new File(storedPath);
            image.transferTo(storeImage);
        } catch (IOException e) {
            System.out.println("로컬용 에러테스트");
            throw new RuntimeException(e);
        }
        memberDto.setBusinessRegistration(storedPath);

        String username = memberDto.getUsername();;
        Optional.ofNullable(memberRepository.findByUsername(username))
                .ifPresent(foundedMember -> {
                    throw new AlreadyRegisteredUserException(ErrorCode.ALREADY_REGISTERED_USER_EXCEPTION);
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

    public void delete(long userId) {
        memberRepository.delete(memberRepository.findByUserId(userId));
    }

    /**
     * 모든 멤버 정보를 불로오는 함수 (관리자용)
     * @return
     */
    public List<MemberDto> getAllMember() {
        return memberRepository.getAllMember();
    }

    public MemberDto getMyInfo() {
        Long userId = MemberUtil.getMemberId();
        MemberDto member = MemberDto.from(memberRepository.findByUserId(userId));
        member.setPassword(null);
        return member;
    }
}
