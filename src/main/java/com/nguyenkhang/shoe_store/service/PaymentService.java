package com.nguyenkhang.shoe_store.service;

import org.springframework.stereotype.Service;

import com.nguyenkhang.shoe_store.dto.request.order.PaymentUpdateRequest;
import com.nguyenkhang.shoe_store.dto.response.payment.PaymentResponse;
import com.nguyenkhang.shoe_store.entity.Payment;
import com.nguyenkhang.shoe_store.exception.AppException;
import com.nguyenkhang.shoe_store.exception.ErrorCode;
import com.nguyenkhang.shoe_store.mapper.PaymentMapper;
import com.nguyenkhang.shoe_store.repository.PaymentRepository;

import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class PaymentService {
    PaymentRepository paymentRepository;
    PaymentMapper paymentMapper;

    public PaymentResponse updatePaymentStatus(long id, PaymentUpdateRequest request) {
        Payment payment =
                paymentRepository.findById(id).orElseThrow(() -> new AppException(ErrorCode.PAYMENT_NOT_EXISTED));
        payment.setStatus(request.getStatus());

        payment = paymentRepository.save(payment);
        return paymentMapper.toPaymentResponse(payment);
    }
}
