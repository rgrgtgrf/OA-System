package com.lanshan.oaserver;
import lombok.extern.slf4j.Slf4j;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@SpringBootApplication
@Slf4j
public class OaApplication {
    public static void main(String[] args) {
        SpringApplication.run(OaApplication.class, args);
        log.info("server started");
    }
}