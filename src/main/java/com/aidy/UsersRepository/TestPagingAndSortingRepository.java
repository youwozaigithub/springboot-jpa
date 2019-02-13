/**
 * Copyright (C), 2015-2019, 艾迪有限公司
 * FileName: TestPagingAndSortingRepository
 * Author:   Administrator
 * Date:     2019/2/12 21:28
 * Description: 演示排序和分页
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.aidy.UsersRepository;

import com.aidy.pojo.Users;
import org.springframework.data.repository.PagingAndSortingRepository;

/**
 * 〈一句话功能简述〉<br> 
 * 〈演示排序和分页〉
 *
 * @author Administrator
 * @create 2019/2/12
 * @since 1.0.0
 */
public interface TestPagingAndSortingRepository extends PagingAndSortingRepository<Users,Integer> {
}
