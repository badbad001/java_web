package cn.itcast.cookie;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.net.URLDecoder;
import java.net.URLEncoder;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @Author: badbad
 * @Date: 2019/9/2 20:22
 * @Version 1.0
 */
@WebServlet("/cookieTest")
public class CookieTest extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //1.告诉浏览器,响应消息体的编码格式和数据类型
        response.setContentType("text/html;charset=utf-8");
        //2.获取cookie
        Cookie[] cookies = request.getCookies();
        boolean flag = false;//如果没有lastTimeCookie
        //3.遍历cookie
        if (cookies!=null && cookies.length>0){
            for (Cookie cookie : cookies) {
                //4.如果cookie不为空，且有lastName
                if (cookie.getName().equals("lastTime")){
                    flag = true;
                    //4.0先获取原来的旧value
                    String oldDateStr = cookie.getValue();
                    //4.1重新设置事件覆盖旧时间
                    Date date = new Date();
                    SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
                    String dateStr = sdf.format(date);
                    //4.2把时间用url编码解决特殊字符报错问题
                    dateStr = URLEncoder.encode(dateStr, "utf-8");
                    //4.3覆盖原来cookie的值
                    cookie.setValue(dateStr);
                    cookie.setMaxAge(60*60*24);

                    response.addCookie(cookie);
                    System.out.println(cookie.getValue());
                    //4.4把旧的时间解码再发回客户端
                    oldDateStr = URLDecoder.decode(oldDateStr,"utf-8");
                    response.getWriter().write("欢迎回来，上次访问事件是"+oldDateStr);

                }
            }
        }

        //5如果没有这个cookie或者cookie长度为0，或者没有lastTime
        if (cookies == null || cookies.length == 0 || flag == false){
            //5.1创建cookie,且url编码再放进cookie
            Date date = new Date();
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            String dateStr = sdf.format(date);
            dateStr = URLEncoder.encode(dateStr,"utf-8");
            Cookie cookie = new Cookie("lastTime", dateStr);
            //5.3设置cookie时间
            cookie.setMaxAge(60*60*24);
            //5.4把cookie写回去
            response.addCookie(cookie);
            //5.5写信息回去说第一次
            response.getWriter().write("第一次登陆");

        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }
}
