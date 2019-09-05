package cn.itcast.demo.dao;

import cn.itcast.demo.pojo.Province;
import cn.itcast.demo.utils.JDBCUtils;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.List;

/**
 * @Author: badbad
 * @Date: 2019/9/5 19:36
 * @Version 1.0
 */
public class ProvinceDao {
    private JdbcTemplate jdbcTemplate = new JdbcTemplate(JDBCUtils.getDataSource());

    public List<Province> findAll(){
        String sql = "select * from province";
        return jdbcTemplate.query(sql,new BeanPropertyRowMapper<>(Province.class));
    }
}
