package com.bitc.springteamproject1209.controller;

import com.bitc.springteamproject1209.dto.TestDto;
import com.bitc.springteamproject1209.service.TestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
public class TestController {

  @Autowired
  private TestService testService; //이걸 넣으니 문제 해결됨

  @RequestMapping(value = "/")
  public String index() throws Exception {

    return "index";

  }

  @RequestMapping(value = "/myPage")
  public String myPage() throws Exception {

    return "myPage";
  }

  @RequestMapping(value = "/index", method = RequestMethod.GET) //받아주는 방식
  public ModelAndView openBoardList() throws Exception {
    ModelAndView mv = new ModelAndView("index");

    List<TestDto> testList = testService.testList(); // 서비스로 간다
    mv.addObject("testList",testList);
//        사용자가 있고 사용자가 요청을 하게 되면 컨트롤러가 받아 서비스로 넘기고 서비스에서 처리할 것 처리하고 메퍼로 넘긴다.
//        ORM(우리는 mybtis사용중)은 db로 연결된다. db-> orm -> service(처리) -> 컨트롤러 -> view(html) -> 사용자

    return mv;
  }
}
