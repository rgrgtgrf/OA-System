package com.lanshan;
import lombok.extern.slf4j.Slf4j;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class})
@MapperScan("com.lanshan")
@Slf4j
public class OaApplication {
    public static void main(String[] args) {
        SpringApplication.run(OaApplication.class, args);
        log.info("server started");
    }
}