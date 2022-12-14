package com.bitc.springteamproject1209.service;

import com.bitc.springteamproject1209.dto.SinJsonDto;
import com.bitc.springteamproject1209.dto.SinRegistDto;

import java.util.List;

public interface SinWdbService {


    int overlappedID(String userId) throws Exception;

    void insertUser(SinRegistDto sinRegistDto) throws Exception;

    int overlappedEmail(String userEmail) throws Exception;

    List<SinJsonDto> HCList() throws Exception;

    List<SinJsonDto> filterHcList(String filtering) throws Exception;
}
