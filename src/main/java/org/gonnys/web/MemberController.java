package org.gonnys.web;

import lombok.extern.log4j.Log4j;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.net.URLEncoder;

@WebServlet("/member/*")
@Log4j


public class MemberController extends AbstractController{

    public String loginGET(HttpServletRequest req, HttpServletResponse resp) throws Exception{



        Cookie loginCookie = new Cookie("login", URLEncoder.encode("Gonnys", "UTF-8"));
        loginCookie.setMaxAge(60*60*24);
        loginCookie.setPath("/");
        resp.addCookie(loginCookie);


        return "/board/list";



    }


    @Override
    public String getBasic() {
        return "/member/";

    }
}
