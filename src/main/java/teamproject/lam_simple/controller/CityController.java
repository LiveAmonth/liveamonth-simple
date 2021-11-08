package teamproject.lam_simple.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ResponseBody;
import teamproject.lam_simple.service.CityService;

@Controller
@RequiredArgsConstructor
@ResponseBody
public class CityController {
    private final CityService cityService;

}
