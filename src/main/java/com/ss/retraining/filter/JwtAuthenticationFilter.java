package com.ss.retraining.filter;


import com.fasterxml.jackson.databind.ObjectMapper;
import com.ss.retraining.dto.TokenDTO;
import com.ss.retraining.dto.UsersDTO;
import com.ss.retraining.entity.Users;
import com.ss.retraining.repository.UsersRepository;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.stereotype.Component;

import javax.crypto.SecretKey;
import javax.servlet.FilterChain;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.stream.Collectors;

import static com.ss.retraining.constans.JwtConstatns.EXPIRATION_TIME;

@Slf4j
public class JwtAuthenticationFilter extends UsernamePasswordAuthenticationFilter {

    private AuthenticationManager authenticationManager;

    private SecretKey secretKey;

    public JwtAuthenticationFilter(AuthenticationManager authenticationManager, SecretKey secretKey) {
        this.authenticationManager = authenticationManager;
        this.secretKey = secretKey;
        this.setFilterProcessesUrl("/auth/login/");
    }

    @Override
    public Authentication attemptAuthentication(HttpServletRequest request, HttpServletResponse response)
            throws AuthenticationException {
        try {
            UsersDTO credentials = new ObjectMapper()
                    .readValue(request.getInputStream(), UsersDTO.class);
            return authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(
                            credentials.getUsername(),
                            credentials.getPassword())
            );
        } catch (IOException e) {
            throw new BadCredentialsException("CREDENTIALS_READ_ERROR_MESSAGE");
        }
    }

    @Override
    protected void successfulAuthentication(HttpServletRequest req, HttpServletResponse res, FilterChain chain,
                                            Authentication auth) {
        String username = ((User) auth.getPrincipal()).getUsername();
        Claims claims = Jwts.claims().setSubject(username);
        claims.put("roles", auth.getAuthorities().stream().map(Object::toString).collect(Collectors.toList()));
        String token = Jwts.builder()
                .setClaims(claims)
                .setExpiration(new Date(System.currentTimeMillis() + EXPIRATION_TIME))
                .signWith(SignatureAlgorithm.HS512, secretKey)
                .compact();
        res.setContentType("application/json");
        try {
            new ObjectMapper().writeValue(res.getWriter(), new TokenDTO(token));
        } catch (IOException e) {
            log.error("TOKEN_WRITE_ERROR_MESSAGE", e);
        }
    }
}
