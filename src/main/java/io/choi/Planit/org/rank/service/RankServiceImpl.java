package io.choi.Planit.org.rank.service;

import org.springframework.stereotype.Service;

import io.choi.Planit.org.rank.mapper.RankMapper;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class RankServiceImpl implements RankService{

    private final RankMapper rankMapper;
}
