package com.alamgir.l_spring_boot_security_jwt.security;

import java.io.IOException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import com.alamgir.l_spring_boot_security_jwt.jwt.JwtTokenHelper;

import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@Component
public class JWTTokenFilter extends OncePerRequestFilter {

    Logger logger = LoggerFactory.getLogger(JWTTokenFilter.class);

    @Autowired
    JwtTokenHelper jwtTokenHelper;

    @Autowired
    UserAuthenticationServiceImpl authenticationService;

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)   throws ServletException, IOException {

        logger.info("JWTTokenFilter : validation of JWT token by OncePerRequestFilter");
        String token = request.getHeader("Authorization");

        logger.info("JWT token : " + token);
        String userName = null;

        if (token != null) {
            userName = this.jwtTokenHelper.extractUsername(token);
            logger.info("JWTTokenFilter : Request Token come from an User : " + userName);
        } else {
            logger.info("ToKen is Misisng. Please Come with Token");
        }

        if (userName != null && SecurityContextHolder.getContext().getAuthentication() == null) {

            logger.info("JWTTokenFilter : getting user info from DB");
            UserDetails userDetails = this.authenticationService.loadUserByUsername(userName);
            logger.info("JWTTokenFilter :  Now Validating  the token ");
            Boolean isValidToken = this.jwtTokenHelper.isValidToken(token, userDetails.getUsername());
            logger.info("JWTTokenFilter : Is it Valid Token : " + isValidToken);
            if (isValidToken) {

                logger.info("JWTTokenFilter : Setting Security Context for that username");
                UsernamePasswordAuthenticationToken authenticationToken = new UsernamePasswordAuthenticationToken(userDetails, null, userDetails.getAuthorities());
                authenticationToken.setDetails(new WebAuthenticationDetailsSource().buildDetails(request));
                SecurityContextHolder.getContext().setAuthentication(authenticationToken);
            }

        }

        filterChain.doFilter(request, response);
    }

}
