package ebnatural.bizcurator.apiserver.repository.querydsl;

import com.querydsl.core.BooleanBuilder;
import com.querydsl.core.types.Predicate;
import com.querydsl.jpa.impl.JPAQueryFactory;
import ebnatural.bizcurator.apiserver.domain.MakeDocument;
import ebnatural.bizcurator.apiserver.domain.PurchaseDocument;
import ebnatural.bizcurator.apiserver.domain.QMakeDocument;
import ebnatural.bizcurator.apiserver.domain.QPurchaseDocument;
import ebnatural.bizcurator.apiserver.domain.QSellDocument;
import ebnatural.bizcurator.apiserver.domain.SellDocument;
import ebnatural.bizcurator.apiserver.domain.constant.StateType;
import java.util.List;
import javax.persistence.EntityManager;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;

public class MakeDocumentRepositoryImpl implements MakeDocumentRepositoryCustom{
    private final JPAQueryFactory queryFactory;

    public MakeDocumentRepositoryImpl(EntityManager em) {
        this.queryFactory = new JPAQueryFactory(em);
    }

    @Override
    public Page<MakeDocument> findByAllDocumentCategoryContainingOrderByCreatedAtDesc(
            String search, Pageable pageable) {
        QMakeDocument qMakeDocument = QMakeDocument.makeDocument;

        BooleanBuilder predicateBuilder = new BooleanBuilder();

        if (search == null) {
            // No search keyword provided, retrieve all sell documents
            predicateBuilder.and(qMakeDocument.isNotNull());
        } else {
            // Search sell documents by purposeCategory name containing the provided search keyword
            predicateBuilder.and(qMakeDocument.purposeCategory.name.containsIgnoreCase(search));
        }

        Predicate predicate = predicateBuilder.getValue();
        long total = queryFactory.selectFrom(qMakeDocument)
                .leftJoin(qMakeDocument.purposeCategory).fetchJoin() // Perform fetch join on category
                .where(predicate)
                .fetchCount();

        List<MakeDocument> makeDocumentList = queryFactory.selectFrom(qMakeDocument)
                .leftJoin(qMakeDocument.purposeCategory).fetchJoin() // Perform fetch join on category
                .where(predicate)
                .orderBy(qMakeDocument.createdAt.desc())
                .offset(pageable.getOffset())
                .limit(pageable.getPageSize())
                .fetch();

        return new PageImpl<>(makeDocumentList, pageable, total);
    }

}
