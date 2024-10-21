//package com.ghosttrio.judomanager.auth.security.jwt;
//
//import com.judomanager.common.exception.ErrorCode;
//import com.judomanager.common.exception.JMException;
//import com.judomanager.domain.security.jwt.JwtResolver;
//import com.judomanager.domain.security.jwt.JwtValidator;
//import jakarta.servlet.FilterChain;
//import jakarta.servlet.ServletException;
//import jakarta.servlet.http.HttpServletRequest;
//import jakarta.servlet.http.HttpServletResponse;
//import lombok.RequiredArgsConstructor;
//import lombok.extern.slf4j.Slf4j;
//import org.springframework.security.core.Authentication;
//import org.springframework.security.core.context.SecurityContextHolder;
//import org.springframework.util.AntPathMatcher;
//import org.springframework.web.filter.OncePerRequestFilter;
//
//import java.io.IOException;
//import java.util.List;
//
//import static com.judomanager.common.util.JudoMangerStatic.AUTHORIZATION_HEADER;
//
//
//@RequiredArgsConstructor
//@Slf4j
//public class JwtFilter extends OncePerRequestFilter {
//
//    private final JwtResolver jwtResolver;
//    private final JwtValidator jwtValidator;
//    private final AuthenticationLoader authenticationLoader;
//    private final List<String> allowUrls;
//
//    private final AntPathMatcher pathMatcher = new AntPathMatcher();
//    private static final String API_URI = "/api/v1";
//
//    @Override
//    protected void doFilterInternal(HttpServletRequest request,
//                                    HttpServletResponse response,
//                                    FilterChain filterChain)
//            throws ServletException, IOException {
//        if(!isAllowed(request.getRequestURI()) && request.getRequestURI().startsWith(API_URI)){
//            log.info("로그인 후 API");
//            String token = request.getHeader(JudoMangerStatic.AUTHORIZATION_HEADER);
//            if(token == null){
//                throw new JMException(ErrorCode.EMPTY_TOKEN);
//            }
//            String accessToken = jwtResolver.resolveToken(token);
//            if(accessToken != null && jwtValidator.validateToken(accessToken)){
//                Authentication authentication = authenticationLoader.getAuthentication(accessToken);
//                SecurityContextHolder.getContext().setAuthentication(authentication);
//            }else {
//                throw new JMException(ErrorCode.UNSUPPORTED_TOKEN);
//            }
//            filterChain.doFilter(request, response);
//        } else if(isAllowed(request.getRequestURI())){
////            log.info("로그인 전 API");
//            filterChain.doFilter(request, response);
//        } else {
//            log.info("허용되지 않은 API");
//            throw new JMException(ErrorCode.NOT_ALLOWED_URI);
//        }
//
//    }
//    private boolean isAllowed(String uri) {
//        for (String allowedUrl : allowUrls) {
//            if (pathMatcher.match(allowedUrl, uri)) {
//                return true;
//            }
//        }
//        return false;
//    }
//
//}