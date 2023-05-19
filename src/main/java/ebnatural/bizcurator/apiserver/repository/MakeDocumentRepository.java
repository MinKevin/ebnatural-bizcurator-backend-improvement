package ebnatural.bizcurator.apiserver.repository;

import ebnatural.bizcurator.apiserver.domain.MakeDocument;
import org.springframework.beans.PropertyValues;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface MakeDocumentRepository extends JpaRepository<MakeDocument, Long> {
    @Query("SELECT d FROM MakeDocument d where d.member.id = ?1 ORDER BY d.id ASC")
    List<MakeDocument> findByMemberId(Long userId);
}
