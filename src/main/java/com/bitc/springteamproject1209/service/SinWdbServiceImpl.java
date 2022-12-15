package com.bitc.springteamproject1209.service;

import com.bitc.springteamproject1209.dto.SinJsonDto;
import com.bitc.springteamproject1209.dto.SinRegistDto;
import com.bitc.springteamproject1209.mapper.SinWdbMapper;
import org.json.simple.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class SinWdbServiceImpl implements SinWdbService {

    //    페이지의 SQL 작업 맵퍼
    @Autowired
    private SinWdbMapper sinWdbMapper;

    //    Json 데이터 서비스
    @Autowired
    private SinJsonService sinJsonService;


    //    아이디 중복 체크
    @Override
    public int overlappedID(String userId) throws Exception {


        int idCheck = sinWdbMapper.idCheck(userId);
        return idCheck;
    }

    //    이메일 중복 체크
    @Override
    public int overlappedEmail(String userEmail) throws Exception {
        int emailCheck = sinWdbMapper.emailCheck(userEmail);
        return emailCheck;
    }

    //    회원테이블 신규 회원 데이터 입력
    @Override
    public void insertUser(SinRegistDto sinRegistDto) throws Exception {

        sinWdbMapper.insertUser(sinRegistDto);

    }



//    초기 뷰
    @Override
    public List<SinJsonDto> HCMainList() throws Exception {

        //        리턴 해줄 dto 리스트
        List<SinJsonDto> sendSinJsonDto = new ArrayList<>();
//        변환할 object 리스트
        List<Object> receiveJson = sinJsonService.getJsonData();

        try {
            for (int i = 0; i < receiveJson.size(); i++) {
//            하나하나 꺼내기
                JSONObject mapJson = (JSONObject) receiveJson.get(i);
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

                sendSinJsonDto.add(sinJsonDto);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return sendSinJsonDto;
    }


    //    Api로 불러온 Json 데이터 Dto 변수 맵핑
    @Override
    public List<SinJsonDto> HCList(String UWord, String telCode) throws Exception {

//        리턴 해줄 dto 리스트
        List<SinJsonDto> sendSinJsonDto = new ArrayList<>();
//        변환할 object 리스트
        List<Object> receiveJson = sinJsonService.getJsonData();


        try {
            for (int i = 0; i < receiveJson.size(); i++) {

//            하나하나 꺼내기
                JSONObject mapJson = (JSONObject) receiveJson.get(i);

                if (UWord == null && telCode == null) {

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

                    sendSinJsonDto.add(sinJsonDto);

                } else if (telCode != null) {

                    String allTel = mapJson.get("대표전화번호").toString();
                    String compare = allTel.substring(0,3);
                    String compare2 = allTel.substring(0,2);

                    if (compare2.equals(telCode)){
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

                        sendSinJsonDto.add(sinJsonDto);

                    }else if (compare.equals(telCode)) {
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

                        sendSinJsonDto.add(sinJsonDto);


                    }
                }
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return sendSinJsonDto;
    }



}
