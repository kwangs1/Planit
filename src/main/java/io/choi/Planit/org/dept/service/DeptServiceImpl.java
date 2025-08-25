package io.choi.Planit.org.dept.service;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.stereotype.Service;

import io.choi.Planit.org.dept.domain.Department;
import io.choi.Planit.org.dept.mapper.DeptMapper;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class DeptServiceImpl implements DeptService{

    private final DeptMapper deptMapper;

    @Override
    public List<Department> deptList() {
        return deptMapper.deptList();
    }

    @Override
    public int write(Department dept) {
        LocalDateTime now = LocalDateTime.now();
        dept.setCreateDt(now);

        if(dept.getDeptId() == 0){
            dept.setDepth(0);
            dept.setParId(0);
        }else{
            dept.setParId(dept.getDeptId());
            dept.setDepth(dept.getDepth() + 1);
        }
        return deptMapper.write(dept);

    }

    
}
