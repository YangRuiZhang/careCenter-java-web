package com.seu.care.customer.client;

import com.seu.care.customer.model.Bed;
import org.checkerframework.common.reflection.qual.GetMethod;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * 声明需要哪个微服务，哪些controller的方法
 *  @GetMapping("/bed/selById/{id}")
 *  Bed selById(@PathVariable("id") Integer id);
 *  调用bed微服务/bed/selById/{id}这个controller方法,根据id号查询床位信息
 * name: 需要调用的微服务的名字
 *
 */
@FeignClient(name="bed")
public interface BedClient {

    @GetMapping("/bed/selById/{id}")
    Bed selById(@PathVariable("id") Integer id);

    @RequestMapping("/bed/update")
    String update(@RequestBody Bed bed);
}
