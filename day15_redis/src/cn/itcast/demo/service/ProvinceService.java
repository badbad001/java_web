package cn.itcast.demo.service;

import cn.itcast.demo.dao.ProvinceDao;
import cn.itcast.demo.pojo.Province;

import java.util.List;

/**
 * @Author: badbad
 * @Date: 2019/9/5 19:38
 * @Version 1.0
 */
public class ProvinceService {
    private ProvinceDao provinceDao = new ProvinceDao();

    public List<Province> findAll(){
        return provinceDao.findAll();
    }
}
