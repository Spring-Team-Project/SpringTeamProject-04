package com.bitc.springteamproject1209.controller;

import com.bitc.springteamproject1209.dto.MemberDto;
import com.bitc.springteamproject1209.dto.ReviewDto;
import com.bitc.springteamproject1209.service.SkyMemberService;
import com.google.gson.Gson;
import lombok.Getter;
import org.mybatis.logging.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.net.URI;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.logging.Logger;


@Controller
@SessionAttributes("login")
public class SkyController {


    private Logger logger;

    @RequestMapping(value = "/main")
    public String main() {

        return "main";
    }

    //    @RequestMapping("/login.do")
//    public String login() throws Exception {
//        return "GwakLogin";
//    }
    @RequestMapping("/signUp.do")
    public String signUp() {
        return "SinSignUp";
    }

    @RequestMapping("/test")
    public String test() {
        return "SkyPharmacyDetail";
    }

    @RequestMapping("/GwakReviewBoardPage")
    public String review() {
        return "GwakReviewBoardPage";
    }

    @RequestMapping("/detail.do")
    public String detail() {
        return "SkyMyReviewPageDetail";
    }

    //    로그아웃 시 세션 종료 컨트롤
    @RequestMapping(value = "/logout.do")
    public String logoutMainGET(HttpServletRequest request) throws Exception {

//        logger.info("logoutMainGET메서드 진입");

        HttpSession session = request.getSession();

        session.invalidate();

        return "/main";

    }

    @Autowired
    private SkyMemberService memberService;


    //      리뷰 가져오기
    @PostMapping("/SkyMyReviewPage")
    @ResponseBody
    public Object getmyReviewList(@RequestParam("reId") String reId, HttpServletRequest request) {

        HttpSession session = request.getSession();

        List<ReviewDto> reviewList = memberService.selectMyReviewList(reId);

        if (session.getAttribute("reviews") != null) {
            session.removeAttribute("reviews");
        }
        session.setAttribute("reviews", reviewList);

        if (reviewList == null) {
            return 0;
        } else {
            return reviewList;
        }
    }

    @RequestMapping("/SkyMyReviewPage")
    public String GwakMyReviewPage() {

        return "/SkyMyReviewPage";
    }

    @ResponseBody
    @GetMapping(value = "review/update")
    public void update(ReviewDto rvdto) throws Exception {

        memberService.updateR(rvdto);

    }

    ;


    @ResponseBody
    @GetMapping(value = "review/delete")
    public void delete(ReviewDto rvdto1) throws Exception {

        memberService.deleteR(rvdto1);
    };




};
