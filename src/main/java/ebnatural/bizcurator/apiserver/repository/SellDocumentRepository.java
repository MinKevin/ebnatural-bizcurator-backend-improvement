package ebnatural.bizcurator.apiserver.repository;

import ebnatural.bizcurator.apiserver.domain.SellDocument;
import ebnatural.bizcurator.apiserver.repository.querydsl.SellDocumentRepositoryCustom;
import java.time.LocalDate;
import org.springframework.beans.PropertyValues;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import org.springframework.data.repository.query.Param;

public interface SellDocumentRepository extends JpaRepository<SellDocument, Long>, SellDocumentRepositoryCustom {
    @Query("SELECT d FROM SellDocument d where d.member.id = ?1  ORDER BY d.id ASC")
    List<SellDocument> findByMemberId(Long memberId);

    @Query("SELECT 'Sell' AS documentType, s FROM SellDocument s WHERE s.member.id = :memberId AND s.createdAt >= :filteredDate")
    List<Object[]> findAllByAfterFilteredDate(@Param("memberId") Long memberId, @Param("filteredDate") LocalDate filteredDate);
}
