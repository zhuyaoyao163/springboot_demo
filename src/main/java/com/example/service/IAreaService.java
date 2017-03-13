package com.example.service;

import com.example.domain.Area;

import java.util.List;

/**
 * Created by zhuyy on 2017/3/9.
 */
public interface IAreaService {

    public List<Area> selectProvince();

    public List<Area> selectAllAreas();
}
