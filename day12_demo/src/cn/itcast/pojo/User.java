package cn.itcast.pojo;

import lombok.Data;

/**
 * @Author: badbad
 * @Date: 2019/9/3 20:39
 * @Version 1.0
 *
 * id INT PRIMARY KEY AUTO_INCREMENT,
 * 			NAME VARCHAR(20) NOT NULL,
 * 			gender VARCHAR(5),
 * 			age INT,
 * 			address VARCHAR(32),
 * 			qq	VARCHAR(20),
 * 			email VARCHAR(50),
 * 			username VARCHAR(32),
 * 	        PASSWORD VARCHAR(32)
 */
@Data
public class User {
    private Long id;
    private String name;
    private String gender;
    private Integer age;
    private String address;
    private String qq;
    private String email;
    private String username;
    private String password;
}
