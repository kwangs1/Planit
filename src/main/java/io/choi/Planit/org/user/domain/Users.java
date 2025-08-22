package io.choi.Planit.org.user.domain;

import java.time.LocalDateTime;

import lombok.Data;

@Data
public class Users {
    private int user_id;
    private String name;
    private int dept_id;
    private String dept_name;
    private String sabun;
    private String status;
    private int pos_id;
    private int rank_id;
    private String password;
    private LocalDateTime password_update_dt;
    private LocalDateTime create_dt;
    private LocalDateTime update_dt;
    private String manager_f;
}
