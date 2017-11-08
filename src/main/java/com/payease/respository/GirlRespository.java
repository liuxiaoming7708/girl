package com.payease.respository;

import com.payease.domain.Girl;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * Created by liuxiaoming on 2017/11/6.
 */
public interface GirlRespository extends JpaRepository<Girl,Integer>{

    //条件查询： 通过年龄来查询
    public List<Girl> findByAge(Integer age);
}
