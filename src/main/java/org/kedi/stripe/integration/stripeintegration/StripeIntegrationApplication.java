package org.kedi.stripe.integration.stripeintegration;

import com.stripe.Stripe;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

@SpringBootApplication
public class StripeIntegrationApplication {

    public static void main(String[] args) {
        SpringApplication.run(StripeIntegrationApplication.class, args);


        // This is your test secret API key.
        Stripe.apiKey = "sk_test_51M6JLrEfacFPlTntFX30YVbOEIPvsOJwxwsJ4g4JciFQOwrP8mudiUZWCImCPkVbIEVJUud0bCC6ODJQDxn17RCY00ERonhHFU";

    }

}
