package io.choi.Planit.org.position.service;

import java.util.List;

import io.choi.Planit.org.position.domain.Position;

public interface PositionService{

     List<Position> list();

     Position detail(int posId);

     int write(Position pos);

     int update(int posId, String posName);

     int delete(int posId);
}
