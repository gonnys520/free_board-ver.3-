package org.gonnys.filter;

import lombok.extern.log4j.Log4j;
import org.gonnys.domain.PageDTO;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Log4j
@WebFilter(urlPatterns = {"/board/list"})
public class LoginCheckFilter implements Filter {


    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {


        //쿠키를 사용할 때는 (HttpSelvertRequest)로 싸줘야함
        HttpServletRequest req = (HttpServletRequest) servletRequest;
        HttpServletResponse resp = (HttpServletResponse) servletResponse;
        Cookie[] cks = req.getCookies();

        if (cks == null || cks.length == 0) {
            resp.sendRedirect("/index.jsp");
        }
        boolean check = false;

        for (Cookie ck : cks) {
            if (ck.getName().equals("login")) {
                check = true;
                break;
            }
        }   //end for

        if(!check){
            resp.sendRedirect("/index.jsp"); // 쿠키가 다르다면 메인으로 리다이렉트
        }
        filterChain.doFilter(servletRequest, servletResponse);
    }
}