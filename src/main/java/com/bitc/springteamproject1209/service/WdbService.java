package com.bitc.springteamproject1209.service;

import com.bitc.springteamproject1209.dto.RegistDto;

public interface WdbService {


    int overlappedID(RegistDto registDto) throws Exception;

    void insertUser(RegistDto regist) throws Exception;

}
