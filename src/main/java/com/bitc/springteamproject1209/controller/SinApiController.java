package com.bitc.springteamproject1209.controller;

import com.bitc.springteamproject1209.dto.LeePharmacyFullDataItemDto;
import com.bitc.springteamproject1209.service.SinJsonService;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.json.XML;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

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
    public ResponseEntity<?> getJson() throws Exception {

        try {
            return ResponseEntity.status(HttpStatus.OK).body(sinJsonService.getJsonData());
        } catch (Exception e) {
            e.getMessage();
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("잘못된 요청입니다");
        }

    }

    @GetMapping("/medi/insert")
    public void XmlToJson() throws Exception {


        StringBuilder urlBuilder = new StringBuilder("http://apis.data.go.kr/B552657/ErmctInsttInfoInqireService/getParmacyListInfoInqire"); /*URL*/
        urlBuilder.append("?" + URLEncoder.encode("serviceKey", "UTF-8") + "=U1KPxpwh5LlkYgaxQDqKj0Y%2BOMxzAdkRE2NYZ1vJ81ttyy7Bkoa6G7Aer2RA9gI2yj%2FrngeeKOPF60WxejblGg%3D%3D"); /*Service Key*/
        urlBuilder.append("&" + URLEncoder.encode("numOfRows", "UTF-8") + "=" + URLEncoder.encode("5000", "UTF-8")); /*목록 건수*/
        URL url = new URL(urlBuilder.toString());


        sinJsonService.getItemListUrl(String.valueOf(url));


    }


}
