package io.choi.Planit.common.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import io.choi.Planit.common.tree.FancyNode;
import io.choi.Planit.dept.service.DeptService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Controller
@RequiredArgsConstructor
@RequestMapping("/tree")
@Slf4j
public class TreeController {
    
    private final DeptService deptService;

    @GetMapping("/view")
    public String view(){
        return "common/tree/tree";
    }

    @ResponseBody
    @GetMapping("/data")
    public List<FancyNode> getTree(String type){
        switch (type){
            case "dept":
                return deptService.getDeptTree();
            default:
                throw new IllegalArgumentException("Unknown tree type");
        }
    }
}
