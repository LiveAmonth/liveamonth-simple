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

        model.addAttribute("cityInfos", cityService.findCityInfoByCategory("INTRO"));
        // 회원 정보
        // 도시 그리드 정보
        model.addAttribute("cityWeathers", cityService.getAVGTempList());
        model.addAttribute("cityTransports", cityService.getCityTransportGradeList());
        // 인기 스케줄, 게시판 정보

        return "mainView/home";
    }

}
