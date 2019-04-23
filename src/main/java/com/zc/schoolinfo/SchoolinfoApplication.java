package com.zc.schoolinfo;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
@SpringBootApplication
@MapperScan("com.zc.schoolinfo.dao")
public class SchoolinfoApplication {

    public static void main(String[] args) {
        SpringApplication.run(SchoolinfoApplication.class, args);
    }

}

