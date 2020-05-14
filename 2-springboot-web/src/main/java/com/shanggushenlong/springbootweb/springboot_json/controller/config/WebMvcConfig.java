package com.shanggushenlong.springbootweb.springboot_json.controller.config;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;

import java.text.SimpleDateFormat;

/**
 * @USER: shanggushenlong
 * @DATE: 2020/5/14
 * @PROJECT_NAME: springboot-web
 **/
@Configuration
public class WebMvcConfig {

    @Bean
    MappingJackson2HttpMessageConverter MyHttpMessageConverter(){
        // 1.创建一个 Convert
        MappingJackson2HttpMessageConverter converter = new MappingJackson2HttpMessageConverter();
        // 2. 创建objectmapper
        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.setDateFormat(new SimpleDateFormat("yyyy/MM/dd"));

        converter.setObjectMapper(objectMapper);
        return converter;
    }

}
