package io.choi.Planit.position.service;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.stereotype.Service;

import io.choi.Planit.position.domain.Position;
import io.choi.Planit.position.mapper.PositionMapper;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class PositionServiceImpl implements PositionService{

    private final PositionMapper positionMapper;

    @Override
    public List<Position> list() {
        List<Position> posList = positionMapper.list();
        return posList;
    }

    @Override
    public Position detail(int posId){
        return positionMapper.detail(posId);
    }

    @Override
    public int write(Position pos) {
        LocalDateTime now = LocalDateTime.now();
        pos.setCreateDt(now);
        return positionMapper.write(pos);
    }

    @Override
    public int update(int posId, String posName) {
        return positionMapper.update(posId, posName);
    }

    @Override
    public int delete(int posId) {
        return positionMapper.delete(posId);
    }
}
