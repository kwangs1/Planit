package io.choi.Planit.org.position.domain;

import java.time.LocalDateTime;

import lombok.Data;

@Data
public class Position {

    private int posId;
    private String posName;
    private LocalDateTime createDt;
}
