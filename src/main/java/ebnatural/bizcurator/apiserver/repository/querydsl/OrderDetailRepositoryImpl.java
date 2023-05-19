package ebnatural.bizcurator.apiserver.repository.querydsl;

import com.querydsl.core.Tuple;
import com.querydsl.jpa.impl.JPAQueryFactory;
import ebnatural.bizcurator.apiserver.domain.QOrderDetail;
import java.util.List;
import javax.persistence.EntityManager;

public class OrderDetailRepositoryImpl implements OrderDetailRepositoryCustom{

    private final JPAQueryFactory queryFactory;

    public OrderDetailRepositoryImpl(EntityManager em) {
        this.queryFactory = new JPAQueryFactory(em);
    }

    @Override
    public List<Tuple> countByDeliveryState(Long memberId) {
        QOrderDetail orderDetail = QOrderDetail.orderDetail;
        return queryFactory
                .select(orderDetail.deliveryState, orderDetail.count())
                .from(orderDetail)
                .where(orderDetail.member.id.eq(memberId))
                .groupBy(orderDetail.deliveryState)
                .orderBy(orderDetail.deliveryState.asc())  // deliveryState 값을 오름차순으로 정렬
                .fetch();
    }

}
