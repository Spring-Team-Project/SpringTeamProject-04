package com.bitc.springteamproject1209.dto;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "response")
public class LeePharmacyFullDataDto {
    private LeePharmacyFullDataHeaderDto header;
    private LeePharmacyFullDataBodyDto body;

    @XmlElement(name = "header")
    public LeePharmacyFullDataHeaderDto getHeader() {
        return header;
    }

    public void setHeader(LeePharmacyFullDataHeaderDto header) {
        this.header = header;
    }

    @XmlElement(name = "body")
    public LeePharmacyFullDataBodyDto getBody() {
        return body;
    }

    public void setBody(LeePharmacyFullDataBodyDto body) {
        this.body = body;
    }
}
