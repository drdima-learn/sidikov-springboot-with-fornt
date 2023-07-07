package com.rubincomputers.springboot01.security.filter;

import com.rubincomputers.springboot01.security.token.TokenAuthentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

@Component
public class TokenAuthFilter implements Filter {
//    @Override
//    public void init(FilterConfig filterConfig) throws ServletException {
//        Filter.super.init(filterConfig);
//    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        HttpServletRequest request = (HttpServletRequest) servletRequest;
        String token = request.getParameter("token");

        TokenAuthentication tokenAuthentication = new TokenAuthentication(token);
        if (token != null) {
            SecurityContextHolder.getContext().setAuthentication(tokenAuthentication);
        }
        chain.doFilter(servletRequest, response);
    }

    @Override
    public void destroy() {
        Filter.super.destroy();
    }
}
