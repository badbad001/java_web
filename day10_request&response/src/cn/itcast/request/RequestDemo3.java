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
 * 获取请求头
 * 防盗链
 */
@WebServlet("/requestDemo3")
public class RequestDemo3 extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String referer = request.getHeader("Referer");
        System.out.println(referer);
        if (referer.contains("day10")){
            System.out.println("正常播放电影。。");
        }
    }
}
