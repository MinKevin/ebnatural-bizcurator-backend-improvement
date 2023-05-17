package ebnatural.bizcurator.apiserver.service;

import ebnatural.bizcurator.apiserver.domain.Category;
import ebnatural.bizcurator.apiserver.domain.Manufacturer;
import ebnatural.bizcurator.apiserver.domain.OrderDetail;
import ebnatural.bizcurator.apiserver.domain.Product;
import ebnatural.bizcurator.apiserver.dto.AdminHomeInfoDto;
import ebnatural.bizcurator.apiserver.dto.AdminOrderDetailDto;
import ebnatural.bizcurator.apiserver.repository.MemberRepository;
import ebnatural.bizcurator.apiserver.repository.OrderDetailRepository;
import ebnatural.bizcurator.apiserver.repository.ProductRepository;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class AdminOrderService {

    private final int PAGE_SIZE = 6;
    private final MemberRepository memberRepository;
    private final OrderDetailRepository orderDetailRepository;

    private final ProductRepository productRepository;
    /**
     * 관리자페이지 홈 화면 정보를 반환
     * @return
     */
    public AdminHomeInfoDto showHomeInformation() {
        return AdminHomeInfoDto.of(
                (int) memberRepository.count(),
                memberRepository.countByLastLoginTime(LocalDate.now())
        );
    }

    /**
     * 주문내역 리스트를 페이지네이션과 검색 키워드를 통해 반환
     * @return
     */
    public List<AdminOrderDetailDto> showOrderDetailListByPageIndexAndSearchKeyword(Integer page, String search) {
        if (null == page) {
            page = 0;
        }

        PageRequest pageable = PageRequest.of(page, PAGE_SIZE);
        Page<OrderDetail> orderDetailPage = null;
        if (search == null) {
            orderDetailPage = orderDetailRepository.findAllByOrderByOrderTimeDesc(pageable);
        } else{
            orderDetailPage = orderDetailRepository.findAllByProduct_NameContainingIgnoreCaseOrderByOrderTimeDesc(search, pageable);
        }

        List<AdminOrderDetailDto> adminOrderDetailDtoList = new ArrayList<>();
        for (OrderDetail orderDetail : orderDetailPage) {
            Product product = orderDetailRepository.findProductById(orderDetail.getId());
            Object[] results = (Object[]) productRepository.findManufacturerAndCategoryById(product.getId());

            Manufacturer manufacturer = (Manufacturer) ((Object[]) results[0])[0];
            Category category = (Category) ((Object[]) results[0])[1];

            AdminOrderDetailDto adminOrderDetailDto = AdminOrderDetailDto.of(
                    orderDetail.getId(),
                    product.getName(),
                    manufacturer.getName(),
                    category.getName(),
                    orderDetail.getOrderTime().toString(),
                    orderDetail.getDeliveryState().getMeaning(),
                    orderDetail.getQuantity(),
                    orderDetail.getCost(),
                    orderDetail.getInvoiceNumber()
            );

            adminOrderDetailDtoList.add(adminOrderDetailDto);
        }

        return adminOrderDetailDtoList;
    }
}
