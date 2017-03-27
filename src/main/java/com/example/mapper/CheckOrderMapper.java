package com.example.mapper;

import com.example.domain.CheckOrder;

public interface CheckOrderMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(CheckOrder record);

    int insertSelective(CheckOrder record);

    CheckOrder selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(CheckOrder record);

    int updateByPrimaryKey(CheckOrder record);
}