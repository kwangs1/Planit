package io.choi.Planit.org.rank.domain;

import java.time.LocalDateTime;

import lombok.Data;

@Data
public class Rank {

    private int rankId;
    private String rankName;
    private LocalDateTime createDt;
}
