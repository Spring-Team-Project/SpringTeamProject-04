package com.bitc.springteamproject1209.service;


import com.bitc.springteamproject1209.dto.*;
import com.bitc.springteamproject1209.mapper.SinWdbMapper;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.Unmarshaller;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

@Service
public class SinJsonServiceImpl implements SinJsonService {


    @Autowired
    SinWdbMapper sinWdbMapper;



    //--------------------------------------------------------------------------------------------------------------



    //    실질적인 Json 서비스
    @Override
    public List<Object> getJsonData() throws Exception {

        String api = "https://api.odcloud.kr/api/3072692/v1/uddi:9d420e87-8e70-4fb0-a54a-be1244249b2e_201909271427" +
                "?" +
                "page=1&perPage=3600&serviceKey=U1KPxpwh5LlkYgaxQDqKj0Y%2BOMxzAdkRE2NYZ1vJ81ttyy7Bkoa6G7Aer2RA9gI2yj%2FrngeeKOPF60WxejblGg%3D%3D";

//        추후 구현 : page값 변수화 하여 알아서 최대 페이지로 적용 do_while 사용

        JSONArray dataArray;
        JSONObject obj;
        List<Object> filterList = new ArrayList<>();

        try {
            URL url = new URL(api);
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();

            conn.setRequestMethod("GET"); // http 메서드
            conn.setRequestProperty("Content-Type", "application/json"); // header Content-Type 정보
            conn.setRequestProperty("auth", "myAuth"); // header의 auth 정보
            conn.setDoOutput(true); // 서버로부터 받는 값이 있다면 true

            // 서버로부터 데이터 읽어오기
            BufferedReader br = new BufferedReader(new InputStreamReader(conn.getInputStream()));
            StringBuilder sb = new StringBuilder();
            String line = null;

            while ((line = br.readLine()) != null) { // 읽을 수 있을 때 까지 반복
                sb.append(line);
            }

            JSONParser parser = new JSONParser();


            try {
//                obj 에 json 데이터로 파싱
                obj = (JSONObject) parser.parse(sb.toString());

                dataArray = (JSONArray) obj.get("data");


//                의료기관 DB화 코드 시작
                try {
                    for (int i = 0; i < dataArray.size(); ++i) {
//            하나하나 꺼내기
                        JSONObject mapJson = (JSONObject) dataArray.get(i);

                        String sido = mapJson.get("시도").toString();
                        String sigungu = mapJson.get("시군구").toString();
                        String medicalType = mapJson.get("보건기관 유형").toString();
                        String medicalName = mapJson.get("보건기관명").toString();
                        String postCode = mapJson.get("우편번호").toString();
                        String medicalAddr = mapJson.get("주소").toString();
                        String eupmyeondong = mapJson.get("읍면동명").toString();
                        String doseo = mapJson.get("도서지역여부").toString();
                        String tel = mapJson.get("대표전화번호").toString();

                        SinJsonDto sinJsonDto = new SinJsonDto(sido, sigungu, medicalType, medicalName, postCode, medicalAddr, eupmyeondong, doseo, tel);


                        sinWdbMapper.HealthCenterToDB(sinJsonDto);
                    }

                    System.out.println("db 데이터 입력 성공");
                } catch (Exception e) {
                    e.printStackTrace();
                    System.out.println("db 데이터 입력 실패");
                }

//                의료기관 DB화 코드 종료







//                보건소 만 필터링 코드 시작
                for (int i = 0; i < dataArray.size(); ++i) {
                    JSONObject json = (JSONObject) dataArray.get(i);
//                    System.out.println(json.get("시도"));
                    if ("보건소".equals(json.get("보건기관 유형"))) {
                        filterList.add(dataArray.get(i));
                    }
//
                }


                System.out.println(filterList.size());


            } catch (Exception e) {
                System.out.println("변환에 실패");
                e.printStackTrace();
            }

//            보건소 만 필터링 코드 종료

        } catch (Exception e) {
            e.printStackTrace();
        }


        return filterList;
    }


//--------------------------------------------------------------------------------------------------------------




//    약국 DB화 코드
    @Override
    public void getItemListUrl(String strUrl) {


        List<LeePharmacyFullDataItemDto> itemList = null;

        URL url = null;

        HttpURLConnection urlConn = null;

        try {
            url = new URL(strUrl);
            urlConn = (HttpURLConnection) url.openConnection();
            urlConn.setRequestMethod("GET");


            JAXBContext jc = JAXBContext.newInstance(LeePharmacyFullDataDto.class);

            Unmarshaller um = jc.createUnmarshaller();

            LeePharmacyFullDataDto fullData = (LeePharmacyFullDataDto) um.unmarshal(url);


            itemList = fullData.getBody().getItems().getItemList();

            for (int i = 0; i <itemList.size(); i++) {
                sinWdbMapper.PharmacyToDB(itemList.get(i));


            }

            System.out.println("데이터 입력 성공");

        }catch (Exception e){
            e.printStackTrace();

            System.out.println("데이터 입력 실패");
        }finally {
            if (urlConn != null){urlConn.disconnect();}
        }









    }


}






