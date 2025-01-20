package com.example.weblearning;

import jakarta.servlet.*;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.extern.java.Log;

import java.io.IOException;
import java.util.Enumeration;

//@Log
//@WebServlet("/test")
//public class TestServlet implements Servlet {
//
//
//
//    @Override
//    public void init(ServletConfig servletConfig) throws ServletException {
//
//    }
//
//    @Override
//    public ServletConfig getServletConfig() {
//
//        return null;
//    }
//
//    @Override
//    public void service(ServletRequest servletRequest, ServletResponse servletResponse) throws ServletException, IOException {
////        log.info("浏览器发起了一次请求");
////        log.info(servletRequest.getClass().getName());
////        log.info(servletResponse.getClass().getName());
//        HttpServletRequest request = (HttpServletRequest) servletRequest;
//
//        System.out.println(request.getProtocol());  //获取协议版本
//        System.out.println(request.getRemoteAddr());  //获取访问者的IP地址
//        System.out.println(request.getMethod());   //获取请求方法
//        //获取头部信息
//        Enumeration<String> enumeration = request.getHeaderNames();
//        while (enumeration.hasMoreElements()) {
//            String name = enumeration.nextElement();
//            System.out.println(name + ": " + request.getHeader(name));
//        }
//
//        HttpServletResponse response = (HttpServletResponse) servletResponse;
//        //设定内容类型以及编码格式（普通HTML文本使用text/html，之后会讲解文件传输）
//        response.setHeader("Content-type", "text/html;charset=UTF-8");
//        //获取Writer直接写入内容
//        response.getWriter().write("<h1>我是响应内容！</h1>");
//        //所有内容写入完成之后，再发送给浏览器
//    }
//
//    @Override
//    public String getServletInfo() {
//
//
//        return null;
//    }
//
//    @Override
//    public void destroy() {
//        System.out.println("我是destroy");
//
//    }
//}


//@Log
//@WebServlet(value = {"/test1", "/test2"},loadOnStartup = 1)
//public class TestServlet extends HttpServlet {
//    @Override
//    public void init() throws ServletException {
//
//        System.out.println("我被初始化了！");
//    }
//    @Override
//    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//         resp.setContentType("text/html;charset=UTF-8");
//        resp.getWriter().write("<h1>恭喜你解锁了全新玩法</h1>");
//    }
//}