package org.kedi.stripe.integration.stripeintegration;

import com.stripe.Stripe;
import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

@SpringBootApplication
public class StripeIntegrationApplication {

    @Value("${stripe.api.key}")
    String apiKey;

    @PostConstruct()
    public void setup(){
        Stripe.apiKey = apiKey;
    }

    public static void main(String[] args) {



        SpringApplication.run(StripeIntegrationApplication.class, args);




    }

}
