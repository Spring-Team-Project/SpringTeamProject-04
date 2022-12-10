package com.bitc.springteamproject1209.service;

import com.bitc.springteamproject1209.dto.TestDto;
import com.bitc.springteamproject1209.mapper.TestMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TestServiceImpl implements TestService{

  @Autowired
  private TestMapper testMapper;


  @Override
  public List<TestDto> testList() throws Exception {
    return testMapper.testList();
  }

  @Override
  public void testList(TestDto testDto) throws Exception {

  }
}
