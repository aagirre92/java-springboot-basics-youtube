package com.codewithmosh.store;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class StoreApplication {

    public static void main(String[] args) {

        ApplicationContext context = SpringApplication.run(StoreApplication.class, args);
        // Dependency Injection via Spring Boot
        var orderService = context.getBean(OrderService.class);
        /*
        Dependency Injection manually via Constructor:

        // Main logic, we pass StripePaymentService as a dependency to OrderService, but if we had another method of
        // payment (e.g. PayPalPaymentService), we could pass it as a dependency to OrderService.
        // This is called Dependency Injection.

        // Example 1: StripePaymentService
        //var orderService = new OrderService(new StripePaymentService());

        // Example 2: PayPalPaymentService
        var orderService = new OrderService(new PayPalPaymentService());
        */

        orderService.placeOrder();
    }

}
