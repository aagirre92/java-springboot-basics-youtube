package com.codewithmosh.store;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

@Service
public class OrderService {
    // OrderService works with the interface PaymentService! Then from the main controller we'll
    // pass the implementation of the PaymentService (e.g. StripePaymentService or PayPalPaymentService)
    // We pass it via constructor injection. (it can be done also with setter injection)
    // Constructor is the recommended way to inject dependencies. (as it is below and in our code)

    private PaymentService paymentService;
    // @Autowired would be needed if we'd use multiple constructors, e.g. having public OrderService() {} above
    public OrderService(PaymentService paymentService) {
        this.paymentService = paymentService;
    }
    public void placeOrder() {
        paymentService.processPayment(100);
    }
}
