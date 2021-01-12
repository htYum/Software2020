package com.project.software2020;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@SpringBootApplication
@MapperScan("com.project.software2020")
public class Software2020Application {

    public static void main(String[] args) {
        SpringApplication.run(Software2020Application.class, args);
    }

}
