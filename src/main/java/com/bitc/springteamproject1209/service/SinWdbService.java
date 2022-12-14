package com.bitc.springteamproject1209.service;

import com.bitc.springteamproject1209.dto.SinJsonDto;
import com.bitc.springteamproject1209.dto.SinRegistDto;

import java.util.List;

public interface SinWdbService {


    int overlappedID(SinRegistDto sinRegistDto) throws Exception;

    void insertUser(SinRegistDto sinRegistDto) throws Exception;

    int overlappedEmail(SinRegistDto sinRegistDto) throws Exception;

    List<SinJsonDto> HCList() throws Exception;
}
