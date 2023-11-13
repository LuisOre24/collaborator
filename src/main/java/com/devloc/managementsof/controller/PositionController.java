package com.devloc.managementsof.controller;


import com.devloc.managementsof.entity.Position;
import com.devloc.managementsof.service.IPositionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
public class PositionController {

    @Autowired
    private IPositionService positionService;

    @GetMapping("/positions")
    public String getAll(Model model) {
        List<Position> positions = positionService.getAll();
        model.addAttribute("positions", positions);
        return "position";
    }

    @GetMapping("/positions/new")
    public String createPositionForm(Model model) {
        Position position = new Position();
        model.addAttribute("position", position);
        return "position_form";
    }

    @PostMapping("/positions/new")
    public String savePosition(@Validated @ModelAttribute Position position, BindingResult bindingResult, Model model) {
        if (bindingResult.hasErrors()) {
            model.addAttribute("position", position);
            return "position_form";
        }
        positionService.create(position);
        return "redirect:/positions";
    }

    @GetMapping("/positions/edit/{id}")
    public String editPositionForm(@PathVariable Integer id, Model model) {
        Position position = positionService.getOneById(id);
        if (position != null) {
            model.addAttribute("position", position);
            return "position_form";
        }
        return "positions";

    }

    @PostMapping("/positions/edit/{id}")
    public String updatePosition(@PathVariable Integer id, @Validated @ModelAttribute Position position, BindingResult bindingResult, Model model) {
        Position positionExist = positionService.getOneById(id);
        if (positionExist != null) {
            if (bindingResult.hasErrors()) {
                model.addAttribute("position", positionExist);
                return "position_form";
            }

            //positionExist.setIdPosition(position.getIdPosition());
            //positionExist.setPosition(position.getPosition());
            //positionExist.setStatus(position.isStatus());

            positionService.update(position);
        }
        return "redirect:/positions";
    }

    @GetMapping("/positions/delete/{id}")
    public String deletePosition(@PathVariable Integer id) {
        Position position = positionService.getOneById(id);

        if (position != null) {
            positionService.deleteById(id);
            return "redirect:/positions";
        }
        return "redirect:/positions";
    }

}
