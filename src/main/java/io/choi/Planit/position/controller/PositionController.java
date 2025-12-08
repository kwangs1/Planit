package io.choi.Planit.position.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import io.choi.Planit.position.domain.Position;
import io.choi.Planit.position.service.PositionService;
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
        return "pos/list";
    }

    @GetMapping("/writeForm")
    public String writeForm() {
        return "pos/writeForm";
    }

    @PostMapping("/write")
    public String write(Position pos){
        positionService.write(pos);
        return "closePopup";
    }

    @GetMapping("/detail")
    public String detail(int posId, Model model){
        model.addAttribute("pos", positionService.detail(posId));
        return "pos/detail";
    }

    @PostMapping("/update")
    public String update(int posId, String posName){
        positionService.update(posId, posName);
        return "closePopup";
    }

    @PostMapping("/delete")
    public String delete(int posId){
        positionService.delete(posId);
        return "closePopup";
    }
    
    
}
