package com.feng.servlet;

import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.FileInputStream;
import java.io.IOException;

public class getPicture extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String realPath = this.getServletContext().getRealPath("/WEB-INF/classes/1.jpg");//这个路径十分重要
        String name = realPath.substring(realPath.lastIndexOf("/") + 1);
        resp.setHeader("Content-Disposition","attachment;filename="+name);
        //文件流的操作
        FileInputStream fileInputStream = new FileInputStream(realPath);
        int len = 0;
        byte[] bytes = new byte[1024];
//        如果要写字节，比如，传个图片，怎么办呢？就要靠response.getOutputStream();
        ServletOutputStream outputStream = resp.getOutputStream();
        //fileInputStream的read方法可以读取字节流
        while((len=fileInputStream.read(bytes))!=-1){// 这里可以重写数组的内容
            outputStream.write(bytes,0,len);
        }
        fileInputStream.close();
        outputStream.close();
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }
}
