package com.bitc.springteamproject1209.service;

import com.bitc.springteamproject1209.dto.JsonDto;
import com.bitc.springteamproject1209.dto.RegistDto;

import java.util.List;

public interface WdbService {


    int overlappedID(RegistDto registDto) throws Exception;

    void insertUser(RegistDto registDto) throws Exception;

    int overlappedEmail(RegistDto registDto) throws Exception;

    List<JsonDto> HCList() throws Exception;
}
