package com.example.community.dto;


import lombok.Data;
import org.springframework.stereotype.Component;

@Data
public class AccessTokenDTO {

    public String client_id;
    public String client_secret;
    public String code;
    public String redirect_uri;
    public String state;


}
