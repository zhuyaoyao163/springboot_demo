package com.example.service.impl;

import com.example.domain.Area;
import com.example.mapper.AreaMapper;
import com.example.service.IAreaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by zhuyy on 2017/3/9.
 */
@Service("iAreaService")
public class IAreaServiceImpl implements IAreaService{

    @Autowired
    private AreaMapper areaMapper;

    @Override
    public List<Area> selectProvince() {
        List<Area> areas = areaMapper.selectProvince();
        return areas;
    }

    @Override
    public List<Area> selectAllAreas() {
        return areaMapper.selectAll();
    }

}
