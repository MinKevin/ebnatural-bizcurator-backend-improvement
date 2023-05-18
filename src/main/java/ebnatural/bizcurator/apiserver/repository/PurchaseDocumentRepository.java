package ebnatural.bizcurator.apiserver.repository;

import ebnatural.bizcurator.apiserver.domain.PurchaseDocument;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PurchaseDocumentRepository extends JpaRepository<PurchaseDocument, Long> {
}
