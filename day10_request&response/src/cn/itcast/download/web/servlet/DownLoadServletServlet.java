package cn.itcast.download.web.servlet;

import cn.itcast.download.utlis.DownLoadUtils;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.FileInputStream;
import java.io.IOException;

/**
 * @Author: badbad
 * @Date: 2019/9/2 12:48
 * @Version 1.0
 *
 * 重定向
 */
@WebServlet("/download")
public class DownLoadServletServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //1.获取请求参数
        request.setCharacterEncoding("utf-8");
        String fileName = request.getParameter("fileName");
        //2.根据传来的fileName获取真实路径
        ServletContext context = request.getServletContext();
        String realPath = context.getRealPath("/img/" + fileName);
        //3.创建文件输入流读文件
        FileInputStream fis = new FileInputStream(realPath);
        //4.设置响应头
        //4.1设置mietype
        response.setContentType(context.getMimeType(fileName));
        //4.2解决文件名中文乱码
        fileName=DownLoadUtils.getFileName(request.getHeader("user-agent"),fileName);
        //4.3以附件形式下载图片
        response.setHeader("content-disposition","attachment;filename="+fileName);

        //5.把输入流写到响应字节流
        ServletOutputStream sos = response.getOutputStream();
        byte[] bytes = new byte[1024];
        int len;
        while ((len = fis.read(bytes)) != -1){
            sos.write(bytes,0,len);
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request,response);
    }
}
