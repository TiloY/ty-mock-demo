package com.ty.tymockdemo;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.ty.tymockdemo.mapper")
public class TyMockDemoApplication {

    public static void main(String[] args) {
        SpringApplication.run(TyMockDemoApplication.class, args);
    }

}
