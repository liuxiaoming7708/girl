package com.payease.service;

import com.payease.domain.Girl;
import com.payease.enums.ResultEnum;
import com.payease.exception.GirlException;
import com.payease.respository.GirlRespository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by liuxiaoming on 2017/11/7.
 */
@Service
public class GirlService {

    @Autowired
    private GirlRespository girlRespository;

    @Transactional
    public void insertTwo(){
        Girl girlA = new Girl();
        girlA.setCupSize("A");
        girlA.setAge(18);
        girlRespository.save(girlA);

        Girl girlB = new Girl();
        girlB.setCupSize("BBBB");
        girlB.setAge(20);
        girlRespository.save(girlB);
    }

    public void getAge(Integer id) throws Exception{
        Girl girl = girlRespository.findOne(id);
        Integer age = girl.getAge();
        if(age < 10){
            //返回 "你还在上小学吧" code=100
            throw new GirlException(ResultEnum.PRIMARY_SCHOOL);
        }else if(age > 10 && age < 16){
            //返回 "你可能在上初中" code=101
            throw new GirlException(ResultEnum.MIDDLE_SCHOOL);
        }
        //如果>16岁，加钱
        //...
    }

    /**
     * 通过ID查询一个女生的信息
     * @param id
     * @return
     */
    public Girl findOne(Integer id){
        return girlRespository.findOne(id);
    }
}