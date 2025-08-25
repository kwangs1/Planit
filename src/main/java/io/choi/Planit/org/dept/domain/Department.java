package io.choi.Planit.org.dept.domain;

import java.time.LocalDateTime;

import lombok.Data;

@Data
public class Department {

    private int deptId;
    private String deptName;
    private int parId;
    private int depth;
    LocalDateTime createDt;
    LocalDateTime updateDt;
}
