package com.bitc.springteamproject1209.service;


import com.bitc.springteamproject1209.dto.SinPharmarcyDto;
import com.bitc.springteamproject1209.mapper.SinWdbMapper;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.json.XML;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class SinJsonServiceImpl implements SinJsonService {


    @Autowired
    SinWdbMapper sinWdbMapper;


    //    실질적인 제이슨 처리
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

//                System.out.println(dataArray.get(1));

//                obj = (JSONObject) dataArray;


                for (int i = 0; i < dataArray.size(); ++i) {
                    JSONObject json = (JSONObject) dataArray.get(i);
//                    System.out.println(json.get("시도"));
                    if ("보건소".equals(json.get("보건기관 유형"))) {
                        filterList.add(dataArray.get(i));
                    }
//                    if ("보건소".contains(json.get("주소"))) {
//                        filterList.add(dataArray.get(i));
//                    }
                }


                System.out.println(filterList.size());


            } catch (Exception e) {
                System.out.println("변환에 실패");
                e.printStackTrace();
            }


        } catch (Exception e) {
            e.printStackTrace();
        }


        return filterList;
    }


//    //    실질적인 XMLtoJSON 처리
//    @Override
//    public Map<String, Object> XmlToJson() throws Exception {
////        public Map<String, Object> getXmlToJson(@RequestParam Map<String, Object> paramMap) throws Exception {
//        Map<String, Object> resultMap = new HashMap<>();
//        List<SinPharmarcyDto> sendPharmacyDB = new ArrayList<>();
//
//
//        String serviceKey = "79Z0nFPSpEV7l%2BHQq%2BtyPXRh2REhCZRobIFdETr8Aj2xMN63iUWl17quZvKKf7R4vQfZZZhDVikeYZHPD6X2Hg%3D%3D";
//        String ermctInsttInfoUrl = "http://apis.data.go.kr/B552657/ErmctInsttInfoInqireService/getParmacyListInfoInqire";//?_wadl&type=xml
//
//        try {
//
//            StringBuilder urlBuilder = new StringBuilder(ermctInsttInfoUrl);
//            urlBuilder.append("?" + URLEncoder.encode("ServiceKey", "UTF-8") + "=" + serviceKey);
//            urlBuilder.append("&" + URLEncoder.encode("pageNo", "UTF-8") + "=1");
//            urlBuilder.append("&" + URLEncoder.encode("numOfRows", "UTF-8") + "=3");
//
//            URL url = new URL(urlBuilder.toString());
//
//            System.out.println("###url=>" + url);
//
//            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
//            conn.setRequestMethod("GET");
//            conn.setRequestProperty("Content-Type", "application/json");
//            System.out.println("Response Code:" + conn.getResponseCode());
//
//
//            BufferedReader rd;
//            if (conn.getResponseCode() >= 200 && conn.getResponseCode() <= 300) {
//                rd = new BufferedReader(new InputStreamReader(conn.getInputStream()));
//            } else {
//                rd = new BufferedReader(new InputStreamReader(conn.getErrorStream()));
//            }
//
//            StringBuilder sb = new StringBuilder();
//            String line;
//            while ((line = rd.readLine()) != null) {
//                sb.append(line);
//            }
//            rd.close();
//            conn.disconnect();
//
//            org.json.JSONObject xmlJSONObj = XML.toJSONObject(sb.toString());
//            String xmlJSONObjString = xmlJSONObj.toString();
////            System.out.println("### xmlJSONObjString=>" + xmlJSONObjString);
//
//            ObjectMapper objectMapper = new ObjectMapper();
//            Map<String, Object> map = new HashMap<>();
//            map = objectMapper.readValue(xmlJSONObjString, new TypeReference<Map<String, Object>>() {
//            });
//            Map<String, Object> dataResponse = (Map<String, Object>) map.get("response");
//            Map<String, Object> body = (Map<String, Object>) dataResponse.get("body");
//            Map<String, Object> items = null;
//            List<Map<String, Object>> itemList = null;
//
//            items = (Map<String, Object>) body.get("items");
//            itemList = (List<Map<String, Object>>) items.get("item");
//
//
//            resultMap.put("Result", "0000");
//            resultMap.put("numOfRows", body.get("numOfRows"));
//            resultMap.put("pageNo", body.get("pageNo"));
//            resultMap.put("totalCount", body.get("totalCount"));
//            resultMap.put("data", itemList);
//
//
//
//
//
////            for (int i = 0; i < itemList.size(); i++) {
////                JSONObject jsonObject = new JSONObject((Map) items.get("item"));
////
////                System.out.println(jsonObject);
////            }
//
////            try {
////                JSONArray jArray = new JSONArray();
////                for (int j = 0; j < itemList.size(); j++) {
////                    JSONObject sObject = new JSONObject();//배열 내에 들어갈 json
////                    sObject.put("itemName", resultMap.get("dutyName"));
////                    sObject.put("className", classList.get(j).getClass_name());
////                    sObject.put("classPrice", classList.get(j).getClass_price());
////                    sObject.put("classPriority", classList.get(j).getClass_priority());
////                    jArray.put(sObject);
////
////                    if (j >= classList.size() - 1) {
////
////                        jsonObject.put("class", jArray);
////
////                        System.out.println(jsonObject.toString());
////
////                    }
////                }
////
////            } catch (JSONException e) {
////                e.printStackTrace();
////            }
//
//
//
//
//
//
//
//
//
////            StringBuffer stringBuffer = new StringBuffer();
//
////            String jsonString1,jsonString2,jsonString3,jsonString4;
//
////            jsonString1 = itemList.get(1).toString().replaceAll("=",":");
////            jsonString2 = jsonString1.replaceAll(":","\":\"");
////            jsonString3 = jsonString2.replaceAll(",","\",\"");
////            jsonString4 = jsonString3.replaceAll(" ","");
////            stringBuffer.append(jsonString4);
////            stringBuffer.insert(1,"\"");
////            stringBuffer.insert(410,"\"");
////            String jsonString = String.valueOf(stringBuffer);
////            System.out.println(jsonString.length());
//
//
////            JSONObject jsonObject = (JSONObject) parser.parse(jsonString);
////
////
////            for (int i = 0; i < itemList.size(); i++) {
////
////                jsonObject.get("dutyName");
////
////            }
//
//
//
//
//
//            JSONParser parser = new JSONParser();
//            JSONObject jsonObject = (JSONObject) parser.parse(String.valueOf());
//
//
//
//
//
////            System.out.println(jsonObject);
//
//            System.out.println("야호");
//
//
////            for (int i = 0; i < itemList.size(); i++) {
////
////
////
////                System.out.println("야호");
////                String dutyAddr = mapJson.get("dutyAddr").toString();
////                String dutyName = mapJson.get("dutyName").toString();
////                String dutyTel1 = mapJson.get("dutyTel1").toString();
////                String dutyTime1c = mapJson.get("dutyTime1c").toString();
////                String dutyTime1s = mapJson.get("dutyTime1s").toString();
////                String hpid = mapJson.get("hpid").toString();
////                String rnum = mapJson.get("rnum").toString();
////                String wgs84Lat = mapJson.get("wgs84Lat").toString();
////                String wgs84Lon = mapJson.get("wgs84Lon").toString();
////
////                SinPharmarcyDto sinPharmarcyDto = new SinPharmarcyDto(dutyAddr, dutyName, dutyTel1, dutyTime1c, dutyTime1s, hpid, rnum, wgs84Lat, wgs84Lon);
////
////                sinWdbMapper.PharmacyToDB(sinPharmarcyDto);
////
////                sendPharmacyDB.add(sinPharmarcyDto);
////            }
//
//
//
////            System.out.println(pharmarcyDto);
//
//
//        } catch (Exception e) {
//            e.printStackTrace();
//            resultMap.clear();
//            resultMap.put("Result", "0001");
//        }
//        return resultMap;
//    }


