package ebnatural.bizcurator.apiserver.repository;

import ebnatural.bizcurator.apiserver.domain.Member;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

public interface MemberRepository extends JpaRepository<Member, Long> {
    Member findByUsername(String userName);
    Optional<Member> findById(Long id);
    @Transactional
    @Modifying
    @Query(value = "update member set last_login = now() where username = :username", nativeQuery = true)
    public int updateMemberLastLogin(@Param("username") String username);
}
