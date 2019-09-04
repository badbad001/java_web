package cn.itcast.service;

import cn.itcast.dao.UserDao;
import cn.itcast.pojo.PageBean;
import cn.itcast.pojo.User;
import org.springframework.jdbc.core.BeanPropertyRowMapper;

import java.util.List;
import java.util.Map;

/**
 * @Author: badbad
 * @Date: 2019/9/3 20:46
 * @Version 1.0
 */
public class UserService {

    private UserDao userDao = new UserDao();


    public User login(String username,String password){
       return userDao.login(username,password);
    }


    public void add(User user){
        userDao.add(user);

    }


    public List<User> list(){
        return userDao.list();
    }

    public void delete(int id) {
        userDao.delete(id);
    }

    /**
     *
     * @param parseInt
     * @return
     */
    public User findById(int id) {
        return userDao.findByID(id);
    }

    public void update(User user) {
        userDao.update(user);
    }

    /**
     *
     * @param ids
     */
    public void deletSelect(String[] ids) {
        if (ids!=null && ids.length >0){
            for (String id : ids) {
                userDao.delete(Integer.parseInt(id));
            }
        }
    }

    /**
     *
     * @param currPage
     * @param pageSize
     * @param map
     * @return
     */
    public PageBean<User> listByPage(Integer currPage, Integer pageSize, Map<String, String[]> map) {
        //1.查询总条数
        int totalCount = userDao.findTotalCount(map);
        //2.查询数据
        List<User> list=userDao.listByPage(currPage,pageSize,map);

        return new PageBean<User>(currPage,pageSize,totalCount,list);
    }
}
