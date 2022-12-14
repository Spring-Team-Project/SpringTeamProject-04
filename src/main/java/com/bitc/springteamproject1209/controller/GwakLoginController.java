package com.bitc.springteamproject1209.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class GwakLoginController {

  @RequestMapping("/login")
  public String login() throws Exception{
    return "GwakLogin";
  }

  @RequestMapping(value = "loginProcess", method = RequestMethod.POST)
  public <MemberDto> String loginProcess(MemberDto member) throws Exception {

    return null;

  }
}
