package com.feng.servlet;

import javax.servlet.ServletException;
import javax.servlet.http.*;
import java.io.IOException;

public class getSession extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("utf-8");
        resp.setCharacterEncoding("utf-8");
        resp.setContentType("text/html;charset=utf-8");
        HttpSession session = req.getSession();
//        session.setMaxInactiveInterval(15);   设置存活时间
        session.setAttribute("name","feng");
        String id = session.getId();
        if(session.isNew()){
            resp.getWriter().write("session创建成功，ID为"+id);
        }else{
            resp.getWriter().write("session已经在服务器中存在了，ID为"+id);
        }
//        resp.addCookie(new Cookie("JSESSIONID",id));
//        req.getSession().removeAttribute("name");
//        req.getSession().invalidate();   去掉session在浏览器中的储存
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }
}
