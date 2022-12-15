package com.bitc.springteamproject1209.controller;

import com.bitc.springteamproject1209.service.SinJsonService;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.json.XML;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/wdb")
public class SinApiController {


//   보건소 json 데이터 가져오는 컨트롤러
    @Autowired
    private SinJsonService sinJsonService;

    @GetMapping("/bogun")
    public ResponseEntity<?> getJson() throws Exception{

        try {
            return ResponseEntity.status(HttpStatus.OK).body(sinJsonService.getJsonData());
        }catch (Exception e){
            e.getMessage();
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("잘못된 요청입니다");
        }

    }

    @GetMapping("/medi/insert")
    public ResponseEntity<?> XmlToJson() throws Exception {

        try {
            return ResponseEntity.status(HttpStatus.OK).body(sinJsonService.XmlToJson());
        } catch (Exception e) {
            e.getMessage();
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("잘못된 요청입니다");
        }
    }






}
