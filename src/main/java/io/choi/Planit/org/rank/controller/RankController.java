package io.choi.Planit.org.rank.controller;

import org.springframework.stereotype.Controller;

import io.choi.Planit.org.rank.service.RankService;
import lombok.RequiredArgsConstructor;

@Controller
@RequiredArgsConstructor
public class RankController {

    private final RankService rankService;
}
