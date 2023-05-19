package ebnatural.bizcurator.apiserver.repository.querydsl;

import ebnatural.bizcurator.apiserver.domain.MakeDocument;
import ebnatural.bizcurator.apiserver.domain.PurchaseDocument;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface MakeDocumentRepositoryCustom {

    Page<MakeDocument> findByAllDocumentCategoryContainingOrderByCreatedAtDesc(String search, Pageable pageable);
}
