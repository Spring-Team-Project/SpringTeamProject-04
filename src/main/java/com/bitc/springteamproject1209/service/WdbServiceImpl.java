package com.bitc.springteamproject1209.service;

import com.bitc.springteamproject1209.dto.RegistDto;
import com.bitc.springteamproject1209.mapper.WdbMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class WdbServiceImpl implements WdbService{

    @Autowired
    private WdbMapper wdbMapper;


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


}
