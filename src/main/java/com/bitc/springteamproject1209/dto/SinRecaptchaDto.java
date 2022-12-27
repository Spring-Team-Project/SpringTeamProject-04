package com.bitc.springteamproject1209.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class SinRecaptchaDto {
    private boolean success;
    private int number;
    private String action;
    private String challenge_ts;
    private String hostname;
    private String error_codes;
}
