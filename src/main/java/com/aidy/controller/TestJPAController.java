/**
 * Copyright (C), 2015-2019, 艾迪有限公司
 * FileName: TestJPAController
 * Author:   董帅
 * Date:     2019/2/11 22:29
 * Description:
 * History:
 * <董帅>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.aidy.controller;

import com.aidy.UsersRepository.UsersJPARepository;
import com.aidy.pojo.Users;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 〈一句话功能简述〉<br> 
 * 〈〉
 *
 * @author 董帅
 * @create 2019/2/11
 * @since 1.0.0
 */
@RestController
public class TestJPAController {

    @Autowired
    private UsersJPARepository usersJPARepository;
    @GetMapping("/save")
        public String save(){

        Users users = new Users();
        users.setAddress("北京市海淀");
        users.setAge(20);
        users.setName("张三");
        usersJPARepository.save(users);
        return "ok";
        }
}
