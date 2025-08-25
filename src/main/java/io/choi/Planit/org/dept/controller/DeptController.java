package io.choi.Planit.org.dept.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import io.choi.Planit.org.dept.domain.Department;
import io.choi.Planit.org.dept.service.DeptService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;




@Controller
@RequiredArgsConstructor
@RequestMapping("/dept")
@Slf4j
public class DeptController {

    private final DeptService deptService;

    @GetMapping("/list")
    public String list(Model model) {
        List<Department> deptList = deptService.deptList();

        model.addAttribute("deptList", deptList);
        return "/org/dept/list";
    }
    
    @GetMapping("/writeForm")
    public String writeForm(Model model) {
        model.addAttribute("dept", new Department());
        return "/org/dept/writeForm";
    }
    
    @PostMapping("/write")
    public int write(Department dept) {
        return deptService.write(dept);
    }
    
}
