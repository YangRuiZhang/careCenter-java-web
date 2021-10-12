package com.seu.care.customer.controller;

import com.github.pagehelper.PageInfo;
import com.seu.care.customer.model.CustomerIn;
import com.seu.care.customer.service.CustomerService;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
@RequestMapping("/customer")
public class CustomerController {

    @Resource
    private CustomerService customerService;

    @RequestMapping("listAll/{currPage}")
    public PageInfo<CustomerIn> listAll(@PathVariable Integer currPage){
        return customerService.listAll(currPage);
    }

    @RequestMapping("add")
    public String add(@RequestBody CustomerIn customerIn){
        customerService.add(customerIn);
        //调用微服务修改床位为已占用

        return "succ";
    }

    @RequestMapping("selById/{id}")
    public CustomerIn selById(@PathVariable Integer id){
       return customerService.selById(id);
    }
}
