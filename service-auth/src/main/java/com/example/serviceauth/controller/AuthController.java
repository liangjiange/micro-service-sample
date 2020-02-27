package com.example.serviceauth.controller;

import com.example.serviceauth.dto.UserDTO;
import com.example.serviceauth.jwt.JWTTokenService;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

/**
 * 描述: 认证接口
 *
 * @Auther: lzx
 * @Date: 2019/7/9 13:53
 */
@RestController
@Slf4j
public class AuthController {

    private ObjectMapper objectMapper;

    @Value("${org.my.jwt.effective-time}")
    private String effectiveTime;

    public AuthController(ObjectMapper objectMapper) {
        this.objectMapper = objectMapper;
    }

    /**
     * 登陆认证接口
     *
     * @param userDTO
     * @return
     */
    @GetMapping("/login")
    public ResponseEntity<String> login(@RequestBody UserDTO userDTO) throws Exception {
        //TODO 用户名密码校验，校验成功的话生成jwt token
        List<GrantedAuthority> authorities = new ArrayList();
        GrantedAuthority grantedAuthority = new GrantedAuthority() {
            @Override
            public String getAuthority() {
                return "ROLE_ADMIN";
            }
        };
        authorities.add(grantedAuthority);
        String jwt = JWTTokenService.generateToken("zhangshan", "", authorities);

        return ResponseEntity.ok(jwt);
    }

    @GetMapping("test")
    public String demo() {
        return "test hello";
    }

}
