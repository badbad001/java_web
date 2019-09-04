package cn.itcast.web.servlet;

import cn.itcast.pojo.PageBean;
import cn.itcast.pojo.User;
import cn.itcast.service.UserService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Map;

/**
 * @Author: badbad
 * @Date: 2019/9/4 14:09
 * @Version 1.0
 */
@WebServlet("/listByPage")
public class ListByPageServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        //0.设置编码
        request.setCharacterEncoding("utf-8");
        //1.获取参数
        String pageSize = request.getParameter("pageSize");
        String currPage = request.getParameter("currPage");

        if (pageSize == null || "".equals(pageSize)){
            pageSize = "5";
        }

        if (currPage == null || "".equals(currPage) || Integer.parseInt(currPage) < 0){
            currPage = "1";
        }

        //1.1获取条件查询参数
        Map<String, String[]> map = request.getParameterMap();


        //2.调用service
        UserService userService = new UserService();
        PageBean<User> pageBean=userService.listByPage(Integer.parseInt(currPage),Integer.parseInt(pageSize),map);

        //3.请求转发
        request.setAttribute("pageBean",pageBean);
        //把条件页添加进去
        request.setAttribute("map",map);
        request.getRequestDispatcher("/list.jsp").forward(request,response);

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }
}
