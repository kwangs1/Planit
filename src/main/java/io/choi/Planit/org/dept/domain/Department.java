package io.choi.Planit.org.dept.domain;

import java.time.LocalDateTime;

import lombok.Data;

@Data
public class Department {

    private int dept_id;
    private String dept_name;
    private int par_id;
    private int depth;
    LocalDateTime create_dt;
    LocalDateTime update_dt;
}
