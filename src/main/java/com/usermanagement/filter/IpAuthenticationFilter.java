package com.usermanagement.filter;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Arrays;

public class IpAuthenticationFilter extends OncePerRequestFilter {

    @Value("${whitelist.ip}")
    private String[] whitelist;

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
        String userIp = request.getRemoteAddr();
        if(! Arrays.asList(whitelist).contains(userIp)){
            throw new BadCredentialsException("Invalid IP Address");
        }
        filterChain.doFilter(request, response);
    }
}
