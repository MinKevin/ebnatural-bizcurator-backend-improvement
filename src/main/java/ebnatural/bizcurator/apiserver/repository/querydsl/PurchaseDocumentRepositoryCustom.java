package ebnatural.bizcurator.apiserver.repository.querydsl;

import ebnatural.bizcurator.apiserver.domain.PurchaseDocument;
import ebnatural.bizcurator.apiserver.domain.SellDocument;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface PurchaseDocumentRepositoryCustom {

    Page<PurchaseDocument> findByAllDocumentCategoryContainingOrderByCreatedAtDesc(String search, Pageable pageable);
}
