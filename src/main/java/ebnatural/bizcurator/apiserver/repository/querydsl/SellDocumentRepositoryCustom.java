package ebnatural.bizcurator.apiserver.repository.querydsl;

import ebnatural.bizcurator.apiserver.domain.RefundApplication;
import ebnatural.bizcurator.apiserver.domain.SellDocument;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface SellDocumentRepositoryCustom {

    Page<SellDocument> findByApprovedSellDocumentBusinessNameContainingOrderByCreatedAtDesc(String search, Pageable pageable);

    Page<SellDocument> findByAllSellDocumentBusinessNameContainingOrderByCreatedAtDesc(String search, Pageable pageable);
}
