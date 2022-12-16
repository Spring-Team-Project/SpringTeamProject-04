package com.bitc.springteamproject1209.mapper;

import com.bitc.springteamproject1209.dto.LeePharmacyFullDataItemDto;
import com.bitc.springteamproject1209.dto.SinRegistDto;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface SinWdbMapper {


    void insertUser(SinRegistDto regist) throws Exception;

    int idCheck(String userId) throws Exception;

    int emailCheck(String userEmail) throws Exception;

     void PharmacyToDB(LeePharmacyFullDataItemDto PharmarcyDto) throws Exception;
}
