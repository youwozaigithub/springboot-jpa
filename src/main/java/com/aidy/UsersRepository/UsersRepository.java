/**
 * Copyright (C), 2015-2019, 艾迪有限公司
 * FileName: UsersRepository
 * Author:   Administrator
 * Date:     2019/2/11 23:05
 * Description: 演示repository方法名查询
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.aidy.UsersRepository;

import com.aidy.pojo.Users;
import org.apache.catalina.User;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.Repository;

import java.util.List;

/**
 * 〈一句话功能简述〉<br> 
 * 〈演示repository方法名查询〉
 *
 * @author Administrator
 * @create 2019/2/11
 * @since 1.0.0
 */
public interface UsersRepository extends Repository<Users,Integer> {
//根据方法名查询
    List<Users>  findByName(String name);

    List<Users>  findByNameAndAge(String name,Integer age);

    List<Users>  findByNameLike(String name);
    //根据注解@query查询
    @Query("from Users where name = ?1 and age=?2")
    List<Users> findUsersWithHql(String name,Integer age);

    @Query(value = "select * from t_users where name = ?1",nativeQuery = true)
    List<Users> findUsersWithSql(String name);
}
