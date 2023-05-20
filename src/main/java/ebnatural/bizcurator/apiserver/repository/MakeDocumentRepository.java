package ebnatural.bizcurator.apiserver.repository;

import ebnatural.bizcurator.apiserver.domain.MakeDocument;
import ebnatural.bizcurator.apiserver.domain.SellDocument;
import ebnatural.bizcurator.apiserver.repository.querydsl.MakeDocumentRepositoryCustom;
import java.time.LocalDate;
import org.springframework.beans.PropertyValues;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import org.springframework.data.repository.query.Param;

public interface MakeDocumentRepository extends JpaRepository<MakeDocument, Long>, MakeDocumentRepositoryCustom {
    @Query("SELECT d FROM MakeDocument d where d.member.id = ?1 ORDER BY d.id ASC")
    List<MakeDocument> findByMemberId(Long userId);

    @Query("SELECT 'Make' AS documentType, m FROM MakeDocument m WHERE m.member.id = :memberId AND m.createdAt >= :filteredDate")
    List<Object[]> findAllByAfterFilteredDate(@Param("memberId") Long memberId, @Param("filteredDate") LocalDate filteredDate);
}
