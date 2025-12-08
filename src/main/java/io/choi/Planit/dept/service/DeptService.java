package io.choi.Planit.dept.service;

import java.util.List;

import io.choi.Planit.common.tree.FancyNode;
import io.choi.Planit.dept.domain.Department;

public interface DeptService {
    
    List<Department> deptList();

    Department info(int deptId);

    int write(Department dept);

    int update(Department dept);

    int delete(int deptId);

    List<FancyNode> getDeptTree();
}
