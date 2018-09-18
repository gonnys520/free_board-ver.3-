package org.gonnys.web;

import lombok.extern.log4j.Log4j;
import org.apache.log4j.Logger;
import org.gonnys.dao.BoardDAO;
import org.gonnys.domain.BoardVO;
import org.gonnys.domain.PageDTO;
import org.gonnys.domain.PageMaker;
import org.gonnys.web.util.Converter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.lang.reflect.Method;

@Log4j
@WebServlet(urlPatterns = "/board/*")
public class BoardController extends AbstractController {

    private BoardDAO dao = new BoardDAO();

    private static Logger logger = Logger.getLogger("board");



    //Remove Post
    public void removePOST(HttpServletRequest req, HttpServletResponse resp) throws Exception {

        req.setCharacterEncoding("UTF-8");


        int bno = Converter.getInt(req.getParameter("bno"), -1);

        dao.removeContent(bno);

        req.setAttribute("board", dao.getBoard(bno, false));

        resp.sendRedirect("/board/list");
    }


    //Modify Get
    public String modifyGET(HttpServletRequest req, HttpServletResponse resp) throws Exception {

        req.setCharacterEncoding("UTF-8");


        int bno = Converter.getInt(req.getParameter("bno"), -1);

        req.setAttribute("board", dao.getBoard(bno, false));

        return "modify";
    }

    //Modify Post
    public void modifyPOST(HttpServletRequest req, HttpServletResponse resp) throws Exception {

        req.setCharacterEncoding("UTF-8");



        BoardVO vo = new BoardVO();
        int bno = Converter.getInt(req.getParameter("bno"), -1);
        int page = Converter.getInt(req.getParameter("page"), -1);

        vo.setBno(bno);
        vo.setTitle(req.getParameter("title"));
        vo.setContent(req.getParameter("content"));

        dao.modifyContent(vo);

        req.setAttribute("board", dao.getBoard(bno, false));

        resp.sendRedirect("/board/list?bno="+bno + "&page=" + page);

    }


    public String writeGET(HttpServletRequest req, HttpServletResponse resp) throws Exception{
        System.out.println("writeGET...........................");
        return "write";
    }

    public String writePOST(HttpServletRequest req, HttpServletResponse resp) throws Exception{
        System.out.println("writePOST...........................");

        req.setCharacterEncoding("UTF-8");

        BoardVO vo = new BoardVO();
        vo.setTitle(req.getParameter("title"));
        vo.setContent(req.getParameter("content"));
        vo.setWriter(req.getParameter("writer"));

        dao.create(vo);

        return "redirect/list";

    }


    public String listGET(HttpServletRequest req, HttpServletResponse resp) throws Exception {




        PageDTO dto = PageDTO.of()
                .setPage(Converter.getInt(req.getParameter("page"), 1))
                .setSize(Converter.getInt(req.getParameter("size"), 10));

        int total = 320;
        PageMaker pageMaker = new PageMaker(total, dto);

        req.setAttribute("pageMaker", pageMaker);
        req.setAttribute("list", dao.getList(dto));

        return "list";
    }

    public String readGET(HttpServletRequest req, HttpServletResponse resp) throws Exception {


        String bnoStr = req.getParameter("bno");
        int bno = Converter.getInt(bnoStr, -1);
        String pageStr = req.getParameter("page");
        int page = Converter.getInt(pageStr, -1);
        boolean updateable = false;

        if (bno == -1) {
            throw new Exception("invalid data");
        }

        Cookie[] cookies = req.getCookies();
        Cookie viewCookie = null;
        for (Cookie ck : cookies) {
            if (ck.getName().equals("views")) {
                viewCookie = ck;
                break;
            }
        }

        //쿠키가 없다면
        if (viewCookie == null) {
            Cookie newCookie = new Cookie("views", bnoStr + "%");
            newCookie.setMaxAge(60 * 60 * 24);
            viewCookie = newCookie;
            updateable = true;
        } else {
            //쿠키가 있다면
            String cookieValue = viewCookie.getValue();
            updateable = cookieValue.contains(bnoStr + "%") == false;

            if (updateable) {
                cookieValue += bnoStr + "%";
                viewCookie.setValue(cookieValue);
            }
        }


        resp.addCookie(viewCookie);

        req.setAttribute("board", dao.getBoard(bno, updateable));
        req.setAttribute("page", page);

        return "read";
    }

    public String getBasic() {
        return "/board/";
    }


}