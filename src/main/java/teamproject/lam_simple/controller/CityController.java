package teamproject.lam_simple.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import teamproject.lam_simple.constants.AttrConstants;
import teamproject.lam_simple.constants.CategoryConstants.CityNames;
import teamproject.lam_simple.service.CityService;

import static teamproject.lam_simple.constants.PathConstants.CITY;
import static teamproject.lam_simple.constants.PathConstants.CITY_DIR;

@Controller
@RequiredArgsConstructor
@RequestMapping("/city")
public class CityController extends MainController {
    private final CityService cityService;

    @GetMapping
    public String city(@RequestParam CityNames menu, Model model) {
        model.addAttribute(AttrConstants.MENU, menu);
        model.addAttribute(AttrConstants.CITIES, CityNames.values());
        model.addAttribute(AttrConstants.CITY_INFOS, cityService.findCityInfoByName(menu));

        return CITY_DIR+CITY;
    }


}
