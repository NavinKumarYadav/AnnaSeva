package com.annaseva.service;

import com.annaseva.model.Order;
import com.annaseva.response.PaymentResponse;
import com.stripe.exception.StripeException;

public interface PaymentService {

    public PaymentResponse createPaymentLink(Order order) throws StripeException;
}
