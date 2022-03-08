package com.feng.servlet;

import javax.imageio.ImageIO;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.Random;

public class DynamicPic extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setHeader("Refresh", "3");//设置自动更新
        BufferedImage bufferedImage = new BufferedImage(80, 20, BufferedImage.TYPE_INT_RGB);//设置BufferedImage类型
        Graphics2D graphics = (Graphics2D) bufferedImage.getGraphics();//获得画笔
        graphics.setColor(Color.white);
        graphics.fillRect(0, 0, 80, 20);
        graphics.setColor(Color.BLUE);
        graphics.setFont(new Font(null, Font.ITALIC, 20));
        graphics.drawString(makenum(), 0, 20);//开始画画
        resp.setContentType("image/jpg");//设置内容的给格式
        resp.setDateHeader("Expires", 0);//不要缓存
        resp.setHeader("Cache-Control", "no-store");//要缓存，和下面的有区别
        resp.setHeader("Pragma", "no-cache");
        ImageIO.write(bufferedImage, "jpg", resp.getOutputStream());//ImageIo将图片信息传到网页上
    }
    private String makenum(){
        Random random = new Random();
        String s = random.nextInt(9999999) + "";
        for(int i = 0;i<7-s.length();i++){
            s+="0";
        }
        return s;
    }
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }
}
