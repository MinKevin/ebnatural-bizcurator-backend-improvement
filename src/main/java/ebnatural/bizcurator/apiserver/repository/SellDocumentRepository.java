package ebnatural.bizcurator.apiserver.repository;

import ebnatural.bizcurator.apiserver.domain.SellDocument;
import org.springframework.beans.PropertyValues;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface SellDocumentRepository extends JpaRepository<SellDocument, Long> {
    @Query("SELECT d FROM SellDocument d where d.member.id = ?1  ORDER BY d.id ASC")
    List<SellDocument> findByMemberId(Long memberId);
}
