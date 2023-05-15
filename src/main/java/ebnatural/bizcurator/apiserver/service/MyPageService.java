package ebnatural.bizcurator.apiserver.service;

import ebnatural.bizcurator.apiserver.domain.Member;
import ebnatural.bizcurator.apiserver.domain.OrderDetail;
import ebnatural.bizcurator.apiserver.domain.Product;
import ebnatural.bizcurator.apiserver.domain.constant.DeliveryState;
import ebnatural.bizcurator.apiserver.dto.PaymentDetailDto;
import ebnatural.bizcurator.apiserver.dto.PaymentDetailDto.OrderDetailDto;
import ebnatural.bizcurator.apiserver.dto.PaymentHistoryDto;
import ebnatural.bizcurator.apiserver.dto.PaymentHistoryDto.OrderHistoryDto;
import ebnatural.bizcurator.apiserver.repository.MemberRepository;
import ebnatural.bizcurator.apiserver.repository.OrderDetailRepository;
import ebnatural.bizcurator.apiserver.repository.ProductRepository;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;
import lombok.RequiredArgsConstructor;
import org.hibernate.Hibernate;
import org.hibernate.LazyInitializationException;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class MyPageService {

    private final MemberRepository memberRepository;
    private final OrderDetailRepository orderDetailRepository;
    private final ProductRepository productRepository;
    // todo: 시큐리티 완성되면 수정
    //private final JwtProvider jwtProvider;

    public List<PaymentHistoryDto> getAllPaymentHistory(Integer filterMonth, String deliveryStateText) {

        List<OrderDetail> orderDetailList = null;
        // todo: 시큐리티 완성되면 수정
        Long memberId = 1L; // jwtProvider.getUserIDByToken(accessToken);

        if (filterMonth != null && deliveryStateText != null) {
            LocalDateTime filterDate = LocalDateTime.now().minusDays(filterMonth);
            DeliveryState deliveryState = DeliveryState.valueOf(deliveryStateText.toUpperCase());
            orderDetailList = orderDetailRepository.findAllByMemberIdAndOrderTimeAfterAndDeliveryState(memberId, filterDate, deliveryState);
        } else if (filterMonth != null) {
            LocalDateTime filterDate = LocalDateTime.now().minusDays(filterMonth);
            orderDetailList = orderDetailRepository.findAllByMemberIdAndOrderTimeAfter(memberId, filterDate);
        } else if (deliveryStateText != null) {
            DeliveryState deliveryState = DeliveryState.valueOf(deliveryStateText.toUpperCase());
            orderDetailList = orderDetailRepository.findAllByMemberIdAndDeliveryState(memberId, deliveryState);
        } else {
            orderDetailList = orderDetailRepository.findAllByMemberId(memberId);
        }

        if (orderDetailList.isEmpty()) {
            return null;
        }

        Map<Long, List<OrderDetail>> paymentGroupMap = new HashMap<>();
        for (OrderDetail orderDetail : orderDetailList) {
            Long paymentId = orderDetail.getPaymentId();

            List<OrderDetail> paymentGroup = paymentGroupMap.getOrDefault(paymentId, new ArrayList<>());
            paymentGroup.add(orderDetail);
            paymentGroupMap.put(paymentId, paymentGroup);
        }

        List<PaymentHistoryDto> paymentHistoryDtoList = paymentGroupMap.entrySet().stream()
                .map(entry -> createPaymentHistoryResponse(entry.getKey(), entry.getValue()))
                .collect(Collectors.toList());

        return paymentHistoryDtoList;
    }

    private PaymentHistoryDto createPaymentHistoryResponse(Long paymentId, List<OrderDetail> orderDetails) {
        List<OrderHistoryDto> orderHistoryDtoList = new ArrayList<>();

        for (OrderDetail orderDetail : orderDetails) {
            Optional<Product> product = productRepository.findById(orderDetail.getProduct().getId());

            OrderHistoryDto orderHistoryResponse = OrderHistoryDto.of(orderDetail.getId(),
                    // todo: product와 productimage 연관관계
                    "",
                    product.map(Product::getRegularPrice).orElse(null),
                    orderDetail.getDeliveryState().getMeaning(),
                    orderDetail.getOrderTime(),
                    product.map(Product::getName).orElse(null),
                    orderDetail.getQuantity(),
                    orderDetail.getCost());

            orderHistoryDtoList.add(orderHistoryResponse);
        }

        PaymentHistoryDto paymentHistoryDto = PaymentHistoryDto.of(paymentId, orderHistoryDtoList);
        return paymentHistoryDto;
    }


    public PaymentDetailDto getAllPaymentDetails(Long paymentId) {

        List<OrderDetail> orderDetailList = null;
        // todo: 시큐리티 완성되면 수정
        Long memberId = 1L; // jwtProvider.getUserIDByToken(accessToken);

        orderDetailList = orderDetailRepository.findAllByPaymentIdAndMemberId(paymentId, memberId);

        if (orderDetailList.isEmpty()) {
            return null;
        }

        List<OrderDetailDto> orderDetailDtoList = new ArrayList<>();
        int totalCost = 0;

        for (OrderDetail orderDetail : orderDetailList) {
            Optional<Product> product = productRepository.findById(orderDetail.getProduct().getId());

            OrderDetailDto orderDetailDto = OrderDetailDto.of(orderDetail.getId(),
                    product.map(Product::getName).orElse(""),
                    "image",
                    orderDetail.getCost(),
                    orderDetail.getQuantity(),
                    orderDetail.getDeliveryState().getMeaning());

            totalCost += orderDetail.getCost();
            orderDetailDtoList.add(orderDetailDto);
        }

        Optional<Member> member = memberRepository.findById(memberId);

        PaymentDetailDto paymentDetailDto = PaymentDetailDto.of(paymentId,
                orderDetailList.get(0).getOrderTime(),
                member.map(Member::getUsername).orElse("name not found"),
                orderDetailList.get(0).getPaymentMethod(),
                totalCost,
                orderDetailList.get(0).getShippingFee(),
                orderDetailList.get(0).getPostalCode(),
                orderDetailList.get(0).getAddress(),
                orderDetailList.get(0).getRequestContent(),
                orderDetailDtoList
        );

        return paymentDetailDto;
    }

}
