package com.ghosttrio.judomanager.auth.application.service;

import com.ghosttrio.judomanager.auth.common.exception.ErrorCode;
import com.ghosttrio.judomanager.auth.common.exception.JMException;
import com.ghosttrio.judomanager.auth.common.properties.JwtTokenProperty;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.ExpiredJwtException;
import io.jsonwebtoken.Jwts;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class AuthenticationLoader {

    private final CustomUserDetailsService customUserDetailsService;
    private final JwtTokenProperty jwtTokenProperty;

    public Authentication getAuthentication(String accessToken) {
        try {
            Claims claims = Jwts.parser()
                    .setSigningKey(jwtTokenProperty.getSecret())
                    .parseClaimsJws(accessToken)
                    .getBody();
            UserDetails user = customUserDetailsService.loadUserByUsername(claims.get("id").toString());
            return new UsernamePasswordAuthenticationToken(user, null, user.getAuthorities());
        } catch (ExpiredJwtException e) {
            throw new JMException(ErrorCode.EXPIRED_TOKEN);
        }
    }


}
