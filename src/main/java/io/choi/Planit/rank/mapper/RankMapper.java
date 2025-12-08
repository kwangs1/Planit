package io.choi.Planit.rank.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import io.choi.Planit.rank.domain.Rank;

@Mapper
public interface RankMapper {
    List<Rank> list();

    Rank detail(int rankId);

    int write(Rank rank);

    int update(int rankId, String rankName);

    int delete(int rankId);

}
