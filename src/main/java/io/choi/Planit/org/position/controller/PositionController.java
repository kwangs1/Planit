package io.choi.Planit.org.position.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import io.choi.Planit.org.position.domain.Position;
import io.choi.Planit.org.position.service.PositionService;
import lombok.RequiredArgsConstructor;


@Controller
@RequiredArgsConstructor
@RequestMapping("/pos")
public class PositionController {

    private final PositionService positionService;

    @GetMapping("/list")
    public String list(Model model) {
        List<Position> posList = positionService.list();
        model.addAttribute("posList", posList);
        return "/org/pos/list";
    }

    @GetMapping("/writeForm")
    public String writeForm() {
        return "/org/pos/writeForm";
    }

    @PostMapping("/write")
    public String write(Position pos){
        positionService.write(pos);
        return "/org/closePopup";
    }

    @GetMapping("/detail")
    public String detail(int posId, Model model){
        model.addAttribute("pos", positionService.detail(posId));
        return "/org/pos/detail";
    }

    @PostMapping("/update")
    public String update(int posId, String posName){
        positionService.update(posId, posName);
        return "/org/closePopup";
    }

    @PostMapping("/delete")
    public String delete(int posId){
        positionService.delete(posId);
        return "/org/closePopup";
    }
    
    
}
