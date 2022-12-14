//package com.bitc.springteamproject1209.controller;
//
//import com.bitc.springteamproject1209.dto.MemberDto;
//import com.bitc.springteamproject1209.service.GwakMemberService;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Controller;
//import org.springframework.web.bind.annotation.PostMapping;
//
//import javax.servlet.http.HttpSession;
//
//@Controller
//public class GwakMemberController {
//
//
////  @Autowired
////  private GwakMemberService gwakMemberService;
//
//
////  // 회원 로그인
////  @PostMapping("/Login")
////  public String Login(MemberDto memberDto, HttpSession session) {
////
////    MemberDto Login = gwakMemberService.Login(memberDto);
////
////    if(Login!=null) {
////      session.setAttribute("LoginDto", Login);
////    }
////
////    return "redirect:/main";
////  }
//
//
//
//}