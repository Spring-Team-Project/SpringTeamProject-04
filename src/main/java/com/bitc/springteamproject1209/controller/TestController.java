package com.bitc.springteamproject1209.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class TestController {

  @RequestMapping("/")
  public String index() throws Exception {
    return "LysIndex";
  }

}