//    XML to Json

//    public void XmlToJson() throws Exception {
//        StringBuilder urlBuilder = new StringBuilder("http://apis.data.go.kr/B552657/ErmctInsttInfoInqireService/getParmacyListInfoInqire"); /*URL*/
//        urlBuilder.append("?" + URLEncoder.encode("serviceKey", "UTF-8") + "=U1KPxpwh5LlkYgaxQDqKj0Y+OMxzAdkRE2NYZ1vJ81ttyy7Bkoa6G7Aer2RA9gI2yj/rngeeKOPF60WxejblGg=="); /*Service Key*/
//        urlBuilder.append("&" + URLEncoder.encode("Q0", "UTF-8") + "=" + URLEncoder.encode("서울특별시", "UTF-8")); /*주소(시도)*/
//        urlBuilder.append("&" + URLEncoder.encode("Q1", "UTF-8") + "=" + URLEncoder.encode("강남구", "UTF-8")); /*주소(시군구)*/
//        urlBuilder.append("&" + URLEncoder.encode("QT", "UTF-8") + "=" + URLEncoder.encode("1", "UTF-8")); /*월~일요일, 공휴일: 1~8*/
//        urlBuilder.append("&" + URLEncoder.encode("QN", "UTF-8") + "=" + URLEncoder.encode("삼성약국", "UTF-8")); /*기관명*/
//        urlBuilder.append("&" + URLEncoder.encode("ORD", "UTF-8") + "=" + URLEncoder.encode("NAME", "UTF-8")); /*순서*/
//        urlBuilder.append("&" + URLEncoder.encode("pageNo", "UTF-8") + "=" + URLEncoder.encode("1", "UTF-8")); /*페이지 번호*/
//        urlBuilder.append("&" + URLEncoder.encode("numOfRows", "UTF-8") + "=" + URLEncoder.encode("10", "UTF-8")); /*목록 건수*/
//        URL url = new URL(urlBuilder.toString());
//        HttpURLConnection conn = (HttpURLConnection) url.openConnection();
//        conn.setRequestMethod("GET");
//        conn.setRequestProperty("Content-type", "application/json");
//        System.out.println("Response code: " + conn.getResponseCode());
//        BufferedReader rd;
//        if (conn.getResponseCode() >= 200 && conn.getResponseCode() <= 300) {
//            rd = new BufferedReader(new InputStreamReader(conn.getInputStream()));
//        } else {
//            rd = new BufferedReader(new InputStreamReader(conn.getErrorStream()));
//        }
//        StringBuilder sb = new StringBuilder();
//        String line;
//        while ((line = rd.readLine()) != null) {
//            sb.append(line);
//        }
//        rd.close();
//        conn.disconnect();
//        System.out.println(sb.toString());
//    }
}





