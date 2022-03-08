package com.feng.Listener;


import com.feng.util.Constant;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

public class ListenerShow implements HttpSessionListener {

    @Override
    public void sessionCreated(HttpSessionEvent se) {
        ServletContext servletContext = se.getSession().getServletContext();
        Integer online = (Integer) servletContext.getAttribute(Constant.ONLINECOUNT);
        if(online==null){
            online = new Integer(1);
        }else{
            online = new Integer(online.intValue()+1);
        }
        servletContext.setAttribute(Constant.ONLINECOUNT,online.intValue());
    }

    @Override
    public void sessionDestroyed(HttpSessionEvent se) {
        ServletContext servletContext = se.getSession().getServletContext();
        Integer online = (Integer) servletContext.getAttribute(Constant.ONLINECOUNT);
        if(online==null){
            online = new Integer(0);
        }else{
            online = new Integer(online.intValue()-1);
        }
        servletContext.setAttribute(Constant.ONLINECOUNT,online.intValue());
    }
}
