package com.bitc.springteamproject1209.service;

import com.bitc.springteamproject1209.dto.JsonDto;
import com.bitc.springteamproject1209.dto.RegistDto;
import com.bitc.springteamproject1209.mapper.WdbMapper;
import org.json.simple.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class WdbServiceImpl implements WdbService {

    @Autowired
    private WdbMapper wdbMapper;
    @Autowired
    private JsonService jsonService;


    @Override
    public int overlappedID(RegistDto registDto) throws Exception {


        int idCheck = wdbMapper.idCheck(registDto);
        return idCheck;
    }

    @Override
    public void insertUser(RegistDto registDto) throws Exception {

        wdbMapper.insertUser(registDto);

    }

    @Override
    public int overlappedEmail(RegistDto registDto) throws Exception {
        int emailCheck = wdbMapper.emailCheck(registDto);
        return emailCheck;
    }

    @Override
    public List<JsonDto> HCList() throws Exception {

        List<JsonDto> sendJsonDto = new ArrayList<>();
        List<Object> receiveJson = jsonService.getJsonData();


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

            JsonDto jsonDto = new JsonDto(sido,sigungu,medicalType,medicalName,postCode,medicalAddr,eupmyeondong,doseo,tel);

            sendJsonDto.add(jsonDto);
        }

        return sendJsonDto;
    }


}
