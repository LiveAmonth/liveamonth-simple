package teamproject.lam_simple.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import teamproject.lam_simple.domain.User;
import teamproject.lam_simple.dto.UserForm;
import teamproject.lam_simple.service.UserService;


@Controller
@RequiredArgsConstructor
@RequestMapping("/user")
public class UserController {

    private final UserService userService;

    @GetMapping("/login")
    public String login(Model model) {
        return "/user/login";
    }
    @GetMapping("/signUp")
    public String signUp(Model model) {
//        model.addAttribute("userForm", User.builder());
        return "/user/signUp";
    }
    
}
