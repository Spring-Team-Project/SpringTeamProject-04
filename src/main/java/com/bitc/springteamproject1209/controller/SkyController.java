package com.bitc.springteamproject1209.controller;

import com.bitc.springteamproject1209.dto.MemberDto;
import com.bitc.springteamproject1209.dto.ReviewDto;
import com.bitc.springteamproject1209.service.SkyMemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.List;


@Controller
@SessionAttributes("login")
public class SkyController {

    @RequestMapping(value = "/main")
    public String main() {
        return "main";
    }

    @Autowired
    private SkyMemberService memberService;

    @RequestMapping("/login.do")
    public String login() {
        return "GwakLogin";
    }
    @RequestMapping("/signUp.do")
    public String signUp() {
        return "SignUp";
    }
    @RequestMapping("/test")
    public String test(){
        return "SkyPharmacyDetail";
    }
    @RequestMapping("/review")
    public String review(){
        return "SkyMyReviewPage";
    }
    @RequestMapping("/detail.do")
    public String detail(){
        return "SkyMyReviewPageDetail";
    }
//    로그인 처리
//    @RequestMapping(value = "/loginCheck.do")
//    public ModelAndView loginCheck(@ModelAttribute MemberDto md, HttpSession session) {
//
//        boolean result = memberService.loginCheck(md, session);
//        ModelAndView mav = new ModelAndView();
//
//        mav.setViewName("login");
//
//        if (result) {
//            mav.addObject("msg", "성공");
//        } else {
//            mav.addObject("msg", "실패");
//        }
//
//        return mav;
//    }
//
//    //로그아웃 처리
//    @RequestMapping("logout.do")
//    public ModelAndView logout(HttpSession session) {
//
//        memberService.logout(session);
//        ModelAndView mav = new ModelAndView();
//        mav.setViewName("login");
//        mav.addObject("msg", "logout");
//
//        return mav;
//    }

    //  리뷰 가져오기
//    @PostMapping("/myReviewList")
//    @ResponseBody
//    public Object getmyReviewList(@RequestParam("reId") String reId, HttpServletRequest request){
//
//        HttpSession session = request.getSession();
//
//        List<ReviewDto> reviewList = memberService.selectMyReviewList(reId);
//
//        if (session.getAttribute("reviews") != null){
//            session.removeAttribute("reviews");
//        }
//        session.setAttribute("reviews", reviewList);
//
//        if (reviewList == null) {
//            return 0;
//        } else {
//            return reviewList;
//        }
//    }


}
