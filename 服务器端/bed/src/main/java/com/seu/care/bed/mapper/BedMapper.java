package com.seu.care.bed.mapper;

import com.seu.care.bed.model.Bed;
import java.util.List;

public interface BedMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Bed record);

    Bed selectByPrimaryKey(Integer id);

    List<Bed> selectAll(Bed bed);

    int updateByPrimaryKey(Bed record);
}