package com.bitc.springteamproject1209.controller;

import com.bitc.springteamproject1209.dto.ReviewDto;
import com.bitc.springteamproject1209.service.GwakReviewBoardService;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class GwakReviewPageController {

  @Autowired
  private GwakReviewBoardService gwakReviewBoardService; //이걸 넣으니 문제 해결됨

  @RequestMapping(value = "/")
  public String index() throws Exception {

    return "main";

  }

  @RequestMapping(value = "/myPage")
  public String myPage() throws Exception {

    return "GwakMyPage";
  }

//  삭제예정 ) 내가 쓴 리뷰 페이지
  @RequestMapping(value = "/myReviewPage")
  public String myReviewPage() throws Exception {

    return "GwakmyReviewPage";
  }


//  삭제예정 ) 내 정보 수정 페이지
  @RequestMapping(value = "/myInfoEditPage")
  public String myInfoEditPage() throws Exception {

    return "GwakMyInfoEditPage";
  }

  @RequestMapping(value = "/storePage")
  public String storePage() throws Exception {

    return "GwakStorePage";
  }



  @RequestMapping(value = "/reviewBoardPage", method = RequestMethod.GET)
  public ModelAndView openReviewList(@RequestParam(required = false, defaultValue = "1") int pageNum) throws Exception {
    // html 파일이 있는 위치(resources-templates 는 스프링에서 고정이기 때문에 그 아래의 폴더만 써주면 됨)
    ModelAndView mv = new ModelAndView("GwakReviewBoardPage");

    // 필요한 데이터 객체 실어주기
    // 실제 데이터베이스에서 넘어온 데이터를 BoardDto 타입으로 만들어진 dataList에 저장
    // List<BoardDto> dataList = boardService.selectBoardList();
    // 실제 데이터를 addObject를 통해 밀어넣음(이름은 datatList 로(html에서 구별하기 위한 구분자), 실제 변수명은 dataList)
    // mv.addObject("dataList", dataList);

//    List<ReviewDto> reviewBoardList = ReviewBoardService.selectReviewList();
    PageInfo<ReviewDto> reviewBoardList = new PageInfo<>(gwakReviewBoardService.selectReviewList(pageNum), 3);
    mv.addObject("reviewBoardList", reviewBoardList);

    return mv; // html 파일의 데이터가 들어가면서 그것을 클라이언트에 보낸다 -> 웹 브라우저로 다시 뿌림
  }






}
