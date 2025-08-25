package io.choi.Planit.org.user.domain;

import java.time.LocalDateTime;

import lombok.Data;

@Data
public class Users {
    private int userId;
    private String name;
    private int deptId;
    private String deptName;
    private String sabun;
    private String status;
    private int posId;
    private int rankId;
    private String password;
    private LocalDateTime passwordUpdateDt;
    private LocalDateTime createDt;
    private LocalDateTime updateDt;
    private String managerF;
}
