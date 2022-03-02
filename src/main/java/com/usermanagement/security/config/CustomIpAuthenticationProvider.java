//package com.usermanagement.security.config;
//
//import org.springframework.beans.factory.annotation.Value;
//import org.springframework.security.authentication.AuthenticationProvider;
//import org.springframework.security.authentication.BadCredentialsException;
//import org.springframework.security.core.Authentication;
//import org.springframework.security.core.AuthenticationException;
//import org.springframework.security.web.authentication.WebAuthenticationDetails;
//
//import java.util.Arrays;
//import java.util.HashSet;
//import java.util.Set;
//
//public class CustomIpAuthenticationProvider implements AuthenticationProvider {
//
//
//    @Value("${whitelist.ip}")
//    private final String[] whitelist;
//
//    public CustomIpAuthenticationProvider(String[] whitelist) {
//        this.whitelist = whitelist;
//    }
//
//    @Override
//    public Authentication authenticate(Authentication authentication) throws AuthenticationException {
//        WebAuthenticationDetails details = (WebAuthenticationDetails) authentication.getDetails();
//        String userIp = details.getRemoteAddress();
//        if(! Arrays.asList(whitelist).contains(userIp)){
//            throw new BadCredentialsException("Invalid IP Address");
//        }
//        return ;
//    }
//
//    @Override
//    public boolean supports(Class<?> aClass) {
//        return false;
//    }
//}
