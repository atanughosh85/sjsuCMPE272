package com.sjsu.cmpe272.main;

import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.oauth2.jwt.Jwt;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class GetClaims {
    private static final String template = "Hello, %s! Your sub is %s";

    @RequestMapping("/getClaims")
    public String greeting(@RequestParam(value="name", defaultValue="DefaultUser") String name,
                           @AuthenticationPrincipal Jwt accessToken) {

        return String.format(template, name, accessToken.getClaims().get("sub"));
    }
}