package com.bitc.springteamproject1209.controller;

import com.bitc.springteamproject1209.dto.RegistDto;
import com.bitc.springteamproject1209.service.WdbService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.net.URI;


@RestController
@RequestMapping("/wdb")
public class PageController {

    @Autowired
    private WdbService wdbService;



//    임시 메인화면
    @GetMapping("/main")
    public ModelAndView mainView() throws Exception{

        ModelAndView mv = new ModelAndView("wdb/Main(Temporary)");

        return mv;
    }


//    회원가입 뷰
    @GetMapping("/user/signup")
    public ModelAndView userSignUp() throws Exception {

        ModelAndView mv = new ModelAndView("wdb/SignUp");

        return mv;
    }
//    회원가입 db 등록
    @PostMapping("/user/signup")
    public ResponseEntity<?> insertUser(RegistDto regist) throws Exception {

        HttpHeaders headers = new HttpHeaders();

        headers.setLocation(URI.create("/wdb/main"));

        try {
            wdbService.insertUser(regist);
            System.out.println("데이터 입력 성공");
        } catch (Exception e){
            e.printStackTrace();
        }



        return new ResponseEntity<>(headers, HttpStatus.MOVED_PERMANENTLY);
    }


}
