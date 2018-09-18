package org.gonnys.filter;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

//url 패턴이 내가 어디 경로까지 들어갔다는 걸 보여줌
@WebFilter(urlPatterns = "/*/*")
public class SampleFilter implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        System.out.println("init sample filter");
    }

    // /board로 시작하는 url을 doFilter가 막아버리는거임!!!!!
    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        System.out.println("do sample filter");

        HttpServletResponse resq = (HttpServletResponse)servletRequest;

        //page 번호가 음수일 때 예외처리
        String pageStr = servletRequest.getParameter("page");
        try {

            if(pageStr == null) {
                throw new Exception("NULL");}
                int page = Integer.parseInt(pageStr);

        }catch (NumberFormatException e){
            resq.sendRedirect("/error");
            return;
        }catch (Exception ee){

        }

        // filterchain이 막아 논 걸 지나갈 수 있게 해줌
        filterChain.doFilter(servletRequest, servletResponse);
    }

    @Override
    public void destroy() {
        System.out.println("destroy sample filter");
    }
}
