package ebnatural.bizcurator.apiserver.repository;

import ebnatural.bizcurator.apiserver.domain.Member;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;
import java.time.LocalDate;
import java.util.Optional;

public interface MemberRepository extends JpaRepository<Member, Long> {
    Member findByUsername(String userName);
    Optional<Member> findById(Long id);

    @Transactional
    @Modifying(clearAutomatically = true)
    @Query("update Member u set u.refreshToken = ?1 where u.id = ?2")
    void updateRefreshToken(String newRefreshToken, Long id);

    //todo 수정
    @Query("SELECT COUNT(m) FROM Member m WHERE m.lastLoginTime = :currentDate")
    int countByLastLoginTime(@Param("currentDate") LocalDate currentDate);
}
