package com.example.demo.dto;

import com.example.demo.validation.AgeValidation;
import jakarta.validation.constraints.Size;
import lombok.*;

@Builder
@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class UserDTO {

    private Long id;
    @Size(min = 3, message = "username less 3")
    private String username;
    @Size(min = 3, message = "password less 3")
    private String password;
    @AgeValidation
    private Integer age;

}
