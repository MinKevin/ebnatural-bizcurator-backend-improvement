package ebnatural.bizcurator.apiserver.repository.querydsl;

import com.querydsl.core.Tuple;
import java.util.List;

public interface OrderDetailRepositoryCustom {

    List<Tuple> countByDeliveryState(Long memberId);
}
