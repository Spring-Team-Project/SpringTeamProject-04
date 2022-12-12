package com.bitc.springteamproject1209.controller;

import com.bitc.springteamproject1209.dto.RegistDto;
import com.bitc.springteamproject1209.service.WdbService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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


    @ResponseBody // 값 변환을 위해 꼭 필요함
    @GetMapping("/user/idcheck") // 아이디 중복확인을 위한 값으로 따로 매핑
    public int overlappedID(RegistDto registDto) throws Exception{


        int result = wdbService.overlappedID(registDto);

        return result;
    }

    @PostMapping("/user/signup/success")
//   예외처리 성공시 회원가입 db 등록
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




}
