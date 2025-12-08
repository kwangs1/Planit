package io.choi.Planit.user.domain;

import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.Collection;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import lombok.Data;

@Data
public class Users implements UserDetails{
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
    
    @Override
    public String getUsername() {
        return sabun;
    }
    private String role;
    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        // null / 빈값 / ROLE prefix 없을 때 자동 보정
        String r = (role == null || role.isEmpty()) ? "ROLE_USER" : role;
        if (!r.startsWith("ROLE_")) {
            r = "ROLE_" + r;
        }
        return Arrays.asList(new SimpleGrantedAuthority(r));
    }


    @Override
    public boolean isAccountNonExpired() { return true; }

    @Override
    public boolean isAccountNonLocked() { return true; }

    @Override
    public boolean isCredentialsNonExpired() { return true; }

    @Override
    public boolean isEnabled() { return true; }
}
