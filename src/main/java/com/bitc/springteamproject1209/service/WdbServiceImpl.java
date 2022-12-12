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


        int result = wdbMapper.idCheck(registDto);
        return result;
    }

    @Override
    public void insertUser(RegistDto regist) throws Exception {

        wdbMapper.insertUser(regist);

    }



}
