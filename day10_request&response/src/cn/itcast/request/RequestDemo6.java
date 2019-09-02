package cn.itcast.request;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.awt.*;
import java.io.BufferedReader;
import java.io.IOException;

/**
 * @Author: badbad
 * @Date: 2019/9/1 17:19
 * @Version 1.0
 *
 * 中文乱码，请求转发，request域
 */
@WebServlet("/requestDemo6")
public class RequestDemo6 extends HttpServlet {
    /**
     *
     * @param request
     * @param response
     * @throws ServletException
     * @throws IOException
     */
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        request.setCharacterEncoding("utf-8");

        String username = request.getParameter("username");

        request.setAttribute("username",username);

        request.getRequestDispatcher("/requestDemo7").forward(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
       this.doPost(request, response);

    }
}
