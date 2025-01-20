package com.example.weblearning;

import com.example.weblearning.enetity.Users;
import com.example.weblearning.mapper.UserMapper;
import jakarta.servlet.Servlet;
import jakarta.servlet.ServletContext;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebInitParam;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;
import lombok.SneakyThrows;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.util.Arrays;
import java.util.Map;

@WebServlet(value = "/login",loadOnStartup = 1,initParams = {
        @WebInitParam(name="test",value="我是初始化参数！")
})
public class LogingServlet extends HttpServlet {
    SqlSessionFactory factory;
    @SneakyThrows
    @Override
    public void init() throws ServletException {
        factory=new SqlSessionFactoryBuilder().build(Resources.getResourceAsReader("mybatis-config.xml"));
        System.out.println(getInitParameter("test"));
//        System.out.println(getServletContext().getInitParameter("lbwnb"));
    }

    @Override
protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    Cookie[] cookies = req.getCookies();
    if(cookies != null){
        String username = null;
        String password = null;
        for (Cookie cookie : cookies) {
            if(cookie.getName().equals("username")) username = cookie.getValue();
            if(cookie.getName().equals("password")) password = cookie.getValue();
        }
        if(username != null && password != null){
            //登陆校验
            try (SqlSession sqlSession = factory.openSession(true)){
                UserMapper mapper = sqlSession.getMapper(UserMapper.class);
                Users user = mapper.getUser(username, password);
                if(user != null){
                    HttpSession session = req.getSession();
                    session.setAttribute("user", user);
                    resp.sendRedirect("time");
                    return;   //直接返回
                }else {
                    Cookie cookie_username = new Cookie("username", username);
                    cookie_username.setMaxAge(100);
                    Cookie cookie_password = new Cookie("password", password);
                    cookie_password.setMaxAge(100);
                    resp.addCookie(cookie_username);
                    resp.addCookie(cookie_password);
                }
                            }
        }
    }
    req.getRequestDispatcher("/").forward(req, resp);   //正常情况还是转发给默认的Servlet帮我们返回静态页面
}

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
         resp.setContentType("text/html;charset=UTF-8");
         Map<String, String[]> map = req.getParameterMap();
//        req.getParameterMap().forEach((k, v) -> {
//                System.out.println(k + ": " + Arrays.toString(v));
//            });
        if(map.containsKey("username") && map.containsKey("password")) {
        String username = req.getParameter("username");
        String password = req.getParameter("password");
        try (SqlSession session=factory.openSession(true)) {
            UserMapper userMapper=session.getMapper(UserMapper.class);
            Users user = userMapper.getUser(username, password);
            if(user!=null)
            {
//                resp.getWriter().write("用户"+username+",登录成功！");

//                resp.sendRedirect("time");

//                resp.setStatus(302);
//                resp.setHeader("Location", "https://www.baidu.com");

//                req.setAttribute("user", user);
//                req.getRequestDispatcher("/time").forward(req, resp);

//                getServletContext().setAttribute("test","我是全局数据！");
//                resp.sendRedirect("time");
//
//                ServletContext servletContext=getServletContext();
//                servletContext.getRequestDispatcher("/time").forward(req, resp);
//                Cookie cookie = new Cookie("test", "yyds");
//                cookie.setMaxAge(10);
                if(map.containsKey("remember-me")){   //若勾选了勾选框，那么会此表单信息
                    Cookie cookie_username = new Cookie("username", username);
                    cookie_username.setMaxAge(100);
                    Cookie cookie_password = new Cookie("password", password);
                    cookie_password.setMaxAge(100);
                    resp.addCookie(cookie_username);
                    resp.addCookie(cookie_password);
                }
                HttpSession session1=req.getSession();
                session1.setAttribute("user", user);


//                resp.addCookie(cookie);
                resp.sendRedirect("time");

            }else {
                resp.getWriter().write("您登陆的用户密码不正确或此用户不存在");
            }
        }

        //权限校验（待完善）
    }else {
        resp.getWriter().write("错误，您的表单数据不完整！");
    }
    }
}

