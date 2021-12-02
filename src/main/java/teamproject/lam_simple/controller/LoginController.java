package teamproject.lam_simple.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import teamproject.lam_simple.constants.CategoryConstants;
import teamproject.lam_simple.constants.SessionConstants;
import teamproject.lam_simple.domain.User;
import teamproject.lam_simple.dto.FindIdForm;
import teamproject.lam_simple.dto.LoginForm;
import teamproject.lam_simple.service.LoginService;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;

@Controller
@RequiredArgsConstructor
@Slf4j
public class LoginController {
    private final LoginService loginService;

    @ModelAttribute("emailDomains")
    public CategoryConstants.EmailDomains[] emailDomains(){return CategoryConstants.EmailDomains.values();}

    @GetMapping("/login")
    public String login(@ModelAttribute("form") LoginForm form) {
        return "login/loginForm";
    }

    @PostMapping("/login")
    public String login(@Valid @ModelAttribute LoginForm form, BindingResult bindingResult,
                        @RequestParam(defaultValue = "/")String redirectURL,
                        HttpServletRequest request) {
        if (bindingResult.hasErrors()) return "login/loginForm";

        User loginUser = loginService.login(form.getLoginId(), form.getPassword());

        if (loginUser == null) {
            bindingResult.reject("loginFail", "아이디 또는 비밀번호가 맞지 않습니다.");
            return "login/loginForm";
        }


        // 로그인 성공 처리
        // 세션이 있으면 있는 세션 반환, 없으면 신규 세션을 생성
        HttpSession session = request.getSession();
        // 세션에 로그인 회원 정보 보관
        session.setAttribute(SessionConstants.LOGIN_USER, loginUser);
        return "redirect:" + redirectURL;
    }

    @GetMapping("/findId")
    public String findId(@ModelAttribute("form") FindIdForm form) {
        return "login/findIdForm";
    }

    @PostMapping("/findId")
    public String findId(@Valid @ModelAttribute FindIdForm form, BindingResult bindingResult,
                         RedirectAttributes redirectAttributes,
                        Model model) {
        if (bindingResult.hasErrors()) return "login/findIdForm";

        User foudUser = loginService.findId(form.getName(), form.unifyEmail());
        String foundLoginId = foudUser.getLoginId();

        log.info("검색된 계정 ={}",foudUser);
        log.info("검색된 아이디 ={}",foudUser.getLoginId());
        if (foudUser == null) {
            bindingResult.reject("NoData", "해당 정보와 일치하는 회원이 없습니다.");
            return "login/findIdForm";
        }

        redirectAttributes.addAttribute("foundLoginId", foundLoginId);
        return "redirect:/findIdResult";
    }
    @GetMapping("/findIdResult")
    public String findIdResult(@ModelAttribute("foundLoginId") String foundLoginId){
        return "login/findIdResult";
    }
    @PostMapping("/logout")
    public String logout(HttpServletRequest request) {
        HttpSession session = request.getSession(false);
        if(session!=null) session.invalidate();
        return "redirect:/";
    }
}
