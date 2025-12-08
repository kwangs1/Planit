package io.choi.Planit.position.service;

import java.util.List;

import io.choi.Planit.position.domain.Position;

public interface PositionService{

     List<Position> list();

     Position detail(int posId);

     int write(Position pos);

     int update(int posId, String posName);

     int delete(int posId);
}
