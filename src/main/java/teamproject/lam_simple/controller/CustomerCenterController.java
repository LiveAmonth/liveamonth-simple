package teamproject.lam_simple.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import teamproject.lam_simple.constants.CategoryConstants.CustomerCenterCategory;

@Controller
@RequiredArgsConstructor
@RequestMapping("/customerCenter")
@Slf4j
public class CustomerCenterController {

    @GetMapping
    public String customerCenter(@RequestParam("menu") CustomerCenterCategory menu,Model model) {
        model.addAttribute("sideBarMenus", CustomerCenterCategory.values());
        model.addAttribute("menu", menu);
        return "/customerCenter/customerCenter";
    }
}
