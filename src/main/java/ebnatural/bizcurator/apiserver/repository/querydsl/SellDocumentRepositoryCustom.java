package ebnatural.bizcurator.apiserver.repository.querydsl;

import ebnatural.bizcurator.apiserver.domain.RefundApplication;
import ebnatural.bizcurator.apiserver.domain.SellDocument;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface SellDocumentRepositoryCustom {

    Page<SellDocument> findBySellDocumentBusinessNameContainingOrderByCreatedAtDesc(String search, Pageable pageable);
}
