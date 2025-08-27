package io.choi.Planit.org.position.controller;

import org.springframework.stereotype.Controller;

import io.choi.Planit.org.position.service.PositionService;
import lombok.RequiredArgsConstructor;

@Controller
@RequiredArgsConstructor
public class PositionController {

    private final PositionService positionService;

}
