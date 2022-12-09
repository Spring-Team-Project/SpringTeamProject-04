package com.bitc.springteamproject1209.service;

import com.bitc.springteamproject1209.dto.TestDto;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface TestService {

    List<TestDto> selectDBdto() throws Exception;
}
