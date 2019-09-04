package cn.itcast.web.servlet;

import cn.itcast.service.UserService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @Author: badbad
 * @Date: 2019/9/4 12:30
 * @Version 1.0
 */
@WebServlet("/deleteSelect")
public class DelSelectServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        //1.设置编码
        request.setCharacterEncoding("utf-8");
        //2.获取参数
        String[] ids = request.getParameterValues("id");
        //3.调用service
        UserService userService = new UserService();
        userService.deletSelect(ids);

        //4.重定向
        response.sendRedirect(request.getContextPath()+"/list");
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }
}
