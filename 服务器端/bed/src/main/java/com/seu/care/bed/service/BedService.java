package com.seu.care.bed.service;

import com.github.pagehelper.PageInfo;
import com.seu.care.bed.model.Bed;

import java.util.List;

public interface BedService {

    PageInfo<Bed> listAll(Integer currPage,Bed bed);

    Bed selById(Integer id);

    void add(Bed bed);

    void del(Integer id);

    void update(Bed bed);

    List<Bed> queryAll(Bed bed);
}
