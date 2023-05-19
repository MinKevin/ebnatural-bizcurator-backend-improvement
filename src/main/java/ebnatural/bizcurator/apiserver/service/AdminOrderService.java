package ebnatural.bizcurator.apiserver.service;

import ebnatural.bizcurator.apiserver.domain.CancelApplication;
import ebnatural.bizcurator.apiserver.domain.Category;
import ebnatural.bizcurator.apiserver.domain.Manufacturer;
import ebnatural.bizcurator.apiserver.domain.Member;
import ebnatural.bizcurator.apiserver.domain.OrderDetail;
import ebnatural.bizcurator.apiserver.domain.Product;
import ebnatural.bizcurator.apiserver.domain.RefundApplication;
import ebnatural.bizcurator.apiserver.domain.SellDocument;
import ebnatural.bizcurator.apiserver.domain.constant.ApplicationState;
import ebnatural.bizcurator.apiserver.dto.AdminApplicationDto;
import ebnatural.bizcurator.apiserver.dto.AdminHomeInfoDto;
import ebnatural.bizcurator.apiserver.dto.AdminOrderDetailDto;
import ebnatural.bizcurator.apiserver.dto.AdminUserInfoDto;
import ebnatural.bizcurator.apiserver.dto.SellDocumentDto;
import ebnatural.bizcurator.apiserver.repository.CancelApplicationRepository;
import ebnatural.bizcurator.apiserver.repository.MemberRepository;
import ebnatural.bizcurator.apiserver.repository.OrderDetailRepository;
import ebnatural.bizcurator.apiserver.repository.ProductRepository;
import ebnatural.bizcurator.apiserver.repository.RefundApplicationRepository;
import ebnatural.bizcurator.apiserver.repository.SellDocumentRepository;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.util.Pair;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class AdminOrderService {

    private final int PAGE_SIZE = 6; // 페이지네이션 - 한 페이지에 보이는 내역 개수
    private final MemberRepository memberRepository;
    private final OrderDetailRepository orderDetailRepository;
    private final ProductRepository productRepository;

    private final CancelApplicationRepository cancelApplicationRepository;
    private final RefundApplicationRepository refundApplicationRepository;
    private final SellDocumentRepository sellDocumentRepository;

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
     * 총주문수 와 주문내역 리스트를 페이지네이션과 검색 키워드를 통해 반환
     * @return
     */
    public Pair<Integer, List<AdminOrderDetailDto>> showOrderDetailListByPageIndexAndSearchKeyword(Integer page, String search) {
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

        return Pair.of((int) orderDetailPage.getTotalElements() ,adminOrderDetailDtoList);
    }


    /**
     * 총 신청수 와 주문 취소신청 리스트를 페이지네이션과 검색 키워드를 통해 반환
     * @return
     */
    public Pair<Integer, List<AdminApplicationDto>> showOrderCancelListByPageIndexAndSearchKeyword(Integer page, String search) 
    {
        page = (page == null) ? 0 : page - 1;

        PageRequest pageable = PageRequest.of(page, PAGE_SIZE);
        Page<CancelApplication> cancelApplicationPage = null;
        if (search == null) {
            cancelApplicationPage = cancelApplicationRepository.findAllByOrderByCreatedAtDesc(pageable);
        } else{
            cancelApplicationPage = cancelApplicationRepository.findByOrderDetailProduct_NameContainingOrderByCreatedAtDesc(search, pageable);
        }

        List<AdminApplicationDto> adminApplicationDtoList = new ArrayList<>();
        for (CancelApplication cancelApplication : cancelApplicationPage) {
            Object[] results = (Object[]) cancelApplicationRepository.findOrderDetailWithProductAndManufacturerAndCategoryById(cancelApplication.getId());

            OrderDetail orderDetail = (OrderDetail) ((Object[]) results[0])[0];
            Product product = (Product) ((Object[]) results[0])[1];
            Manufacturer manufacturer = (Manufacturer) ((Object[]) results[0])[2];
            Category category = (Category) ((Object[]) results[0])[3];

            AdminApplicationDto adminApplicationDto = AdminApplicationDto.of(
                    cancelApplication.getId(),
                    product.getName(),
                    manufacturer.getName(),
                    category.getName(),
                    orderDetail.getOrderTime(),
                    cancelApplication.getState().getMeaning(),
                    orderDetail.getQuantity(),
                    orderDetail.getCost(),
                    cancelApplication.getOpinionCategory().getMeaning()
            );

            adminApplicationDtoList.add(adminApplicationDto);
        }

        return Pair.of((int) cancelApplicationPage.getTotalElements() ,adminApplicationDtoList);
    }

    /**
     * 총 신청수 와 주문 환불신청 리스트를 페이지네이션과 검색 키워드를 통해 반환
     * @return
     */
    public Pair<Integer, List<AdminApplicationDto>> showOrderRefundListByPageIndexAndSearchKeyword(Integer page, String search)
    {
        page = (page == null) ? 0 : page - 1;

        PageRequest pageable = PageRequest.of(page, PAGE_SIZE);
        Page<RefundApplication> refundApplicationPage = null;
        refundApplicationPage = refundApplicationRepository.findByOrderDetailProduct_NameContainingOrderByCreatedAtDesc(
                search, pageable);

        List<AdminApplicationDto> adminApplicationDtoList = new ArrayList<>();
        for (RefundApplication refundApplication : refundApplicationPage) {
            Object[] results = (Object[]) refundApplicationRepository.findOrderDetailWithProductAndManufacturerAndCategoryById(refundApplication.getId());

            OrderDetail orderDetail = (OrderDetail) ((Object[]) results[0])[0];
            Product product = (Product) ((Object[]) results[0])[1];
            Manufacturer manufacturer = (Manufacturer) ((Object[]) results[0])[2];
            Category category = (Category) ((Object[]) results[0])[3];

            AdminApplicationDto adminApplicationDto = AdminApplicationDto.of(
                    refundApplication.getId(),
                    product.getName(),
                    manufacturer.getName(),
                    category.getName(),
                    orderDetail.getOrderTime(),
                    refundApplication.getState().getMeaning(),
                    orderDetail.getQuantity(),
                    orderDetail.getCost(),
                    refundApplication.getOpinionCategory().getMeaning()
            );

            adminApplicationDtoList.add(adminApplicationDto);
        }

        return Pair.of((int) refundApplicationPage.getTotalElements() ,adminApplicationDtoList);
    }

    /**
     * 주문 취소 신청서 승인, 거절 처리를 한다.
     */
    public void changeStateCancelApplication(Long applicationId, boolean isApproved) {
        CancelApplication cancelApplication = cancelApplicationRepository.findById(applicationId)
                .orElseThrow(() -> new EntityNotFoundException());

        cancelApplication.setState((true == isApproved) ? ApplicationState.APPROVE : ApplicationState.REJECTED);

        cancelApplicationRepository.save(cancelApplication);
    }

    /**
     * 주문 환불 신청서 승인, 거절 처리를 한다.
     */
    public void changeStateRefundApplication(Long applicationId, boolean isApproved) {
        RefundApplication refundApplication = refundApplicationRepository.findById(applicationId)
                .orElseThrow(() -> new EntityNotFoundException());

        refundApplication.setState((true == isApproved) ? ApplicationState.APPROVE : ApplicationState.REJECTED);

        refundApplicationRepository.save(refundApplication);
    }

    /**
     * 회원 리스트 조회
     */
    public Pair<Integer, List<AdminUserInfoDto>> showUserListByPageIndexAndSearchKeyword(Integer page, String search)
    {
        page = (page == null) ? 0 : page - 1;

        PageRequest pageable = PageRequest.of(page, PAGE_SIZE);
        Page<Member> memberPage = null;
        memberPage = memberRepository.findByMemberUserNameContainingOrderByCreatedAtDesc(
                search, pageable);

        List<AdminUserInfoDto> adminApplicationDtoList = new ArrayList<>();
        for (Member member : memberPage) {
            AdminUserInfoDto adminUserInfoDto = AdminUserInfoDto.of(
                    member.getUsername(),
                    member.getBusinessName(),
                    member.getBusinessNumber(),
                    member.getManagerPhoneNumber(),
                    member.getManager(),
                    member.getAddress()
            );

            adminApplicationDtoList.add(adminUserInfoDto);
        }

        return Pair.of((int) memberPage.getTotalElements() ,adminApplicationDtoList);
    }

    /**
     *  입점판매사 조회
     */
    public Pair<Integer, List<SellDocumentDto>> showPartnerListByPageIndexAndSearchKeyword(Integer page, String search)
    {
        page = (page == null) ? 0 : page - 1;

        PageRequest pageable = PageRequest.of(page, PAGE_SIZE);
        Page<SellDocument> sellDocumentPage = null;
        sellDocumentPage = sellDocumentRepository.findBySellDocumentBusinessNameContainingOrderByCreatedAtDesc(
                search, pageable);

        List<SellDocumentDto> sellDocumentDtoList = new ArrayList<>();
        for (SellDocument sellDocument : sellDocumentPage) {
            SellDocumentDto sellDocumentDto = SellDocumentDto.from(sellDocument);
            sellDocumentDtoList.add(sellDocumentDto);
        }

        return Pair.of((int) sellDocumentPage.getTotalElements() ,sellDocumentDtoList);
    }
}
