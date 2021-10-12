package com.seu.care.customer.service;

import com.github.pagehelper.PageInfo;
import com.seu.care.customer.model.CustomerIn;

public interface CustomerService {

    PageInfo<CustomerIn> listAll(Integer currPage);

    void add(CustomerIn customerIn);

    CustomerIn selById(Integer id);
}
