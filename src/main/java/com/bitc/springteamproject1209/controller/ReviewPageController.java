package com.bitc.springteamproject1209.controller;

import com.bitc.springteamproject1209.dto.ReviewDto;
import com.bitc.springteamproject1209.dto.TestDto;
import com.bitc.springteamproject1209.service.TestService;
import com.bitc.springteamproject1209.service.ReviewBoardService;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
public class ReviewPageController {

  @Autowired
  private ReviewBoardService reviewBoardService; //이걸 넣으니 문제 해결됨
  private TestService testService;

  @RequestMapping(value = "/")
  public String index() throws Exception {

    return "index";

  }

  @RequestMapping(value = "/myPage")
  public String myPage() throws Exception {

    return "myPage";
  }

//  삭제예정 ) 내가 쓴 리뷰 페이지
  @RequestMapping(value = "/myReviewPage")
  public String myReviewPage() throws Exception {

    return "myReviewPage";
  }


//  삭제예정 ) 내 정보 수정 페이지
  @RequestMapping(value = "/myInfoEditPage")
  public String myInfoEditPage() throws Exception {

    return "myInfoEditPage";
  }

  @RequestMapping(value = "/storePage")
  public String storePage() throws Exception {

    return "storePage";
  }



  @RequestMapping(value = "/reviewBoardPage", method = RequestMethod.GET)
  public ModelAndView openReviewList(@RequestParam(required = false, defaultValue = "1") int pageNum) throws Exception {
    // html 파일이 있는 위치(resources-templates 는 스프링에서 고정이기 때문에 그 아래의 폴더만 써주면 됨)
    ModelAndView mv = new ModelAndView("reviewBoardPage");

    // 필요한 데이터 객체 실어주기
    // 실제 데이터베이스에서 넘어온 데이터를 BoardDto 타입으로 만들어진 dataList에 저장
    // List<BoardDto> dataList = boardService.selectBoardList();
    // 실제 데이터를 addObject를 통해 밀어넣음(이름은 datatList 로(html에서 구별하기 위한 구분자), 실제 변수명은 dataList)
    // mv.addObject("dataList", dataList);

//    List<ReviewDto> reviewBoardList = ReviewBoardService.selectReviewList();
    PageInfo<ReviewDto> reviewBoardList = new PageInfo<>(reviewBoardService.selectReviewList(pageNum), 3);
    mv.addObject("reviewBoardList", reviewBoardList);

    return mv; // html 파일의 데이터가 들어가면서 그것을 클라이언트에 보낸다 -> 웹 브라우저로 다시 뿌림
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
