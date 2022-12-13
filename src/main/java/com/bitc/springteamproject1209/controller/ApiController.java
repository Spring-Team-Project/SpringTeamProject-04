package com.bitc.springteamproject1209.controller;

import com.bitc.springteamproject1209.service.JsonService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
@RequestMapping("/wdb")
public class ApiController {


    private final JsonService jsonService;

    @PostMapping("")
    public ResponseEntity<?> getJson() throws Exception{

        try {
            return ResponseEntity.status(HttpStatus.OK).body(jsonService.getJsonData());
        }catch (Exception e){
            e.getMessage();
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("잘못된 요청입니다");
        }

    }

}
