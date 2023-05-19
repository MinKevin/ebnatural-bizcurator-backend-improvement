package ebnatural.bizcurator.apiserver.repository.querydsl;

import com.querydsl.core.BooleanBuilder;
import com.querydsl.core.types.Predicate;
import com.querydsl.jpa.impl.JPAQueryFactory;
import ebnatural.bizcurator.apiserver.domain.QRefundApplication;
import ebnatural.bizcurator.apiserver.domain.QSellDocument;
import ebnatural.bizcurator.apiserver.domain.RefundApplication;
import ebnatural.bizcurator.apiserver.domain.SellDocument;
import ebnatural.bizcurator.apiserver.domain.constant.StateType;
import java.util.List;
import javax.persistence.EntityManager;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;

public class SellDocumentRepositoryImpl implements SellDocumentRepositoryCustom{
    private final JPAQueryFactory queryFactory;

    public SellDocumentRepositoryImpl(EntityManager em) {
        this.queryFactory = new JPAQueryFactory(em);
    }

    @Override
    public Page<SellDocument> findBySellDocumentBusinessNameContainingOrderByCreatedAtDesc(
            String search, Pageable pageable) {
        QSellDocument qSellDocument = QSellDocument.sellDocument;

        BooleanBuilder predicateBuilder = new BooleanBuilder();

        if (search == null) {
            // No search keyword provided, retrieve all refund applications
            predicateBuilder.and(qSellDocument.isNotNull());
        } else {
            // Search refund applications by business name containing the provided search keyword
            predicateBuilder.and(qSellDocument.businessName.containsIgnoreCase(search));
        }

        // Add condition for stateType being APPROVE
        predicateBuilder.and(qSellDocument.stateType.eq(StateType.APPROVE));

        Predicate predicate = predicateBuilder.getValue();
        long total = queryFactory.selectFrom(qSellDocument)
                .where(predicate)
                .fetchCount();

        List<SellDocument> sellDocumentList = queryFactory.selectFrom(qSellDocument)
                .where(predicate)
                .orderBy(qSellDocument.createdAt.desc())
                .offset(pageable.getOffset())
                .limit(pageable.getPageSize())
                .fetch();

        return new PageImpl<>(sellDocumentList, pageable, total);
    }
}
