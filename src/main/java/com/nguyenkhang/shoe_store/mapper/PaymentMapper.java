package com.nguyenkhang.shoe_store.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import com.nguyenkhang.shoe_store.dto.request.order.PaymentRequest;
import com.nguyenkhang.shoe_store.dto.response.payment.PaymentResponse;
import com.nguyenkhang.shoe_store.entity.Payment;

@Mapper(componentModel = "spring")
public interface PaymentMapper {
    @Mapping(target = "status", constant = "PENDING")
    Payment toPayment(PaymentRequest request);

    PaymentResponse toPaymentResponse(Payment payment);
}
