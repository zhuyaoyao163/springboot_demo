package com.example.vo;

import com.example.domain.Department;
import com.example.domain.User;

import java.util.List;

/**
 * Created by zhuyy on 2017/3/28.
 */

public class DepartmentVo {

    private String departmentLeaderName;

    private List<User> users;

    private Department department;

    public String getDepartmentLeaderName() {
        return departmentLeaderName;
    }

    public void setDepartmentLeaderName(String departmentLeaderName) {
        this.departmentLeaderName = departmentLeaderName;
    }

    public List<User> getUsers() {
        return users;
    }

    public void setUsers(List<User> users) {
        this.users = users;
    }

    public Department getDepartment() {
        return department;
    }

    public void setDepartment(Department department) {
        this.department = department;
    }
}
