//package com.ghosttrio.judomanager.auth.security.jwt;
//
//import com.fasterxml.jackson.databind.ObjectMapper;
//import com.judomanager.common.exception.ErrorResponse;
//import com.judomanager.common.exception.JMException;
//import jakarta.servlet.FilterChain;
//import jakarta.servlet.ServletException;
//import jakarta.servlet.http.HttpServletRequest;
//import jakarta.servlet.http.HttpServletResponse;
//import org.apache.commons.lang3.CharEncoding;
//import org.springframework.web.filter.OncePerRequestFilter;
//
//import java.io.IOException;
//
//import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;
//
//public class JwtExceptionFilter extends OncePerRequestFilter {
//
//    private static final ObjectMapper mapper = new ObjectMapper();
//
//    @Override
//    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
//        try {
//            filterChain.doFilter(request, response);
//        } catch (JMException e) {
//            CatchJwtException(response, e);
//        }
//    }
//
//    private void CatchJwtException(HttpServletResponse response, JMException exception) throws IOException {
//        response.setContentType(MediaType.APPLICATION_JSON_VALUE);
//        response.setCharacterEncoding(CharEncoding.UTF_8);
//        response.setStatus(exception.getHttpStatus());
//        ErrorResponse error = ErrorResponse.from(exception.getErrorCode());
//        String value = mapper.writeValueAsString(error);
//        response.getWriter().write(value);
//    }
//}
