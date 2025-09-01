package io.choi.Planit.org.rank.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import io.choi.Planit.org.rank.domain.Rank;
import io.choi.Planit.org.rank.service.RankService;
import lombok.RequiredArgsConstructor;

@Controller
@RequiredArgsConstructor
@RequestMapping("/rank")
public class RankController {

    private final RankService rankService;

    @GetMapping("/list")
    public String list(Model model) {
        model.addAttribute("rankList", rankService.list());
        return "/org/rank/list";
    }

    @GetMapping("/detail")
    public String detail(int rankId, Model model){
        model.addAttribute("rank", rankService.detail(rankId));
        return "/org/rank/detail";
    }

    @GetMapping("writeForm")
    public String writeForm() {
        return "/org/rank/writeForm";
    }

    @PostMapping("/write")
    public String write(Rank rank){
        rankService.write(rank);
        return "/org/closePopup";
    }

    @PostMapping("/update")
    public String update(int rankId, String rankName){
        rankService.update(rankId, rankName);
        return "/org/closePopup";
    }

    @PostMapping("/delete")
    public String delete(int rankId){
        rankService.delete(rankId);
        return "/org/closePopup";
    }
}
