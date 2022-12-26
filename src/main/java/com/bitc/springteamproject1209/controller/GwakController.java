package com.bitc.springteamproject1209.controller;

import com.bitc.springteamproject1209.dto.LeePharmacyFullDataItemDto;
import com.bitc.springteamproject1209.dto.MemberDto;
import com.bitc.springteamproject1209.dto.ReviewDto;
import com.bitc.springteamproject1209.service.GwakService;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.List;

@Controller
public class GwakController {

  @Autowired
  private GwakService gwakService; //이걸 넣으니 문제 해결됨


  @RequestMapping(value = "/mainPage")
  public String mainPage() throws Exception {

    return "main";
  }

  @RequestMapping(value = "/mapData", method = RequestMethod.GET)
  @ResponseBody
  public List<LeePharmacyFullDataItemDto> mapData(@RequestParam("dong") String dong) throws Exception {
    List<LeePharmacyFullDataItemDto> mapData = gwakService.getMapData(dong);
    return mapData;
  }

  @RequestMapping(value = "/detail")
  public String detail() throws Exception {

    return "GwakDetailPage";
  }

  @RequestMapping(value = "/index4")
  public String index4() throws Exception {

    return "index4";
  }

  @RequestMapping(value = "/mainTest")
  public String mainTest() throws Exception {

    return "mainTest";
  }

  @RequestMapping(value = "/myPage", method = RequestMethod.GET)
  public String myPage() throws Exception {

    return "GwakMyPage";
  }


  //  삭제예정 ) 내가 쓴 리뷰 페이지
//  @RequestMapping(value = "/myReviewPage")
//  public String myReviewPage() throws Exception {
//
//    return "GwakMyReviewPage";
//  }


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

    PageInfo<ReviewDto> reviewBoardList = new PageInfo<>(gwakService.selectReviewList(pageNum), 5);
    mv.addObject("reviewBoardList", reviewBoardList);

    return mv; // html 파일의 데이터가 들어가면서 그것을 클라이언트에 보낸다 -> 웹 브라우저로 다시 뿌림
  }


  @RequestMapping(value = "/GwakLogin")
  public String GwakLogin() throws Exception {

    return "GwakLogin";
  }

//  @RequestMapping(value = "/GwakMyReviewPage")
//  public String GwakMyReviewPage() throws Exception {
//
//    return "GwakMyReviewPage";
//  }

  @PostMapping("/loginIdCheck")
  @ResponseBody
  public Object loginIdCheck(@RequestParam("memId") String memId, @RequestParam("memPwd") String memPwd, HttpServletRequest request) throws Exception {
    HttpSession session = request.getSession();
    MemberDto memberDto = gwakService.idCheckSQL(memId, memPwd);

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

  @PostMapping("/test")
  @ResponseBody
  public HashMap<String, String> test(@RequestParam("memId") String memId) throws Exception {
    HashMap<String, String> data = new HashMap<>();

    try {
      int reviewCount = gwakService.rvQtySQL(memId);
      String rvQty = String.valueOf(reviewCount);

      data.put("memId", memId);
      data.put("rvQty", rvQty);

    }catch (Exception e){
      e.printStackTrace();
    }

    return data;
  }

//  리뷰모음 게시판 - 수정버튼 클릭시

  @GetMapping(value = "review/delete/{reIdx}") // 삭제는 DELETE
  public String deleteBoard(@PathVariable("reIdx") int reIdx) throws Exception {
//        System.out.println("--------------------------------------");
//        System.out.println("deleteBoard : " + idx);
    gwakService.deleteBoard(reIdx);

    return "GwakMyPage";
  }


//  @RequestMapping(value = "/myReviewList/{reId}", method = RequestMethod.GET)
//  public ModelAndView getmyReviewList(@PathVariable("reId") String reId) throws Exception {
//    ModelAndView mv = new ModelAndView("GwakMyReviewPage");
//    List<ReviewDto> myReviewList = gwakService.selectMyReviewList(reId); // 서비스로 간
//    mv.addObject("myReviewList",myReviewList);
//
//    return mv;
//  }



  @RequestMapping("/GwakMyReviewPage")
  public String GwakMyReviewPage() {

    return "GwakMyReviewPage";
  }

  @RequestMapping("/index2")
  public String index2() {

    return "index2";
  }

  @RequestMapping("/index3")
  public String index3() {

    return "index3";
  }

//  검색 기능
@RequestMapping(value = "/search", method = RequestMethod.POST)
public ModelAndView searchList(@RequestParam(required = false, defaultValue = "1") int pageNum, @RequestParam("searchText") String searchText) throws Exception {
  // html 파일이 있는 위치(resources-templates 는 스프링에서 고정이기 때문에 그 아래의 폴더만 써주면 됨)
  ModelAndView mv = new ModelAndView("GwakReviewBoardPage");

  PageInfo<ReviewDto> reviewBoardList = new PageInfo<>(gwakService.selectReviewList2(pageNum, searchText), 5);
  mv.addObject("reviewBoardList", reviewBoardList);

  return mv; // html 파일의 데이터가 들어가면서 그것을 클라이언트에 보낸다 -> 웹 브라우저로 다시 뿌림
}


}