/**
 * Copyright (C), 2015-2019, 艾迪有限公司
 * FileName: TestJpa
 * Author:   董帅
 * Date:     2019/2/11 21:13
 * Description:
 * History:
 * <董帅>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.aidy.test;

/**
 * 〈一句话功能简述〉<br>
 * 〈〉
 *
 * @author 董帅
 * @create 2019/2/11
 * @since 1.0.0
 */

        import com.aidy.SpringbootJpaApplication;
        import com.aidy.UsersRepository.TestCRUDRepository;
        import com.aidy.UsersRepository.TestPagingAndSortingRepository;
        import com.aidy.UsersRepository.UsersJPARepository;
        import com.aidy.UsersRepository.UsersRepository;
        import com.aidy.pojo.Users;
        import org.junit.Test;
        import org.junit.runner.RunWith;
        import org.springframework.beans.factory.annotation.Autowired;
        import org.springframework.boot.test.context.SpringBootTest;
        import org.springframework.data.domain.Page;
        import org.springframework.data.domain.PageRequest;
        import org.springframework.data.domain.Sort;
        import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

        import java.util.ArrayList;
        import java.util.List;
        import java.util.Optional;


/**
 * 测试类
 *
 *
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = SpringbootJpaApplication.class)
public class TestJpa {

    @Autowired
    private UsersJPARepository usersJPARepository;

    @Autowired
    private UsersRepository usersRepository;

    @Autowired
    private TestCRUDRepository testCRUDRepository;

    @Autowired
    private TestPagingAndSortingRepository testPagingAndSortingRepository;
    @Test
    public void testSave() {

        Users users = new Users();
        users.setAddress("北京市海淀");
        users.setAge(20);
        users.setName("张三");
        usersJPARepository.save(users);
    }

    /**
     * 测试repository接口----通过方法名查询
     */
    @Test
    public void testFindByName() {
        List<Users> list = usersRepository.findByName("张三");
        for (Users users : list) {
            System.out.println(users);
        }
    }

    @Test
    public void testFindByNameAndAge() {
        List<Users> list = usersRepository.findByNameAndAge("张三",20);
        for (Users users : list) {
            System.out.println(users);
        }
    }

    @Test
    public void testFindByNameLike() {
        List<Users> list = usersRepository.findByNameLike("张%");
        for (Users users : list) {
            System.out.println(users);
        }
    }
    /**
     * 测试repository接口----通过@query查询
     */
    @Test
    public void testFindUsersWithHql() {
        List<Users> list = usersRepository.findUsersWithHql("张三",20);
        for (Users users : list) {
            System.out.println("hql"+users);
        }
    }

    @Test
    public void testFindUsersWithSql() {
        List<Users> list = usersRepository.findUsersWithSql("张三");
        for (Users users : list) {
            System.out.println("sql"+users);
        }
    }
    /**
     * 演示crudRepository
     */
    @Test
    public void testcrudRepositorySave() {
        Users user = new Users();
        user.setAddress("天津");
        user.setAge(32);
        user.setName("张三丰");
        testCRUDRepository.save(user);
    }

    @Test
    public void testcrudRepositoryUpdate() {
        Users user = new Users();
        user.setId(4);
        user.setAddress("天津12");
        user.setAge(32);
        user.setName("张三丰13");
        testCRUDRepository.save(user);
    }

    @Test
    public void testcrudRepositoryFindAll() {
        List<Users> all = (List<Users>) testCRUDRepository.findAll();
        for(Users user : all){
            System.out.println(user);
        }}

    @Test
    public void testcrudRepositoryFindById() {
        Optional<Users> user = testCRUDRepository.findById(4);
        if(user.isPresent()){
            System.out.println(user.get());
        }
    }

    @Test
    public void testcrudRepositoryDelete() {
        testCRUDRepository.deleteById(4);
    }

    @Test//删除所有对象,参数为对象集合
    public void testcrudRepositoryDeleteAll() {
        List<Users> all = (List<Users>) testCRUDRepository.findAll();
        testCRUDRepository.deleteAll(all);
    }

    /**
     * 演示pagingAndSortingRepository
     *只能针对所有数据进行排序,分页
     * 排序
     */
    @Test
    public void testSorting() {
        List<Users> list = (List<Users>) testPagingAndSortingRepository.findAll(new Sort(new Sort.Order(Sort.Direction.DESC, "id")));
        for(Users user : list){
            System.out.println(user);
        }
    }

    @Test
    public void testPaging() {
        Page<Users> page = testPagingAndSortingRepository.findAll(new PageRequest(0, 1));
        System.out.println("总记录数" + page.getTotalElements());
        System.out.println("总页数" + page.getTotalPages());
        List<Users> list = page.getContent();
        for (Users user : list) {
            System.out.println(user);
        }
    }

    @Test
    public void testPagingAndSorting() {
        Page<Users> page = testPagingAndSortingRepository.findAll(new PageRequest(0, 1));
        System.out.println("总记录数" + page.getTotalElements());
        System.out.println("总页数" + page.getTotalPages());
        List<Users> list = page.getContent();
        for (Users user : list) {
            System.out.println(user);
        }
    }

    /**
     * 测试jparepository
     * 排序啊啊啊1222
     */
    @Test
    public void testSortingByJpa() {
        List<Users> list =  usersJPARepository.findAll(new Sort(new Sort.Order(Sort.Direction.DESC, "id")));
        for(Users user : list){
            System.out.println(user);
        }
    }
}
