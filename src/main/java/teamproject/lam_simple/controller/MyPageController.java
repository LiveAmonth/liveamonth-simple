package teamproject.lam_simple.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import teamproject.lam_simple.constants.CategoryConstants;
import teamproject.lam_simple.constants.CategoryConstants.AccountCategory;
import teamproject.lam_simple.constants.CategoryConstants.CommunityCategory;
import teamproject.lam_simple.constants.CategoryConstants.InquiryCategory;
import teamproject.lam_simple.service.UserService;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Controller
@RequiredArgsConstructor
@RequestMapping("/myPage")
public class MyPageController extends ContentsController{

    private final UserService userService;
    @ModelAttribute("sideBarMenus")
    public List<Map<String,Object>> sideBarMenus() {
        List<Map<String,Object>> list = new ArrayList<>();
        list.add(this.createMenuMap("account", AccountCategory.values()));
        list.add(this.createMenuMap("community", CommunityCategory.values()));
        list.add(this.createMenuMap("inquiry", InquiryCategory.values()));
        return list;
    }

    @GetMapping
    public String myPage(Model model) {
        model.addAttribute("accountMenus", AccountCategory.values());
        return "myPage/myPage";
    }


}
