package com.maryan.zenchef;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@SpringBootApplication
@EnableTransactionManagement
public class ZenChefApplication {

    public static void main(String[] args) {
        SpringApplication.run(ZenChefApplication.class, args);
    }

}
