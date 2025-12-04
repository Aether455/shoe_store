package com.nguyenkhang.mobile_store.dto.response.order;

import java.time.LocalDateTime;
import java.util.List;

import com.nguyenkhang.mobile_store.dto.response.payment.PaymentResponse;
import com.nguyenkhang.mobile_store.dto.response.vouchers.VoucherResponseForCustomer;
import com.nguyenkhang.mobile_store.enums.OrderStatus;

import lombok.*;
import lombok.experimental.FieldDefaults;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@FieldDefaults(level = AccessLevel.PRIVATE)
public class OrderResponseForCustomer {

    Long id;

    String orderCode;
    String receiverName;
    String shippingAddress;
    String province;
    String district;
    String ward;
    String phoneNumber;
    OrderStatus status;
    String note;
    double reducedAmount;
    double totalAmount;
    double finalAmount;

    VoucherResponseForCustomer voucher;

    List<OrderItemResponse> orderItems;
    PaymentResponse payment;

    LocalDateTime createAt;
}
