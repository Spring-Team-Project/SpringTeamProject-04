package com.bitc.springteamproject1209.controller;

import com.bitc.springteamproject1209.dto.GwakRegistDto;
import com.bitc.springteamproject1209.dto.MemberDto;
import com.bitc.springteamproject1209.dto.ReviewDto;
import com.bitc.springteamproject1209.dto.SinRegistDto;
import com.bitc.springteamproject1209.service.GwakReviewBoardService;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.websocket.SessionException;

@Controller
public class GwakReviewPageController {

  @Autowired
  private GwakReviewBoardService gwakReviewBoardService; //이걸 넣으니 문제 해결됨


  @RequestMapping(value = "/mainPage")
  public String mainPage() throws Exception {

    return "main";
  }

  @RequestMapping(value = "/myPage")
  public String myPage() throws Exception {

    return "GwakMyPage";
  }


  //  삭제예정 ) 내가 쓴 리뷰 페이지
  @RequestMapping(value = "/myReviewPage")
  public String myReviewPage() throws Exception {

    return "GwakMyReviewPage";
  }


  //  삭제예정 ) 내 정보 수정 페이지
  @RequestMapping(value = "/myInfoEditPage")
  public String myInfoEditPage() throws Exception {

    return "GwakMyInfoEditPage";
  }

  @RequestMapping(value = "/GwakStorePage")
  public String storePage() throws Exception {

    return "GwakStorePage";
  }

  @RequestMapping(value = "/GwakReviewBoardPage", method = RequestMethod.GET)
  public ModelAndView openReviewList(@RequestParam(required = false, defaultValue = "1") int pageNum) throws Exception {
    // html 파일이 있는 위치(resources-templates 는 스프링에서 고정이기 때문에 그 아래의 폴더만 써주면 됨)
    ModelAndView mv = new ModelAndView("GwakReviewBoardPage");

    PageInfo<ReviewDto> reviewBoardList = new PageInfo<>(gwakReviewBoardService.selectReviewList(pageNum), 3);
    mv.addObject("reviewBoardList", reviewBoardList);

    return mv; // html 파일의 데이터가 들어가면서 그것을 클라이언트에 보낸다 -> 웹 브라우저로 다시 뿌림
  }


  @RequestMapping(value = "/GwakLogin")
  public String GwakLogin() throws Exception {

    return "GwakLogin";
  }

  @PostMapping("/loginIdCheck")
  @ResponseBody
  public Object loginIdCheck(@RequestParam("memId") String memId, @RequestParam("memPwd") String memPwd, HttpServletRequest request) {
    HttpSession session = request.getSession();
    MemberDto memberDto = gwakReviewBoardService.idCheckSQL(memId, memPwd);


//    세션이 존재하면 없앰
    if (session.getAttribute("member") != null) {
      session.removeAttribute("member");
    }

    session.setAttribute("member", memberDto);

    if (memberDto == null) {
      return 0;
    } else {
      return memberDto;
    }
  }



}
