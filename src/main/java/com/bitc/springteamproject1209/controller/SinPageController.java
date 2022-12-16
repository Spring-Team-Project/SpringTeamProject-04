package com.bitc.springteamproject1209.controller;

import com.bitc.springteamproject1209.dto.SinJsonDto;
import com.bitc.springteamproject1209.dto.SinRegistDto;
import com.bitc.springteamproject1209.dto.SinTelCode;
import com.bitc.springteamproject1209.service.SinWdbService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
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
    public ModelAndView mainView() throws Exception {

        ModelAndView mv = new ModelAndView("/main");

        return mv;
    }


    //  보건소 목록 전체 뷰
    @GetMapping("/hclist")
    public ModelAndView HCView()throws Exception{
        ModelAndView mv = new ModelAndView("wdb/HCList");

        List<SinJsonDto> HCList = sinWdbService.HCMainList();

        mv.addObject("HCList", HCList);

        return mv;
    }



    //  보건소 데이터
    @ResponseBody
    @GetMapping("/hclist/filter")
    public List<SinJsonDto> HCList(@RequestParam(value = "userSearchWord", required = false) String userSearchWord, @RequestParam(value = "telCode", required = false) String telCode) throws Exception {


            List<SinJsonDto> HCList = sinWdbService.HCList(userSearchWord,telCode);



        return HCList;
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
    public int overlappedID(@RequestParam("checkId") String userId) throws Exception {


        int idCheck = sinWdbService.overlappedID(userId);

        return idCheck;
    }

    //    email 중복 체크
    @ResponseBody
    @GetMapping("/user/emailcheck")
    public int overlappedEmail(@RequestParam("checkEmail") String userEmail) throws Exception {


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
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("데이터 입력 실패");
        }

        headers.setLocation(URI.create("/wdb/main"));


        return new ResponseEntity<>(headers, HttpStatus.MOVED_PERMANENTLY);
    }


    //  select box 채우기 thymeleaf 방식
    @ModelAttribute("SinTelCode")
    public List<SinTelCode> sinSidoCodes() {

        List<SinTelCode> sinTelCodes = new ArrayList<>();
        sinTelCodes.add(new SinTelCode("02", "서울"));
        sinTelCodes.add(new SinTelCode("032", "인천"));
        sinTelCodes.add(new SinTelCode("042", "대전"));
        sinTelCodes.add(new SinTelCode("051", "부산"));
        sinTelCodes.add(new SinTelCode("052", "울산"));
        sinTelCodes.add(new SinTelCode("053", "대구"));
        sinTelCodes.add(new SinTelCode("062", "광주"));
        sinTelCodes.add(new SinTelCode("064", "제주"));
        sinTelCodes.add(new SinTelCode("031", "경기"));
        sinTelCodes.add(new SinTelCode("033", "강원"));
        sinTelCodes.add(new SinTelCode("041", "충남"));
        sinTelCodes.add(new SinTelCode("043", "충북"));
        sinTelCodes.add(new SinTelCode("054", "경북"));
        sinTelCodes.add(new SinTelCode("055", "경남"));
        sinTelCodes.add(new SinTelCode("061", "전남"));
        sinTelCodes.add(new SinTelCode("063", "전북"));

        return sinTelCodes;

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