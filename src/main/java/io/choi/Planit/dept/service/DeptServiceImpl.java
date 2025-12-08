package io.choi.Planit.dept.service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;

import io.choi.Planit.common.tree.FancyNode;
import io.choi.Planit.dept.domain.Department;
import io.choi.Planit.dept.mapper.DeptMapper;
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

    @Override
    public List<FancyNode> getDeptTree() {
        List<Department> deptList = deptMapper.deptList();

        Map<Integer, FancyNode> nodeMap = new HashMap<>();
        List<FancyNode> roots = new ArrayList<>();
        //dept -> FancyNode Change Map Save
        for (Department dept : deptList) {
            log.info("dept >>",dept.getDeptName());
            FancyNode node = new FancyNode();
            node.setKey(String.valueOf(dept.getDeptId()));
            node.setTitle(dept.getDeptName());
            node.setFolder(true);
            
            nodeMap.put(dept.getDeptId(), node);
            log.info("NodeMap Value>> ", nodeMap);
        }
        //parent - childern chain
        for (Department dept : deptList){
            Integer parentId = dept.getParId();

            if (parentId == null || parentId == 0){
                log.info("root deptName: ",dept.getDeptName());
                roots.add(nodeMap.get(dept.getDeptId()));
            } else {
                FancyNode parentNode = nodeMap.get(parentId);
                if (parentNode != null){
                    log.info("children DeptName: ",dept.getDeptName());
                    parentNode.getChildren().add(nodeMap.get(dept.getDeptId()));
                }
            }
        }
        return roots;
    }

}
