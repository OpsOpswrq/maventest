package com.feng.servlet;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.URLDecoder;
import java.net.URLEncoder;
import java.util.Date;

public class CookieGet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("utf-8");
        resp.setCharacterEncoding("utf-8");
        resp.setContentType("text/html;charset=utf-8");
        PrintWriter writer = resp.getWriter();
        Cookie[] cookies = req.getCookies();
        if (cookies.length != 0) {
            writer.write("你上一次访问该网站的时间为：");
            for (int i = 0; i < cookies.length; i++) {
//                cookies[i].setMaxAge(1);   设置cookie在浏览器的存活时间
                if (cookies[i].getName().equals("lastLoginTemp")) {
                    long l = Long.parseLong(cookies[i].getValue());
                    Date date = new Date(l);
                    writer.write("<br>"+"<h1>");
                    writer.write(String.valueOf(date));
                    writer.write("</h1>");
                }else if(cookies[i].getName().equals("name")){
                    writer.write("<br>"+"<h1>");
                    writer.write(URLDecoder.decode(cookies[i].getValue(),"utf-8"));
                    writer.write("</h1>");
                }
            }
        }else{
            writer.write("这是你第一次访问该网站");
        }
        resp.addCookie(new Cookie("lastLoginTemp", System.currentTimeMillis() + ""));
        resp.addCookie(new Cookie("name", URLEncoder.encode("万仁棋","utf-8")));
}

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }
}
