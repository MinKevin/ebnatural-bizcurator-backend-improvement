package ebnatural.bizcurator.apiserver.repository.querydsl;

import com.querydsl.core.Tuple;
import ebnatural.bizcurator.apiserver.domain.PurchaseDocument;
import ebnatural.bizcurator.apiserver.domain.SellDocument;
import java.time.LocalDateTime;
import java.util.List;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface PurchaseDocumentRepositoryCustom {

    Page<PurchaseDocument> findByAllDocumentCategoryContainingOrderByCreatedAtDesc(String search, Pageable pageable);

    List<PurchaseDocument> findAllByAfterFilteredDate(Long memberId, LocalDateTime filteredDate);
}
