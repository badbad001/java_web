package cn.itcast.xml.jsoup;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.net.URL;

/**
 * @Author: badbad
 * @Date: 2019/8/31 17:30
 * @Version 1.0
 */
public class JsoupDemo3 {
    public static void main(String[] args) throws IOException {
        //2.获取xml文件路径
        //获取的是运行时的class编译后的文件
        String path = JsoupDemo3.class.getClassLoader().getResource("student.xml").getPath();
        System.out.println(path); //获取path的string形式
        //3.获取doument   就是把编译后的文件，写进内存来操作
        URL url = new URL("https://www.baidu.com");
        Document document = Jsoup.parse(url, 10000);
        System.out.println(document);
        //4.根据节点获取
        Elements eles = document.getElementsByTag("name");
        System.out.println(eles.size());
        System.out.println(eles.get(0));
        System.out.println(eles.get(0).text());
    }
}
