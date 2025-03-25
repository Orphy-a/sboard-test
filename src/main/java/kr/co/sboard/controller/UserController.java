package kr.co.sboard.controller;

import kr.co.sboard.config.AppInfo;
import kr.co.sboard.dto.TermsDTO;
import kr.co.sboard.entity.User;
import kr.co.sboard.service.TermsService;
import kr.co.sboard.service.UserService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Controller
@RequiredArgsConstructor
@Slf4j
public class UserController {

    private final TermsService termsService;
    private final UserService userService;

    private final AppInfo appInfo;

    @GetMapping("/user/info")
    public String info(){
        return "/user/info";
    }

    @GetMapping("/user/login")
    public String login(){



        return "/user/login";
    }

    @GetMapping("/user/register")
    public String register(){



        return "/user/register";
    }

    @GetMapping("/user/terms")
    public String terms(Model model){

        TermsDTO termsDTO = termsService.terms();

        model.addAttribute("termsDTO", termsDTO);

        return "/user/terms";
    }

    @GetMapping("/user/{type}/{value}")
    public void user(@PathVariable("type") String type, @PathVariable("value") String value){

        userService.checkUser()

    }

}
