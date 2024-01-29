package com.example.demo.controller;

import com.example.demo.dto.UserDTO;
import com.example.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/user")
public class UserController {
    @Autowired
    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping
    public String registration(Model model) {
        model.addAttribute("userDTO", new UserDTO());
        return "web/registration";
    }

    @PostMapping("/registration")
    public String registration(@ModelAttribute("userDTO") @Validated UserDTO userDTO,
                        BindingResult bindingResult) {

        if (bindingResult.hasErrors() && userDTO.getAge() >= 18) {
            return "web/registration";
        }
        if (userDTO.getAge() != null && userDTO.getAge() < 18) {
            return "redirect:/user/warning";
        }
        return "web/display";
    }

    @GetMapping("/warning")
    public String warning() {
        return "web/warning";
    }


}
