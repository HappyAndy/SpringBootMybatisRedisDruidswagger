package com.jiaqi;

import org.apache.log4j.Logger;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@EnableAutoConfiguration
@SpringBootApplication
@ComponentScan
public class SpringBootMybatisRedisDruidSwaggerApplication {
    private static Logger logger = Logger.getLogger(SpringBootMybatisRedisDruidSwaggerApplication.class);

    /**
     * Start
     */
    public static void main(String[] args) {
        SpringApplication.run(SpringBootMybatisRedisDruidSwaggerApplication.class, args);
        logger.info("SpringBoot Start Success");
    }

}
