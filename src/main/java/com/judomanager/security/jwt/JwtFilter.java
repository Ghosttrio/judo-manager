//package com.judomanager.security.jwt;
//
//import com.judomanager.common.exception.JMException;
//import jakarta.servlet.FilterChain;
//import jakarta.servlet.ServletException;
//import jakarta.servlet.http.HttpServletRequest;
//import jakarta.servlet.http.HttpServletResponse;
//import lombok.RequiredArgsConstructor;
//import lombok.extern.slf4j.Slf4j;
//import org.springframework.security.core.Authentication;
//import org.springframework.security.core.context.SecurityContextHolder;
//import org.springframework.web.filter.OncePerRequestFilter;
//
//import java.io.IOException;
//
//import static com.judomanager.common.util.Constant.AUTHORIZATION_HEADER;
//
//
//@RequiredArgsConstructor
//@Slf4j
//public class JwtFilter extends OncePerRequestFilter {
//
//    private final JwtGenerator jwtGenerator;
//    private final JwtResolver jwtResolver;
//
//    @Override
//    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
//            throws ServletException, IOException {
//
//        try {
//            String accessToken = jwtResolver.resolveToken(request.getHeader(AUTHORIZATION_HEADER));
//            if(accessToken != null && jwtGenerator.validateToken(accessToken)){
//                Authentication authentication = jwtGenerator.getAuthentication(accessToken);
//                SecurityContextHolder.getContext().setAuthentication(authentication);
//            }
//        }catch (JMException e){
//            request.setAttribute("exception", e.getMessage());
//        }
//
//        filterChain.doFilter(request, response);
//    }
//}