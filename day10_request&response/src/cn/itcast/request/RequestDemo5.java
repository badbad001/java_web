package cn.itcast.request;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.BufferedReader;
import java.io.IOException;
import java.util.Map;

/**
 * @Author: badbad
 * @Date: 2019/9/1 17:19
 * @Version 1.0
 * 获取参数通用方法
 *
 */
@WebServlet("/requestDemo5")
public class RequestDemo5 extends HttpServlet {
    /**
     * 获取参数
     * @param request
     * @param response
     * @throws ServletException
     * @throws IOException
     */
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
         //1.根据name获取参数
        String username = request.getParameter("username");
        System.out.println("username = " + username);
        //2.根据name获取参数值，获取多个值，获取复选框的
        String[] hobbies = request.getParameterValues("hobby");
        for (String hobby : hobbies) {
            System.out.println(hobby);
        }
        //3.获取所有参数名字
        //4.把参数封装进map
        Map<String, String[]> map = request.getParameterMap();
        for (String key : map.keySet()) {
            String[] values = map.get(key);
            for (String value : values) {
                System.out.println(key +".." + value);
            }
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request,response);
    }
}
