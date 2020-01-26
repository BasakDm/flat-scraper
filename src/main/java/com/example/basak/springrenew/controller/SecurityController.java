package com.example.basak.springrenew.controller;

import com.example.basak.springrenew.model.UserEntity;
import com.example.basak.springrenew.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.validation.Valid;

@Controller
@RequestMapping("/user")
public class SecurityController {

    private final UserService userService;

    public SecurityController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/login")
    public String getLogin() {
        if (userService.isAuthenticated()) {
            return "redirect:/flat";
        } else {
            return "login";
        }
    }

    @GetMapping("/registration")
    public String registration(Model model) {
        model.addAttribute("user", new UserEntity());
        return "registration";
    }

    @PostMapping("/registration")
    public String createNewUser(@Valid UserEntity user, BindingResult bindingResult) {
        if (userService.findUserByEmail(user.getEmail()) != null) {
            bindingResult
                    .rejectValue("email", "error.user",
                            "There is already a user registered with the email provided");
        } else if (bindingResult.hasErrors()) {
            return "registration";
        }
        userService.saveUser(user);
        return "redirect:/user/login";
    }

}
