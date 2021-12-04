package teamproject.lam_simple.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.multipart.MultipartFile;
import teamproject.lam_simple.constants.CategoryConstants.AccountCategory;
import teamproject.lam_simple.constants.CategoryConstants.CommunityCategory;
import teamproject.lam_simple.constants.CategoryConstants.InquiryCategory;
import teamproject.lam_simple.constants.SessionConstants;
import teamproject.lam_simple.domain.User;
import teamproject.lam_simple.service.LoginService;
import teamproject.lam_simple.service.UserService;
import teamproject.lam_simple.uploader.S3Uploader;

import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import static teamproject.lam_simple.constants.SessionConstants.*;
import static teamproject.lam_simple.constants.SessionConstants.PROFILE_IMAGE_DIR;

@Controller
@RequiredArgsConstructor
@Slf4j
public class MyPageController extends ContentsController {

    private final UserService userService;
    private final LoginService loginService;
    private final S3Uploader s3Uploader;

    @ModelAttribute("sideBarMenus")
    public List<Map<String, Object>> sideBarMenus() {
        List<Map<String, Object>> list = new ArrayList<>();
        list.add(this.createMenuMap("account", AccountCategory.values()));
        list.add(this.createMenuMap("community", CommunityCategory.values()));
        list.add(this.createMenuMap("inquiry", InquiryCategory.values()));
        return list;
    }

    @GetMapping("/myPage")
    public String myPage(Model model) {
        model.addAttribute("accountMenus", AccountCategory.values());
        return "myPage/myPage";
    }

    @PostMapping("/editProfileImage")
    public String editProfileImage(HttpSession session, @RequestPart("fileName") MultipartFile mFile) throws Exception {
        log.info("들어온 파일 ={}",mFile.getBytes().length);
        log.info("들어온 파일 ={}",mFile.getName());
        log.info("들어온 파일 ={}",mFile.getOriginalFilename());
        log.info("들어온 파일 ={}",mFile.getContentType());
        log.info("들어온 파일 ={}",mFile.getInputStream());
        log.info("들어온 파일 ={}",mFile.getResource());
        User user = (User) session.getAttribute(LOGIN_USER);
        if(user.getImage() != null) s3Uploader.delete("/"+PROFILE_IMAGE_DIR+user.getImage());
        String saveName = s3Uploader.uploadProfile(user.getLoginId(), PROFILE_IMAGE_DIR, mFile.getOriginalFilename(), mFile.getBytes());
        log.info("변환된 파일 ={}",saveName);
        userService.editUserImage(user.getId(), saveName);

        log.info("변경 후 객체에 있는 이미지={}",user.getProfileImgPath());
//      새로운 객체로 세션 생성
        session.setAttribute(LOGIN_USER, userService.find(user.getId()));
        return "redirect:/myPage";
    }


}
