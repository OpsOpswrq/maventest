package com.feng.Filter;

import com.feng.util.Constant;

import javax.servlet.*;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class FilterShow implements Filter {

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
//        ServletRequest(父类)   ServletResponse HttpServletRequest(子类)  HttpServletResponse
        HttpServletRequest req= (HttpServletRequest) servletRequest;
        HttpServletResponse resp = (HttpServletResponse) servletResponse;
        if(req.getSession().getAttribute(Constant.USERNAME)==null){
            resp.sendRedirect("../error.jsp");
        }
        filterChain.doFilter(req,resp);   // 开启下面的操作，这个很重要
    }

    @Override
    public void destroy() {

    }
}
