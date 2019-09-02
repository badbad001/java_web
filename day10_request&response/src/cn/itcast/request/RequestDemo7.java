package cn.itcast.request;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @Author: badbad
 * @Date: 2019/9/1 17:19
 * @Version 1.0
 *
 * 中文乱码，请求转发，request域
 */
@WebServlet("/requestDemo7")
public class RequestDemo7 extends HttpServlet {
    /**
     *
     * @param request
     * @param response
     * @throws ServletException
     * @throws IOException
     */
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        Object username = request.getAttribute("username");
        System.out.println("username = " + username);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
       this.doPost(request, response);

    }
}
