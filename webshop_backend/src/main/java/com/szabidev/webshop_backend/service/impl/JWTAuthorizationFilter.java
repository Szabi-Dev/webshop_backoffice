package com.szabidev.webshop_backend.service.impl;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.szabidev.webshop_backend.config.SecurityConstants;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;

import static com.szabidev.webshop_backend.config.SecurityConstants.HEADER_STRING;
import static com.szabidev.webshop_backend.config.SecurityConstants.TOKEN_PREFIX;

@Service("jwtAuthorizationFilter")
public class JWTAuthorizationFilter extends OncePerRequestFilter {

    @Value("${spring.security.jwt.secret}")
    private String SECRET;


    @Override
    protected void doFilterInternal(HttpServletRequest req, HttpServletResponse res, FilterChain chain) throws IOException, ServletException {
        String header = req.getHeader(HEADER_STRING);
        if (header == null || !header.startsWith(TOKEN_PREFIX)) {
            chain.doFilter(req, res);
            return;
        }

        UsernamePasswordAuthenticationToken authentication = getAuthentication(req);

        SecurityContextHolder.getContext().setAuthentication(authentication);
        chain.doFilter(req, res);
    }

    private UsernamePasswordAuthenticationToken getAuthentication(HttpServletRequest request) {
        String tokenHeader = request.getHeader(HEADER_STRING);
        if (tokenHeader == null || tokenHeader.isEmpty()) {
            return null;
        }
        String token = tokenHeader.replace(TOKEN_PREFIX, "");
        String user = JWT.require(Algorithm.HMAC512(SECRET.getBytes()))
                .build()
                .verify(token)
                .getSubject();

        if (user == null || user.isEmpty()) {
            return null;
        }
        //TODO: authorities instead of empty list
        return new UsernamePasswordAuthenticationToken(user, null, new ArrayList<>());
    }
}
