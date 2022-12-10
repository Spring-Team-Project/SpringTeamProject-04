package com.bitc.springteamproject1209.service;

import com.bitc.springteamproject1209.dto.TestDto;
import org.springframework.stereotype.Service;

import java.util.List;


public interface TestService {
  List<TestDto> testList() throws Exception;
  void testList(TestDto testDto) throws Exception;
}
