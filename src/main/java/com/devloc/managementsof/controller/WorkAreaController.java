package com.devloc.managementsof.controller;


import com.devloc.managementsof.entity.WorkArea;
import com.devloc.managementsof.service.IWorkAreaService;
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
public class WorkAreaController {

    @Autowired
    private IWorkAreaService workareaService;

    @GetMapping("/departments")
    public String getAll(Model model){
        List<WorkArea> workareas = workareaService.getAll();
        model.addAttribute("workareas", workareas);
        return "workarea";
    }
    @GetMapping("/departments/new")
    public String createWorkAreaForm(Model model){
        WorkArea workarea = new WorkArea();
        model.addAttribute("workarea", workarea);
        return "workarea_form";
    }

    @PostMapping("/departments/new")
    public String saveWorkArea(@Validated @ModelAttribute WorkArea workarea, BindingResult bindingResult, Model model){
        if(bindingResult.hasErrors()){
            model.addAttribute("workarea", workarea);
            return "workarea_form";
        }
        workareaService.create(workarea);
        return "redirect:/departments";
    }

    @GetMapping("/departments/edit/{id}")
    public String editWorkAreaForm(@PathVariable Integer id, Model model){
        WorkArea workarea = workareaService.getOneById(id);
        if(workarea != null){
            model.addAttribute("workarea", workarea);
            return "workarea_form";
        }
        return "workarea";

    }

    @PostMapping("/departments/edit/{id}")
    public String updateWorkArea(@PathVariable Integer id, @Validated @ModelAttribute WorkArea workarea,BindingResult bindingResult, Model model){
        WorkArea workareaExist = workareaService.getOneById(id);
        if(workareaExist != null){
            if(bindingResult.hasErrors()){
                model.addAttribute("workarea", workareaExist);
                return "workarea_form";
            }

            //workareaExist.setIdWorkArea(workarea.getIdWorkArea());
            //workareaExist.setWorkArea(workarea.getWorkArea());
            //workareaExist.setStatus(workarea.isStatus());

            workareaService.update(workarea);
        }
        return  "redirect:/departments";
    }

    @GetMapping("/departments/delete/{id}")
    public String deleteWorkArea(@PathVariable Integer id){
        WorkArea workarea = workareaService.getOneById(id);

        if(workarea != null){
            workareaService.deleteById(id);
            return "redirect:/departments";
        }
        return "redirect:/departments";
    }

}
