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

    @Autowired
    private SinWdbMapper sinWdbMapper;
    @Autowired
    private SinJsonService sinJsonService;


    @Override
    public int overlappedID(String userId) throws Exception {


        int idCheck = sinWdbMapper.idCheck(userId);
        return idCheck;
    }

    @Override
    public void insertUser(SinRegistDto sinRegistDto) throws Exception {

        sinWdbMapper.insertUser(sinRegistDto);

    }

    @Override
    public int overlappedEmail(String userEmail) throws Exception {
        int emailCheck = sinWdbMapper.emailCheck(userEmail);
        return emailCheck;
    }

    @Override
    public List<SinJsonDto> HCList() throws Exception {

        List<SinJsonDto> sendSinJsonDto = new ArrayList<>();
        List<Object> receiveJson = sinJsonService.getJsonData();



//        System.out.println(receiveJson.get(0));


        for (int i = 0; i < receiveJson.size(); i++) {

            JSONObject mapJson = (JSONObject) receiveJson.get(i);
//            System.out.println(mapJson);

            String sido = mapJson.get("시도").toString();
            String sigungu = mapJson.get("시군구").toString();
            String medicalType = mapJson.get("보건기관 유형").toString();
            String medicalName = mapJson.get("보건기관명").toString();
            String postCode = mapJson.get("우편번호").toString();
            String medicalAddr = mapJson.get("주소").toString();
            String eupmyeondong = mapJson.get("읍면동명").toString();
            String doseo = mapJson.get("도서지역여부").toString();
            String tel = mapJson.get("대표전화번호").toString();

//            System.out.println(sido);

            SinJsonDto sinJsonDto = new SinJsonDto(sido,sigungu,medicalType,medicalName,postCode,medicalAddr,eupmyeondong,doseo,tel);

            sendSinJsonDto.add(sinJsonDto);
        }

        return sendSinJsonDto;
    }

    @Override
    public List<SinJsonDto> filterHcList(String filtering) throws Exception {
        return null;
    }


}
