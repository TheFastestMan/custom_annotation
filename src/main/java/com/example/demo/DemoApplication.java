package com.example.demo;

import com.example.demo.dto.UserDTO;
import com.example.demo.service.UserService;
import org.modelmapper.ModelMapper;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.Optional;

@SpringBootApplication
public class DemoApplication {

    public static void main(String[] args) {
        var c = SpringApplication.run(DemoApplication.class, args);
        var t = c.getBean(UserService.class);


    }
    @Bean
    public ModelMapper modelMapper() {
        return new ModelMapper();
    }
}
