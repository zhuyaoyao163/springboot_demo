package com.example.service;

import com.example.domain.User;

import java.util.List;

/**
 * Created by zhuyy on 2017/3/27.
 */
public interface UserService {

    public List<User> findUserByDepartmentId(int departmentId);
}
