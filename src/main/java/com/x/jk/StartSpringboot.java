package com.x.jk;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.support.SpringBootServletInitializer;
import org.springframework.context.annotation.PropertySource;
import org.springframework.scheduling.annotation.EnableScheduling;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

@EnableScheduling
@SpringBootApplication
@PropertySource(value = "classpath:config/webSetting.properties")
public class StartSpringboot extends SpringBootServletInitializer {
    public static void main(String[] args) {
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        try {
            Date now = new Date();
            Date date = format.parse("2018-10-20");
            if (now.getTime()-date.getTime()>0){
                System.out.println("试用期满");
                return;
            }
            SpringApplication.run(StartSpringboot.class, args);
        } catch (ParseException e) {
            e.printStackTrace();
        }
    }
    protected SpringApplicationBuilder configure(
            SpringApplicationBuilder builder) {
        return builder.sources(this.getClass());
    }
}
