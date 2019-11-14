package com.example.basak.springrenew.controller;

import com.example.basak.springrenew.model.UserDetails;
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
public class LoginController {

    private final UserService userService;

    public LoginController(UserService userService) {
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
        model.addAttribute("user", new UserDetails());
        return "registration";
    }

    @PostMapping("/registration")
    public String createNewUser(@Valid UserDetails userDetails, BindingResult bindingResult) {
        UserDetails userDetailsExists = userService.findUserByEmail(userDetails.getEmail());
        if (userDetailsExists != null) {
            bindingResult
                    .rejectValue("email", "error.user",
                            "There is already a user registered with the email provided");
        } else {
            userService.saveUser(userDetails);
        }

        if (bindingResult.hasErrors()) {
            return "registration";
        } else {
            return "redirect:/user/login";
        }
    }

}
