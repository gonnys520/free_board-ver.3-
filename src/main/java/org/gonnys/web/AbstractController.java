package org.gonnys.web;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.lang.reflect.Method;

public abstract class AbstractController extends HttpServlet {

    public abstract String getBasic();

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        System.out.println("service..........");

        String path = req.getRequestURI().substring(getBasic().length());
        String way = req.getMethod();

        System.out.println(path+": " + way);

        String methodName = path+way; //writeGET, listGET, writePOST

        Class clz = this.getClass();

        try {
            Method method = clz.getDeclaredMethod(methodName,HttpServletRequest.class, HttpServletResponse.class);

            Object result = method.invoke(this, req, resp);

            String returnURL = (String)result;

            System.out.println("RETURN: " + returnURL);

            if(returnURL.startsWith("redirect")){
                resp.sendRedirect(returnURL.substring(9));
                return;
            }
            req.getRequestDispatcher("/WEB-INF/"+returnURL+".jsp").forward(req, resp);

        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}