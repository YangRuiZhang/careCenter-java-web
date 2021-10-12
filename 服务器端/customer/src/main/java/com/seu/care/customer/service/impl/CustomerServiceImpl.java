package com.seu.care.customer.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.netflix.discovery.converters.Auto;
import com.seu.care.customer.client.BedClient;
import com.seu.care.customer.mapper.CustomerInMapper;
import com.seu.care.customer.model.Bed;
import com.seu.care.customer.model.CustomerIn;
import com.seu.care.customer.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomerServiceImpl implements CustomerService{

    @Autowired
    private CustomerInMapper customerInMapper;

    @Autowired
    private BedClient bedClient;

    @Override
    public PageInfo<CustomerIn> listAll(Integer currPage) {
        PageHelper.startPage(currPage,5);
        PageInfo<CustomerIn> pageInfo = new PageInfo<>(customerInMapper.selectAll());
        //取出所有入住信息
        List<CustomerIn> list = pageInfo.getList();
        for(CustomerIn customerIn: list){//遍历每一个入住客户
            //调用bed微服务根据床位ID查询床位信息
            customerIn.setBed(bedClient.selById(customerIn.getBedId()));
        }
        return pageInfo;
    }

    @Override
    public void add(CustomerIn customerIn) {
        customerInMapper.insert(customerIn);
        //调用bed微服务根据床位ID取出床位信息
        Bed bed = bedClient.selById(customerIn.getBedId());
        bed.setBedStatus("已占用");
        //调用bed微服务更新床位状态
        bedClient.update(bed);
    }

    @Override
    public CustomerIn selById(Integer id) {
        return customerInMapper.selectByPrimaryKey(id);
    }
}
