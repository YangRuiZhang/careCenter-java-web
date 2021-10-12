package com.seu.care.bed.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

import com.seu.care.bed.mapper.BedMapper;
import com.seu.care.bed.model.Bed;
import com.seu.care.bed.service.BedService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class BedServiceImpl implements BedService {

    @Autowired
    private BedMapper bedMapper;

    @Override
    public PageInfo<Bed> listAll(Integer currPage,Bed bed) {
        PageHelper.startPage(currPage,5);
        PageInfo<Bed> pageInfo = new PageInfo<>(bedMapper.selectAll(bed));
        return pageInfo;
    }

    /**
     * 根据ID号加载记录
     * @param id
     * @return
     */
    @Override
    public Bed selById(Integer id) {
        return bedMapper.selectByPrimaryKey(id);
    }

    @Override
    public void add(Bed bed) {
        bed.setCreateTime(new Date());
        bedMapper.insert(bed);
    }

    @Override
    public void del(Integer id) {
        bedMapper.deleteByPrimaryKey(id);
    }

    @Override
    public void update(Bed bed) {
        bedMapper.updateByPrimaryKey(bed);
    }

    @Override
    public List<Bed> queryAll(Bed bed) {
        return bedMapper.selectAll(bed);
    }
}
