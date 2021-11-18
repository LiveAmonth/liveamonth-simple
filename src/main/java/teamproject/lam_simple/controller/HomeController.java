package teamproject.lam_simple.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import teamproject.lam_simple.domain.CityInfo;
import teamproject.lam_simple.service.CityService;

import java.util.List;

@Controller
@RequiredArgsConstructor
@Slf4j
public class HomeController {
    private final CityService cityService;

    @GetMapping("/")
    public String home(Model model) {
        // 도시 슬라이드 정보
        List<CityInfo> intro = cityService.getRandomCityInfo("INTRO");
        for (CityInfo cityInfo : intro) {
            System.out.println(cityInfo.getCityInfoImage());
            System.out.println(cityInfo.getCity().getCityName());
        }
        model.addAttribute("cityInfos", intro);
        // 회원 정보
        // 도시 그리드 정보
        // 인기 스케줄, 게시판 정보

        return "mainView/home";
    }


}
