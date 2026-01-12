package com.luun.booking.kitchencontrolbackend;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;

@SpringBootApplication
public class KitchenControlBackendApplication extends SpringBootServletInitializer {

    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
        return application.sources(KitchenControlBackendApplication.class);
    }

    public static void main(String[] args) {
        SpringApplication.run(KitchenControlBackendApplication.class, args);
    }

}
