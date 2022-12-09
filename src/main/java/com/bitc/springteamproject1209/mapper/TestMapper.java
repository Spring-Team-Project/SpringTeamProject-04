package com.bitc.springteamproject1209.mapper;

import com.bitc.springteamproject1209.dto.TestDto;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface TestMapper {


    List<TestDto> selectDBdto() throws Exception;
}
