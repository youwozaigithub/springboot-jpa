/**
 * Copyright (C), 2015-2019, 艾迪有限公司
 * FileName: TestCRUDRepository
 * Author:   Administrator
 * Date:     2019/2/12 20:33
 * Description: 演示crudRepository
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.aidy.UsersRepository;

import com.aidy.pojo.Users;
import org.springframework.data.repository.CrudRepository;

/**
 * 〈一句话功能简述〉<br> 
 * 〈演示crudRepository〉
 *
 * @author Administrator
 * @create 2019/2/12
 * @since 1.0.0
 */
public interface TestCRUDRepository extends CrudRepository<Users,Integer> {
}
