package com.example.mapper;

import com.example.domain.Area;

import java.util.List;

public interface AreaMapper {
    int deleteByPrimaryKey(String areaCode);

    int insert(Area record);

    int insertSelective(Area record);

    Area selectByPrimaryKey(String areaCode);

    int updateByPrimaryKeySelective(Area record);

    int updateByPrimaryKey(Area record);

    List<Area> selectProvince();

    List<Area> selectAll();
}