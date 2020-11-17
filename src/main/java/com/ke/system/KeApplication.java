package com.ke.system;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@MapperScan("com.ke.system")
@SpringBootApplication(scanBasePackages = "com.ke.system")
public class KeApplication {

    public static void main(String[] args) {
        SpringApplication.run(KeApplication.class, args);
    }

}
