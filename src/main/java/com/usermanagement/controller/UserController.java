package com.usermanagement.controller;

import com.usermanagement.dto.UserInfo;
import com.usermanagement.dto.UserSignUpDTO;
import com.usermanagement.security.service.AuthenticationService;
import com.usermanagement.service.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import static sun.net.www.protocol.http.AuthCacheValue.Type.Proxy;

@RestController
@RequestMapping("/account")
public class UserController {

    private final UserService userService;
    private final AuthenticationService authenticationService;

    public UserController(UserService userService, AuthenticationService authenticationService) {
        this.userService = userService;
        this.authenticationService = authenticationService;
    }

    @PostMapping(value = "/sign-up")
    @ResponseStatus(HttpStatus.CREATED)
    public void signUp(@RequestBody @Valid UserSignUpDTO userSignUpDTO) {
        userService.signUp(userSignUpDTO);
    }


    @GetMapping("/me")
    @ResponseStatus(HttpStatus.OK)
    public UserInfo getUserInfo(@RequestHeader("X-Auth-Token") String token) {
        return authenticationService.authorizeToken(token);
    }

    @GetMapping("/myip")
    @ResponseStatus(HttpStatus.OK)
    public String getUserInfo (HttpServletRequest hsr) {
       return getRequestIP(hsr);

    }
    private static final String[] IP_HEADERS = {
            "X-Real-IP",
            "X-Forwarded-For",
            "Proxy-Client-IP",
            "WL-Proxy-Client-IP",
            "HTTP_X_FORWARDED_FOR",
            "HTTP_X_FORWARDED",
            "HTTP_X_CLUSTER_CLIENT_IP",
            "HTTP_CLIENT_IP",
            "HTTP_FORWARDED_FOR",
            "HTTP_FORWARDED",
            "HTTP_VIA",
            "REMOTE_ADDR"

            // you can add more matching headers here ...
    };

    public static String getRequestIP(HttpServletRequest request) {
        for (String header: IP_HEADERS) {
            String value = request.getHeader(header);
            if (value == null || value.isEmpty()) {
                continue;
            }


        return value;
    }
        return request.getRemoteAddr();
}

}
