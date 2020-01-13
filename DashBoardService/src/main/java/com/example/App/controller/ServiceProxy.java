package com.example.App.controller;

import java.util.Collection;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.cloud.netflix.ribbon.RibbonClient;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.App.domain.model.EmployeeInfo;

//@EnableFeignClients
@FeignClient(url = "http://localhost:8080", name = "EmployeeSearch")
@RibbonClient(name = "EmployeeSearch")
public interface ServiceProxy {
	@RequestMapping("/employee/find/{id}")
	public EmployeeInfo findById(@PathVariable(value = "id") Long id);

	@RequestMapping("/employee/findall")
	public Collection<EmployeeInfo> findAll();
}