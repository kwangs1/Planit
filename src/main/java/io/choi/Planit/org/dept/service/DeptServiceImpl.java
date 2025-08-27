package io.choi.Planit.org.dept.service;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.stereotype.Service;

import io.choi.Planit.org.dept.domain.Department;
import io.choi.Planit.org.dept.mapper.DeptMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Service
@RequiredArgsConstructor
@Slf4j
public class DeptServiceImpl implements DeptService{

    private final DeptMapper deptMapper;

    @Override
    public List<Department> deptList() {
        return deptMapper.deptList();
    }
    @Override
    public Department info(int deptId){
        return deptMapper.info(deptId);
    }

    @Override
    public int write(Department dept) {
        LocalDateTime now = LocalDateTime.now();
        dept.setCreateDt(now);
        dept.setParId(dept.getParId());
        dept.setStatus("1");
        
        if(dept.getParId() == 1){
            dept.setDepth(1);
        }else{
            Department parent = deptMapper.info(dept.getParId());
            if(parent != null){
                dept.setDepth(parent.getDepth() + 1);
            }else{
                dept.setDepth(1);
            }
        }
        return deptMapper.write(dept);
    }
    @Override
    public int update(Department dept) {
        LocalDateTime now = LocalDateTime.now();
        dept.setUpdateDt(now);
        return deptMapper.update(dept);
    }
    @Override
    public int delete(int deptId) {
        return deptMapper.delete(deptId);
    }

    
}
