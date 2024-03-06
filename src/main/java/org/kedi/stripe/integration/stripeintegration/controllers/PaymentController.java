package org.kedi.stripe.integration.stripeintegration.controllers;

import com.google.gson.annotations.SerializedName;
import com.stripe.exception.StripeException;
import com.stripe.model.PaymentIntent;
import com.stripe.param.PaymentIntentCreateParams;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PaymentController {

    static class CreatePaymentItem {
        @SerializedName("id")
        String id;
        public String getId() {
            return id;
        }
    }
    static class CreatePayment {
        @SerializedName("items")
        CreatePaymentItem[] items;
        public CreatePaymentItem[] getItems() {
            return items;
        }
    }

    static class CreatePaymentResponse {
        private String clientSecret;
        public CreatePaymentResponse(String clientSecret) {
            this.clientSecret = clientSecret;
        }
    }


    @PostMapping("create-payment-intent")
    public CreatePaymentResponse CreatePaymentIntent(@RequestBody CreatePayment createPayment) throws StripeException {
            PaymentIntentCreateParams params =
                    PaymentIntentCreateParams.builder()
                            .setAmount(1200L)
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

            return new CreatePaymentResponse(paymentIntent.getClientSecret());


    }
}
