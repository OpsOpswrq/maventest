package com.feng.servlet;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

public class HelloServlet extends HttpServlet {
    public String message;
    @Override
    public void init() throws ServletException {
        message = "hello servlet";
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        PrintWriter printWriter = resp.getWriter();
        printWriter.println("<h1>"+message+"</h1>");
        ServletContext context = this.getServletContext();
        String name = "万仁棋";
        context.setAttribute("name",name);
        destroy();
    }

    @Override
    public void destroy() {
        System.out.println("destroyed");
    }
}
