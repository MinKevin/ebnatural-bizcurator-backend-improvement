package ebnatural.bizcurator.apiserver.repository;

import ebnatural.bizcurator.apiserver.domain.SellDocument;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SellDocumentRepository extends JpaRepository<SellDocument, Long> {
}
