package teamproject.lam_simple.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ResponseBody;
import teamproject.lam_simple.service.UserService;


@Controller
@RequiredArgsConstructor
@ResponseBody
public class UserController {

    private final UserService userService;

}
