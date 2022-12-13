package com.bitc.springteamproject1209.service;

import com.bitc.springteamproject1209.dto.JsonDto;
import com.bitc.springteamproject1209.dto.RegistDto;
import com.bitc.springteamproject1209.mapper.WdbMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class WdbServiceImpl implements WdbService{

    @Autowired
    private WdbMapper wdbMapper;
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

        for (int i = 0; i < receiveJson.size(); i++) {

            sendJsonDto.add((JsonDto) receiveJson.get(i));
        }

        return sendJsonDto;
    }


}
