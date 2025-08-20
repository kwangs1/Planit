package io.choi.Planit.org.user.domain;

import java.time.LocalDateTime;

import org.springframework.stereotype.Component;

import lombok.Data;

@Component
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
    private LocalDateTime create_dt;
    private LocalDateTime update_dt;
}
