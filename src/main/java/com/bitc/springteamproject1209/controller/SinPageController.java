package com.bitc.springteamproject1209.controller;

import com.bitc.springteamproject1209.dto.SinJsonDto;
import com.bitc.springteamproject1209.dto.SinRegistDto;
import com.bitc.springteamproject1209.dto.SinSidoCode;
import com.bitc.springteamproject1209.service.SinWdbService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.net.URI;
import java.util.ArrayList;
import java.util.List;


@RestController
@RequestMapping("/wdb")
public class SinPageController {

    @Autowired
    private SinWdbService sinWdbService;




    // 임시 메인화면
    @GetMapping("/main")
    public ModelAndView mainView() throws Exception{

        ModelAndView mv = new ModelAndView("/main");

        return mv;
    }


    //  보건소 목록 뷰
    @GetMapping("/hclist")
    public ModelAndView HCList(@RequestParam("userSearchWord")String userSearchWord) throws Exception{

            ModelAndView mv = new ModelAndView("/wdb/HCList");

        if (userSearchWord == null){

            List<SinJsonDto> HCList = sinWdbService.HCList();

            mv.addObject("HCList",HCList);

            return mv;
        }


////        검색 기능 구현
//        if (userSearchWord != null){
//
//            List<SinJsonDto> filterHcList = sinWdbService.filterHcList(userSearchWord);
//        }


        return mv;
    }




    //  회원가입 뷰
    @GetMapping("/user/signup")
    public ModelAndView userSignUp() throws Exception {

        ModelAndView mv = new ModelAndView("wdb/SignUp");

        return mv;
    }

    //    id 중복 체크
    @ResponseBody
    @GetMapping("/user/idcheck")
    public int overlappedID(@RequestParam("checkId") String userId ) throws Exception{


        int idCheck = sinWdbService.overlappedID(userId);

        return idCheck;
    }

    //    email 중복 체크
    @ResponseBody
    @GetMapping("/user/emailcheck")
    public int overlappedEmail(@RequestParam("checkEmail")String userEmail ) throws Exception{


        int emailCheck = sinWdbService.overlappedEmail(userEmail);

        return emailCheck;
    }




    @PostMapping("/user/signup/success")
    // 예외처리 성공시 회원가입 db 등록
    public ResponseEntity<?> insertUser(SinRegistDto sinRegistDto) throws Exception {

        HttpHeaders headers = new HttpHeaders();



        try {
            sinWdbService.insertUser(sinRegistDto);
            System.out.println("데이터 입력 성공");
        } catch (Exception e){
            e.printStackTrace();
            System.out.println("데이터 입력 실패");
        }

        headers.setLocation(URI.create("/wdb/main"));


        return new ResponseEntity<>(headers, HttpStatus.MOVED_PERMANENTLY);
    }




    //  select thymeleaf 방식
    @ModelAttribute("SinSidoCode")
    public List<SinSidoCode> sinSidoCodes(){

        List<SinSidoCode> sinSidoCodes = new ArrayList<>();
        sinSidoCodes.add(new SinSidoCode("02","서울"));
        sinSidoCodes.add(new SinSidoCode("032","인천"));
        sinSidoCodes.add(new SinSidoCode("042","대전"));
        sinSidoCodes.add(new SinSidoCode("051","부산"));
        sinSidoCodes.add(new SinSidoCode("052","울산"));
        sinSidoCodes.add(new SinSidoCode("053","대구"));
        sinSidoCodes.add(new SinSidoCode("062","광주"));
        sinSidoCodes.add(new SinSidoCode("064","제주"));
        sinSidoCodes.add(new SinSidoCode("031","경기"));
        sinSidoCodes.add(new SinSidoCode("033","강원"));
        sinSidoCodes.add(new SinSidoCode("041","충남"));
        sinSidoCodes.add(new SinSidoCode("043","충북"));
        sinSidoCodes.add(new SinSidoCode("054","경북"));
        sinSidoCodes.add(new SinSidoCode("055","경남"));
        sinSidoCodes.add(new SinSidoCode("061","전남"));
        sinSidoCodes.add(new SinSidoCode("063","전북"));

        return sinSidoCodes;

    }

















//  테스팅 페이지
//    @GetMapping("/testpage")
//    public ModelAndView testView() throws Exception{
//
//        ModelAndView mv = new ModelAndView("/main");
//
//        return mv;
//    }


}
