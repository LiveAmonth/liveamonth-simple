package teamproject.lam_simple.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import teamproject.lam_simple.constants.CategoryConstants;
import teamproject.lam_simple.constants.CategoryConstants.GenderTypes;
import teamproject.lam_simple.dto.UserForm;
import teamproject.lam_simple.service.UserService;

import javax.validation.Valid;

import java.sql.Date;

import static teamproject.lam_simple.constants.CategoryConstants.*;


@Controller
@RequiredArgsConstructor
@RequestMapping("/user")
public class UserController {

    private final UserService userService;

    @ModelAttribute("genderTypes")
    public GenderTypes[] genderTypes(){return GenderTypes.values();}

    @ModelAttribute("emailDomains")
    public EmailDomains[] emailDomains(){return EmailDomains.values();}

    @GetMapping("/login")
    public String login(Model model) {
        return "user/login";
    }

    @GetMapping("/signUp")
    public String signUp(@ModelAttribute("userForm") UserForm userForm) {
        return "user/signUp";
    }

    @PostMapping("/signUp")
    public String save(@Valid @ModelAttribute UserForm userForm, BindingResult bindingResult) {
        if(bindingResult.hasErrors()) return "user/signUp";
//        userService.save(user);
        return "redirect:/";
    }
    
}
