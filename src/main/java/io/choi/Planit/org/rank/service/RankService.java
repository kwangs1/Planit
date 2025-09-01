package io.choi.Planit.org.rank.service;

import java.util.List;

import io.choi.Planit.org.rank.domain.Rank;

public interface RankService {

    List<Rank> list();

    Rank detail(int rankId);

    int write(Rank rank);

    int update(int rankId, String rankName);

    int delete(int rankId);
}
