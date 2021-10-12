package com.seu.care.bed.controller;

import com.github.pagehelper.PageInfo;
import com.seu.care.bed.model.Bed;
import com.seu.care.bed.service.BedService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

/**
 * RequestBody: 接收数据类型是JSON格式
 */
@RestController
@RequestMapping("/bed")
public class BedController {

    @Resource
    private BedService bedService;

    /**
     * 查询所有
     * @param bed
     * @return
     */
    @RequestMapping("queryAll")
    public List<Bed> query(@RequestBody Bed bed){
        return bedService.queryAll(bed);
    }

    /**
     * 分页查询
     * @param currPage
     * @return
     */
    @RequestMapping("listAll/{currPage}")
    public PageInfo<Bed> listAll(@PathVariable Integer currPage,@RequestBody Bed bed){
        return bedService.listAll(currPage,bed);
    }

    /**
     * 根据主键加载
     * @param id
     * @return
     */
    @RequestMapping("selById/{id}")
    public Bed selById(@PathVariable Integer id){
        return bedService.selById(id);
    }

    /**
     * 新增
     * @param bed
     * @return
     */
    @RequestMapping("add")
    public String add(@RequestBody Bed bed){
        bedService.add(bed);
        return "succ";
    }

    /**
     * 删除
     * @param id
     * @return
     */
    @RequestMapping("del/{id}")
    public String del(@PathVariable Integer id){
        bedService.del(id);
        return "succ";
    }

    /**
     * 修改
     * @param bed
     * @return
     */
    @RequestMapping("update")
    public String update(@RequestBody Bed bed){
        bedService.update(bed);
        return "succ";
    }
}
