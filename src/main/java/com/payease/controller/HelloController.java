package com.payease.controller;

import com.payease.properties.GirlProperties;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * Created by liuxiaoming on 2017/11/1.
 */
@RestController
@RequestMapping("/hello")
public class HelloController {

   @Autowired
   private GirlProperties girlProperties;

    @GetMapping({"/say","/hi"})
    //@RequestMapping(value={"hello","hi"},method = RequestMethod.GET)
    public String say(@RequestParam(value = "id", required = false, defaultValue = "0")Integer myid){
        //return girlProperties.toString();
        return "id:"+myid;
    }
}
