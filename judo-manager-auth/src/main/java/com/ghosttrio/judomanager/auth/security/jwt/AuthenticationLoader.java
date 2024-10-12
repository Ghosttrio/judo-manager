package com.ghosttrio.judomanager.auth.security.jwt;

import com.ghosttrio.judomanager.auth.security.CustomUserDetailsService;
import com.judomanager.domain.security.jwt.JwtResolver;
import io.jsonwebtoken.Claims;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class AuthenticationLoader {

    private final JwtResolver jwtResolver;
    private final CustomUserDetailsService customUserDetailsService;

    public Authentication getAuthentication(String accessToken) {
        Claims claims = jwtResolver.getClaims(accessToken);
        UserDetails user = customUserDetailsService.loadUserByUsername(claims.get("id").toString());
        return new UsernamePasswordAuthenticationToken(user, null, user.getAuthorities());
    }

}
