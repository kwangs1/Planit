package io.choi.Planit.org.dept.service;

import java.util.List;

import io.choi.Planit.org.dept.domain.Department;

public interface DeptService {
    
    List<Department> deptList();

    Department info(int deptId);

    int write(Department dept);

    int update(Department dept);

    int delete(int deptId);
}
