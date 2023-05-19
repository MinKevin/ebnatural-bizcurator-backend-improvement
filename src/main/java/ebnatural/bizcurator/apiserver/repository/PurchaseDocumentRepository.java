package ebnatural.bizcurator.apiserver.repository;

import ebnatural.bizcurator.apiserver.domain.MakeDocument;
import ebnatural.bizcurator.apiserver.domain.PurchaseDocument;
import ebnatural.bizcurator.apiserver.repository.querydsl.PurchaseDocumentRepositoryCustom;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface PurchaseDocumentRepository extends JpaRepository<PurchaseDocument, Long>, PurchaseDocumentRepositoryCustom {
    @Query("SELECT d FROM PurchaseDocument d where d.member.id = ?1  ORDER BY d.id ASC")
    List<PurchaseDocument> findByMemberId(Long userId);
}
