package io.choi.Planit.org.position.service;

import org.springframework.stereotype.Service;

import io.choi.Planit.org.position.mapper.PositionMapper;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class PositionServiceImpl implements PositionService{

    private final PositionMapper positionMapper;
}
