package cn.itcast.demo.web.servlet;

import cn.itcast.demo.pojo.Province;
import cn.itcast.demo.service.ProvinceService;
import cn.itcast.demo.utils.JedisUtils;
import com.fasterxml.jackson.databind.ObjectMapper;
import redis.clients.jedis.Jedis;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

/**
 * @Author: badbad
 * @Date: 2019/9/5 19:39
 * @Version 1.0
 */
@WebServlet("/findAll")
public class ProvinceServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
         //1.从jedis获取province
        Jedis jedis = JedisUtils.getJedis();
        String province = jedis.get("province");
        //2.判断是否为空
        //2.1如果为空说明缓存没东西
        if (province == null || "".equals(province)){
            //2.2去数据库查
            ProvinceService provinceService = new ProvinceService();
            List<Province> list = provinceService.findAll();
            //2.3把数据变为json写进缓存
            ObjectMapper mapper = new ObjectMapper();
            province = mapper.writeValueAsString(list);
            jedis.set("province",province);
            System.out.println("从数据库拿。。");
        }else {
            System.out.println("从缓存拿。。");
        }

        //3.拿到数据写回页面
        response.setContentType("application/json;charset=utf-8");
        response.getWriter().write(province);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }
}
