package com.betaplan.tvshows_belt_exam.controllers;

import com.betaplan.tvshows_belt_exam.models.User;
import com.betaplan.tvshows_belt_exam.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

@Controller
public class UserConntroller {
    @Autowired
    private UserService userService;

    @GetMapping("/")
    public String registerForm(@ModelAttribute("user") User user, Model model) {
        model.addAttribute("user", user);
        return "user/registrationLoginPage";
    }


    @PostMapping("/registration")
    public String registerUser(@Valid @ModelAttribute("user") User user, BindingResult result, HttpSession session, Model model, @RequestParam("email") String email, @RequestParam("password") String password) {

        if (!user.getPassword().equals(user.getPasswordConfirmation())) {
            model.addAttribute("error", "Passwords do not match!");
            return "user/registrationLoginPage";
        }

        if (userService.findByEmail(user.getEmail()) != null) {
            model.addAttribute("errorReg", "This user already exists!");
            return "user/registrationLoginPage";
        }

        if (result.hasErrors()) {
            return "user/registrationLoginPage";
        } else {
            userService.registerUser(user);
            session.setAttribute("userId", user.getId());
            return "redirect:/shows";
        }

    }

    @PostMapping("/login")
    public String loginUser(@ModelAttribute("user") User user, @RequestParam("email") String email, @RequestParam("password") String password, Model model, HttpSession session) {
        boolean isAuthenticated = userService.authenticateUser(email, password);
        if (isAuthenticated) {
            Long userId = userService.findByEmail(email).getId();
            session.setAttribute("userId", userId);
            return "redirect:/shows";
        } else {
            model.addAttribute("errorLogin", "The email address or password is incorrect");
            return "user/registrationLoginPage";
        }
    }


    @GetMapping("/logout")
    public String logout(HttpSession session) {
        session.removeAttribute("userId");
        return "redirect:/";
    }
}
