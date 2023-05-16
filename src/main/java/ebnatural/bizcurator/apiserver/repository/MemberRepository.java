package ebnatural.bizcurator.apiserver.repository;

import ebnatural.bizcurator.apiserver.domain.Member;
import java.time.LocalDate;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface MemberRepository extends JpaRepository<Member, Long> {

    Optional<Member> findById(Long id);
    @Query("SELECT COUNT(m) FROM Member m WHERE m.lastLoginTime = :currentDate")
    int countByLastLoginTime(@Param("currentDate") LocalDate currentDate);

}
