package teamproject.lam_simple.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import teamproject.lam_simple.constants.CategoryConstants.CityNames;
import teamproject.lam_simple.service.CityService;

@Controller
@RequiredArgsConstructor
@RequestMapping("/city")
public class CityController {
    private final CityService cityService;

    @GetMapping
    public String city(@RequestParam CityNames menu, Model model) {
        model.addAttribute("menu", menu);
        model.addAttribute("cities", CityNames.values());
        model.addAttribute("cityInfos", cityService.findCityInfoByName(menu));
        return "/cityView/city";
    }


}
