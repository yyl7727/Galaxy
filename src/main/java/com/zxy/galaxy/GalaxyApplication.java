package com.zxy.galaxy;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan(value = {"com.zxy.galaxy.Mapper"})
public class GalaxyApplication {

    public static void main(String[] args) {
        SpringApplication.run(GalaxyApplication.class, args);
    }

}
