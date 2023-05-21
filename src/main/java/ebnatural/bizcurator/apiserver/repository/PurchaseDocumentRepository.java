package ebnatural.bizcurator.apiserver.repository;

import ebnatural.bizcurator.apiserver.domain.MakeDocument;
import ebnatural.bizcurator.apiserver.domain.PurchaseDocument;
import ebnatural.bizcurator.apiserver.domain.SellDocument;
import ebnatural.bizcurator.apiserver.repository.querydsl.PurchaseDocumentRepositoryCustom;
import java.time.LocalDate;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import org.springframework.data.repository.query.Param;

public interface PurchaseDocumentRepository extends JpaRepository<PurchaseDocument, Long>, PurchaseDocumentRepositoryCustom {
    @Query("SELECT d FROM PurchaseDocument d where d.member.id = ?1  ORDER BY d.id ASC")
    List<PurchaseDocument> findByMemberId(Long userId);

    @Query("SELECT d FROM PurchaseDocument d JOIN FETCH d.category WHERE d.member.id = :memberId AND d.id = :id")
    Optional<PurchaseDocument> findByMemberIdAndId(@Param("memberId") Long memberId, @Param("id") Long id);
}
