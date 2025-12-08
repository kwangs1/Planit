package io.choi.Planit.rank.service;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.stereotype.Service;

import io.choi.Planit.rank.domain.Rank;
import io.choi.Planit.rank.mapper.RankMapper;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class RankServiceImpl implements RankService{

    private final RankMapper rankMapper;

    @Override
    public List<Rank> list() {
       return rankMapper.list();
    }

    @Override
    public Rank detail(int rankId) {
        return rankMapper.detail(rankId);
    }

    @Override
    public int write(Rank rank) {
        LocalDateTime now = LocalDateTime.now();
        rank.setCreateDt(now);
        return rankMapper.write(rank);
    }

    @Override
    public int update(int rankId, String rankName) {
        return rankMapper.update(rankId, rankName);
    }

    @Override
    public int delete(int rankId) {
        return rankMapper.delete(rankId);
    }
}
