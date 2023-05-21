package ebnatural.bizcurator.apiserver.repository.querydsl;

import com.querydsl.core.Tuple;
import ebnatural.bizcurator.apiserver.domain.RefundApplication;
import ebnatural.bizcurator.apiserver.domain.SellDocument;
import java.time.LocalDateTime;
import java.util.List;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface SellDocumentRepositoryCustom {

    Page<SellDocument> findByApprovedSellDocumentBusinessNameContainingOrderByCreatedAtDesc(String search, Pageable pageable);

    Page<SellDocument> findByAllSellDocumentBusinessNameContainingOrderByCreatedAtDesc(String search, Pageable pageable);

    List<SellDocument> findAllByAfterFilteredDate(Long memberId, LocalDateTime filteredDate);
}
