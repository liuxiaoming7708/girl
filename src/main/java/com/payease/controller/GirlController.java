package com.payease.controller;

import com.payease.domain.Girl;
import com.payease.domain.Result;
import com.payease.respository.GirlRespository;
import com.payease.service.GirlService;
import com.payease.utils.ResultUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

/**
 * 查询女生列表
 * Created by liuxiaoming on 2017/11/1.
 */
@RestController
//@RequestMapping("/hello")
public class GirlController {

    //日志
    private final static Logger logger = LoggerFactory.getLogger(GirlController.class);


    @Autowired
    private GirlRespository girlRespository;

    @GetMapping("/girls")
    public List<Girl> girlList(){
        logger.info("girlList方法！");
        return girlRespository.findAll();
    }







    /**
     * 创建一个女生
     */
    @PostMapping("/girls")
    public Result<Girl> girlAdd(@Valid Girl girl, BindingResult bindingResult){
        Result result = new Result();
        if(bindingResult.hasErrors()){
            return ResultUtil.error(1,bindingResult.getFieldError().getDefaultMessage());
        }
        girl.setCupSize(girl.getCupSize());
        girl.setAge(girl.getAge());
        return ResultUtil.success(girlRespository.save(girl));
    }


    @Autowired
    private GirlService girlService;

    @PostMapping("girls/two")
    public void girlTwo(){
        girlService.insertTwo();
    }

    /**
     * 通过ID查询一个女生
     */
    @PostMapping("/girls/{id}")
    public Girl getgirl(@PathVariable("id")Integer id){
        return girlRespository.findOne(id);
    }

    /**
     * 通过ID更新一个女生
     */
    @PutMapping("/girls/{id}")
    public Girl girlUpdate  (@PathVariable("id")Integer id,
                             @RequestParam("cupSize") String cupSize,
                             @RequestParam("age") Integer age){
        Girl girl = new Girl();
        girl.setId(id);
        girl.setCupSize(cupSize);
        girl.setAge(age);
        return girlRespository.save(girl);
    }

    /**
     * 通过ID删除一个女生
     */
    @DeleteMapping("/girls/{id}")
    public void girlDelete(@PathVariable("id")Integer id){
        girlRespository.delete(id);
    }

    /**
     * 通过年龄查询女生列表
     */
    @GetMapping("/girls/age/{age}")
    public List<Girl> girlListByAge(@PathVariable("age")Integer age){
        return girlRespository.findByAge(age);
    }

    /**
     * 通过ID判断该女生年龄是否符合要求
     * @param id
     * @throws Exception
     */
    @GetMapping("girls/getAge/{id}")
    public void getAge(@PathVariable("id")Integer id) throws Exception{

         girlService.getAge(id);
    }
}
