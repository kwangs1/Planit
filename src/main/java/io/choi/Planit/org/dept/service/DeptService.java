package io.choi.Planit.org.dept.service;

import java.util.List;

import io.choi.Planit.org.dept.domain.Department;

public interface DeptService {
    
    List<Department> deptList();
    
    int write(Department dept);
}
