package org.kedi.stripe.integration.stripeintegration.controllers;

import org.springframework.web.bind.annotation.PostMapping;

public class PaymentController {

    @PostMapping("create-payment-intent")
    public void CreatePaymentIntent(){


            PaymentIntentCreateParams params =
                    PaymentIntentCreateParams.builder()
                            .setAmount(new Long(calculateOrderAmount(postBody.getItems())))
                            .setCurrency("eur")
                            // In the latest version of the API, specifying the `automatic_payment_methods` parameter is optional because Stripe enables its functionality by default.
                            .setAutomaticPaymentMethods(
                                    PaymentIntentCreateParams.AutomaticPaymentMethods
                                            .builder()
                                            .setEnabled(true)
                                            .build()
                            )
                            .build();

            // Create a PaymentIntent with the order amount and currency
            PaymentIntent paymentIntent = PaymentIntent.create(params);

            CreatePaymentResponse paymentResponse = new CreatePaymentResponse(paymentIntent.getClientSecret());
            return gson.toJson(paymentResponse);


    }
}
