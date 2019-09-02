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
 * 获取请求行
 */
@WebServlet("/requestDemo1")
public class RequestDemo1 extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
         //1.获取请求方法
        String method = request.getMethod();
        System.out.println("method = " + method);
        //2.获取虚拟路径
        String contextPath = request.getContextPath();
        System.out.println("contextPath = " + contextPath);
        //3.获取servelt的路径
        String servletPath = request.getServletPath();
        System.out.println("servletPath = " + servletPath);
        //4.获取全路径
        String requestURI = request.getRequestURI();
        System.out.println("requestURI = " + requestURI);
        StringBuffer requestURL = request.getRequestURL();
        System.out.println("requestURL = " + requestURL);
        //5.获取请求参数
        String queryString = request.getQueryString();
        System.out.println("queryString = " + queryString);
        //6.获取请求的主机
        String remoteAddr = request.getRemoteAddr();
        System.out.println("remoteAddr = " + remoteAddr);
        //7.获取请求的协议版本
        String protocol = request.getProtocol();
        System.out.println("protocol = " + protocol);
    }
}
