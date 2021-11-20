package teamproject.lam_simple.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import teamproject.lam_simple.constants.CategoryConstants;
import teamproject.lam_simple.constants.CategoryConstants.CustomerCenterCategory;
import teamproject.lam_simple.service.CustomerCenterService;

@Controller
@RequiredArgsConstructor
@RequestMapping("/customerCenter")
@Slf4j
public class CustomerCenterController {
    private final CustomerCenterService customerCenterService;

    @GetMapping
    public String customerCenter(@RequestParam("menu") CustomerCenterCategory menu,Model model) {
        model.addAttribute("customerCenterMenus", CustomerCenterCategory.values());
        model.addAttribute("menu", menu);
        return "/customerCenterView/customerCenter";
    }
}
