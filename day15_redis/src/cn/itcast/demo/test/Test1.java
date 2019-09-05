package cn.itcast.demo.test;

import cn.itcast.demo.dao.ProvinceDao;
import cn.itcast.demo.pojo.Province;
import org.junit.Test;

import java.util.List;

/**
 * @Author: badbad
 * @Date: 2019/9/5 20:00
 * @Version 1.0
 */
public class  Test1{

    @Test
    public void demo1(){
        ProvinceDao provinceDao = new ProvinceDao();
        List<Province> list = provinceDao.findAll();
        System.out.println(list);
    }
}
