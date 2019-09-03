package cn.itcast.servlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

/**
 * @Author: badbad
 * @Date: 2019/9/3 11:52
 * @Version 1.0
 */
@WebServlet("/login")
public class LoginServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        //1.设置编码
        request.setCharacterEncoding("utf-8");
        response.setContentType("text/html;charset=utf-8");
        //2.获取三个para
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        String checkCode = request.getParameter("checkCode");
        //3.判断验证码是否正确先
        //3.1获取session的check_code
        HttpSession session = request.getSession();
        String check_code = (String) session.getAttribute("check_code");
        if (check_code != null){
            //3.1.1不为空，立即移除验证码，为一次性验证码
            session.removeAttribute("check_code");
            if (check_code.equalsIgnoreCase(checkCode)){
                 //3.2如果验证码正确，再判断是否用户密码正确
                if (username.equals("leijun")&&password.equals("123")){
                    session.setAttribute("username",username);
                    //3.2.1请求转发
                    response.sendRedirect("/day11/success.jsp");
                }else {//3.2.2用户密码不正确
                    request.setAttribute("login_error","用户名或者密码错误");
                    request.getRequestDispatcher("/login.jsp").forward(request,response);
                }
            }else {
                //3.3验证码不正确
                //转发回登陆页面，设置request域的一些值
                request.setAttribute("cc_error","验证码错误");
                request.getRequestDispatcher("/login.jsp").forward(request,response);
            }
        }

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }
}
