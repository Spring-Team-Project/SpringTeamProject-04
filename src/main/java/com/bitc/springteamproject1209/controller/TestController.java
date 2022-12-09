package com.bitc.springteamproject1209.controller;

import com.bitc.springteamproject1209.dto.TestDto;
import com.bitc.springteamproject1209.service.TestService;
import com.bitc.springteamproject1209.service.TestServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
public class TestController {

  @Autowired
  private TestService testService;

  @RequestMapping("/")
  public String index() throws Exception {
    return "index";
  }


  @RequestMapping("/testdb")
  public ModelAndView openDB() throws Exception{
    ModelAndView mv = new ModelAndView("testdb");

    List<TestDto> testDtoList = testService.selectDBdto();
    mv.addObject("testDtoList",testDtoList);

    return mv;
  }

}
