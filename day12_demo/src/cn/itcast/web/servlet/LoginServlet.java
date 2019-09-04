package cn.itcast.web.servlet;

import cn.itcast.pojo.User;
import cn.itcast.service.UserService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

/**
 * @Author: badbad
 * @Date: 2019/9/3 21:04
 * @Version 1.0
 */
@WebServlet("/login")
public class LoginServlet extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
         //1.设置编码
         request.setCharacterEncoding("utf-8");
         //2.获取参数
        String verifycode = request.getParameter("verifycode");
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        //3.判断验证码是否正确
        //3.1从session获取验证码
        HttpSession session = request.getSession();
        String checkcode_server = (String) session.getAttribute("CHECKCODE_SERVER");
        //3.1.1获取了验证码，立即移除验证码，作为一次性验证码
        session.removeAttribute("CHECKCODE_SERVER");
        //3.2如果验证码不正确不往下执行
        if (!checkcode_server.equalsIgnoreCase(verifycode)){
            request.setAttribute("login_msg","验证码不一样");
            request.getRequestDispatcher("/login.jsp").forward(request,response);
            return;
        }
        //4.验证码正确去查数据库
        UserService userService = new UserService();
        User existUser = userService.login(username, password);
        if (existUser != null){
            //4.1找到了用户,转发到主页
            session.setAttribute("user",existUser);
            response.sendRedirect(request.getContextPath()+"/index.jsp");
        }else {
            //4.2用户没有
            request.setAttribute("login_msg","用户名或者密码错误");
            request.getRequestDispatcher("/login.jsp").forward(request,response);
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }
}
