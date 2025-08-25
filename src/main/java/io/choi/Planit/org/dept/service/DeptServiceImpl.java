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
        dept.setCreate_dt(now);

        if(dept.getDept_id() == 0){
            dept.setDepth(0);
            dept.setPar_id(0);
        }else{
            dept.setPar_id(dept.getDept_id());
            dept.setDepth(dept.getDepth() + 1);
        }
        return deptMapper.write(dept);

    }

    
}
