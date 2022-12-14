package com.bitc.springteamproject1209.controller;

import com.bitc.springteamproject1209.service.SinJsonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/wdb")
public class SinApiController {


//    json 데이터 가져오는 컨트롤러
    @Autowired
    private SinJsonService sinJsonService;

    @GetMapping("")
    public ResponseEntity<?> getJson() throws Exception{

        try {
            return ResponseEntity.status(HttpStatus.OK).body(sinJsonService.getJsonData());
        }catch (Exception e){
            e.getMessage();
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("잘못된 요청입니다");
        }

    }

}
