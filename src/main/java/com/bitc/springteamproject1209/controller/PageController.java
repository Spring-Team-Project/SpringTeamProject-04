package com.bitc.springteamproject1209.controller;

import com.bitc.springteamproject1209.dto.JsonDto;
import com.bitc.springteamproject1209.dto.RegistDto;
import com.bitc.springteamproject1209.service.WdbService;
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
public class PageController {

    @Autowired
    private WdbService wdbService;




    // 임시 메인화면
    @GetMapping("/main")
    public ModelAndView mainView() throws Exception{

        ModelAndView mv = new ModelAndView("wdb/Main(Temporary)");

        return mv;
    }



    @GetMapping("/testpage")
    public ModelAndView testView() throws Exception{

        ModelAndView mv = new ModelAndView("wdb/signup2");

        return mv;
    }

    // 회원가입 뷰
    @GetMapping("/user/signup")
    public ModelAndView userSignUp() throws Exception {

        ModelAndView mv = new ModelAndView("wdb/SignUp");

        return mv;
    }

    //    id 중복 체크
    @ResponseBody
    @GetMapping("/user/idcheck")
    public int overlappedID(RegistDto registDto) throws Exception{


        int idCheck = wdbService.overlappedID(registDto);

        return idCheck;
    }

    //    email 중복 체크
    @ResponseBody
    @GetMapping("/user/emailcheck")
    public int overlappedEmail(RegistDto registDto) throws Exception{


        int emailCheck = wdbService.overlappedEmail(registDto);

        return emailCheck;
    }




    @PostMapping("/user/signup/success")
    // 예외처리 성공시 회원가입 db 등록
    public ResponseEntity<?> insertUser(RegistDto registDto) throws Exception {

        HttpHeaders headers = new HttpHeaders();



        try {
            wdbService.insertUser(registDto);
            System.out.println("데이터 입력 성공");
        } catch (Exception e){
            e.printStackTrace();
            System.out.println("데이터 입력 실패");
        }

        headers.setLocation(URI.create("/wdb/main"));


        return new ResponseEntity<>(headers, HttpStatus.MOVED_PERMANENTLY);
    }




    //  보건소 목록 페이지
    @GetMapping("/main/hclist")
    public ModelAndView HCList() throws Exception{

        ModelAndView mv = new ModelAndView("/wdb/HCList");

        List<JsonDto> HCList = wdbService.HCList();

        mv.addObject("HCList",HCList);

        return mv;
    }



}
