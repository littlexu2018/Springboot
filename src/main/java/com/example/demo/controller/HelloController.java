package com.example.demo.controller;

import com.example.demo.model.Girl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author: xuhh
 * @Description:
 * @Date: Created in 21:55 2018/12/26
 * @Modified By:
 */
@RestController
@Component
public class HelloController {

	@Value("${cpuSize}")
	private String cupSize;

	@Value("${age}")
	private Integer age;

	@Autowired
	private Girl girl;

	@RequestMapping(value = {"/hello","/hi"} , method = RequestMethod.GET)
	public String hello(){
		return cupSize+" "+age +" girl.age  "+girl.getName();
	}
}
