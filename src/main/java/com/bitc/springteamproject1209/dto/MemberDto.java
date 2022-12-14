package com.bitc.springteamproject1209.dto;

import lombok.Data;

// 멤버 테이블
@Data
public class MemberDto {
  private int memIdx;
  private String memEmail;
  private String memId;
  private String memPwd;
  private String memAddr;
  private String memDeletedYn;
  private String memCreateDate;
}
