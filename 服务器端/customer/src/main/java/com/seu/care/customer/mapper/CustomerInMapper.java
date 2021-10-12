package com.seu.care.customer.mapper;

import com.seu.care.customer.model.CustomerIn;
import java.util.List;

public interface CustomerInMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(CustomerIn record);

    CustomerIn selectByPrimaryKey(Integer id);

    List<CustomerIn> selectAll();

    int updateByPrimaryKey(CustomerIn record);
}