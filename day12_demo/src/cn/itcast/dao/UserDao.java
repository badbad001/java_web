package cn.itcast.dao;

import cn.itcast.pojo.User;
import cn.itcast.utils.JDBCUtils;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

/**
 * @Author: badbad
 * @Date: 2019/9/3 20:45
 * @Version 1.0
 */
public class UserDao {

    private JdbcTemplate jdbcTemplate = new JdbcTemplate(JDBCUtils.getDataSource());

    /**
     * 登陆
     * @param username
     * @param password
     * @return
     */
    public User login(String username,String password){
        try {
            String sql = "select * from user where username = ? and password = ?";
            User user = jdbcTemplate.queryForObject(sql,
                    new BeanPropertyRowMapper<>(User.class), username, password);
            return user;
        } catch (DataAccessException e) {
            e.printStackTrace();
            return null;
        }
    }

    /**
     * 查询所有
     * @return
     */
    public List<User> list(){
        String sql = "select * from user";
        return jdbcTemplate.query(sql, new BeanPropertyRowMapper<>(User.class));
    }

    /**
     * 添加用户
     * @param user
     */
    public void add(User user){
        String sql = "insert into user values(null,?,?,?,?,?,?,null,null)";
        /**
         * id INT PRIMARY KEY AUTO_INCREMENT,
         * 			NAME VARCHAR(20) NOT NULL,
         * 			gender VARCHAR(5),
         * 			age INT,
         * 			address VARCHAR(32),
         * 			qq	VARCHAR(20),
         * 			email VARCHAR(50),
         * 			username VARCHAR(32),
         * 	                PASSWORD VARCHAR(32)
         */
        jdbcTemplate.update(sql,user.getName(),user.getGender(),user.getAge(),
                user.getAddress(), user.getQq(),user.getEmail()
        );
    }

    /**
     * 删除
     * @param id
     */
    public void delete(int id) {
        String sql = "delete from user where id = ?";
        jdbcTemplate.update(sql,id);
    }

    /**
     *
     * @param id
     * @return
     */
    public User findByID(int id) {
        String sql = "select * from user where id = ?";
        return jdbcTemplate.queryForObject(sql,new BeanPropertyRowMapper<>(User.class),id);
    }

    public void update(User user) {
        /**
         * id INT PRIMARY KEY AUTO_INCREMENT,
         * 			NAME VARCHAR(20) NOT NULL,
         * 			gender VARCHAR(5),
         * 			age INT,
         * 			address VARCHAR(32),
         * 			qq	VARCHAR(20),
         * 			email VARCHAR(50),
         * 			username VARCHAR(32),
         * 	                PASSWORD VARCHAR(32)
         */
        String sql = "update user set name = ?,gender = ?,age = ?,address = ?,qq = ?,email = ? where id = ?";

        jdbcTemplate.update(sql,user.getName(),user.getGender(),user.getAge(),
                user.getAddress(), user.getQq(),user.getEmail(),user.getId());
    }

    /**
     *查询总条数
     * @return
     * @param map
     */
    public int findTotalCount(Map<String, String[]> map) {
        //1.编写root sql
        String sql = "select count(*) from user where 1=1 ";
        StringBuilder sb = new StringBuilder(sql);
        //2.遍历map拼接sql
        ArrayList<Object> params = new ArrayList<>();
        for (String key : map.keySet()) {
            //2.1如果是当前页数和pageSize，就continue
            if (key.equals("pageSize") || key.equals("currPage")){
                continue;
            }
            sb.append(" and "+key+" like ? ");
            //放value进来
            params.add("%"+map.get(key)[0]+"%");
        }
        sql =  sb.toString();
        System.out.println(sql);
        System.out.println(Arrays.toString(params.toArray()));

        return jdbcTemplate.queryForObject(sql,Long.class,params.toArray()).intValue();
    }

    /**
     *查询list
     * @param currPage
     * @param pageSize
     * @param map
     * @return
     */
    public List<User> listByPage(Integer currPage, Integer pageSize, Map<String, String[]> map) {
        String sql = "select * from user where 1=1 ";  //limit ?,?

        StringBuilder sb = new StringBuilder(sql);
        //2.遍历map拼接sql
        ArrayList<Object> params = new ArrayList<>();
        for (String key : map.keySet()) {
            //2.1如果是当前页数和pageSize，就continue
            if (key.equals("pageSize") || key.equals("currPage")){
                continue;
            }
            sb.append(" and "+key+" like ? ");
            //放value进来
            params.add("%"+map.get(key)[0]+"%");
        }
        //3.添加分页的sql和参数
        sb.append(" limit ?,? ");
        sql =  sb.toString();
        params.add((currPage-1)*pageSize);
        params.add(pageSize);

        System.out.println(sql);
        System.out.println(Arrays.toString(params.toArray()));

        return jdbcTemplate.query(sql,
                new BeanPropertyRowMapper<>(User.class),
                params.toArray());
    }
}
