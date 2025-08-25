package io.choi.Planit.org.dept.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import io.choi.Planit.org.dept.domain.Department;

@Mapper
public interface DeptMapper {

    List<Department> deptList();

    int write(Department dept);
}
