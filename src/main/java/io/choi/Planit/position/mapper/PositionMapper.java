package io.choi.Planit.position.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import io.choi.Planit.position.domain.Position;

@Mapper
public interface PositionMapper {

    List<Position> list();

    Position detail(int posId);

    int write(Position pos);

    int update(int posId, String posName);

    int delete(int posId);
}
