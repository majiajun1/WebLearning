package com.example.weblearning;


import com.example.weblearning.enetity.Users;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;

@WebServlet("/time")
public class TimeServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

//
//        req.getParameterMap().forEach((k, v) -> {
//                System.out.println(k + ": " + Arrays.toString(v));
//            });
//        System.out.println(getServletContext().getAttribute("test"));

        HttpSession session = req.getSession();
        Users user = (Users) session.getAttribute("user");
//        if (user == null) {
//            resp.sendRedirect("login");
////            return;
//        }

//    if(req!=null){
//        for (Cookie cookie : req.getCookies()) {
//    System.out.println(cookie.getName() + ": " + cookie.getValue());
//}}

        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy年MM月dd日 HH:mm:ss");
        String date = dateFormat.format(new Date());
        resp.setContentType("text/html;charset=UTF-8");
        resp.getWriter().write(date);
    }


    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        Users user=(Users)req.getAttribute("user");
        resp.setContentType("text/html;charset=UTF-8");
//        resp.getWriter().write(user.getUsername()+"登录成功");
        resp.getWriter().write("登录成功");
    }
}