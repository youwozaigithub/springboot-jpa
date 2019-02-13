/**
 * Copyright (C), 2015-2019, 艾迪有限公司
 * FileName: UsersJPARepository
 * Author:   Administrator
 * Date:     2019/2/11 21:10
 * Description:
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.aidy.UsersRepository;

import com.aidy.pojo.Users;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.support.JpaEntityInformation;

import java.util.List;
import java.util.Optional;

/**
 * 〈一句话功能简述〉<br> 
 * 〈〉
 *
 * @author Administrator
 * @create 2019/2/11
 * @since 1.0.0
 */
/**
 * 参数一 T :当前需要映射的实体
 * 参数二 ID :当前映射的实体中的OID的类型
 *
 */
public interface UsersJPARepository extends JpaRepository<Users,Integer> {
    @Override
    List<Users> findAll();

    @Override
    List<Users> findAll(Sort sort);

    @Override
    List<Users> findAllById(Iterable<Integer> iterable);

    @Override
    <S extends Users> List<S> saveAll(Iterable<S> iterable);

    @Override
    void flush();

    @Override
    <S extends Users> S saveAndFlush(S s);

    @Override
    void deleteInBatch(Iterable<Users> iterable);

    @Override
    void deleteAllInBatch();

    @Override
    Users getOne(Integer integer);

    @Override
    <S extends Users> List<S> findAll(Example<S> example);

    @Override
    <S extends Users> List<S> findAll(Example<S> example, Sort sort);

    @Override
    Page<Users> findAll(Pageable pageable);

    @Override
    <S extends Users> S save(S s);

    @Override
    Optional<Users> findById(Integer integer);

    @Override
    boolean existsById(Integer integer);

    @Override
    long count();

    @Override
    void deleteById(Integer integer);

    @Override
    void delete(Users users);

    @Override
    void deleteAll(Iterable<? extends Users> iterable);

    @Override
    void deleteAll();

    @Override
    <S extends Users> Optional<S> findOne(Example<S> example);

    @Override
    <S extends Users> Page<S> findAll(Example<S> example, Pageable pageable);

    @Override
    <S extends Users> long count(Example<S> example);

    @Override
    <S extends Users> boolean exists(Example<S> example);
}