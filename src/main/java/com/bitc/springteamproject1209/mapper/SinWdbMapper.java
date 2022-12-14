package com.bitc.springteamproject1209.mapper;

import com.bitc.springteamproject1209.dto.SinRegistDto;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface SinWdbMapper {


    void insertUser(SinRegistDto regist) throws Exception;

    int idCheck(SinRegistDto sinRegistDto) throws Exception;

    int emailCheck(SinRegistDto sinRegistDto) throws Exception;
}
