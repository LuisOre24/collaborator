package com.devloc.managementsof.controller;


import com.devloc.managementsof.entity.Rol;
import com.devloc.managementsof.service.IRolService;
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
public class RolController {

    @Autowired
    private IRolService rolService;

    @GetMapping("/roles")
    public String getAll(Model model) {
        List<Rol> roles = rolService.getAll();
        model.addAttribute("roles", roles);
        return "rol";
    }

    @GetMapping("/roles/new")
    public String createRolForm(Model model) {
        Rol rol = new Rol();
        model.addAttribute("role", rol);
        return "rol_form";
    }

    @PostMapping("/roles/new")
    public String saveRol(@Validated @ModelAttribute Rol rol, BindingResult bindingResult, Model model) {
        if (bindingResult.hasErrors()) {
            model.addAttribute("role", rol);
            return "rol_form";
        }
        rolService.create(rol);
        return "redirect:/roles";
    }

    @GetMapping("/roles/edit/{id}")
    public String editRolForm(@PathVariable Integer id, Model model) {
        Rol rol = rolService.getOneById(id);
        if (rol != null) {
            model.addAttribute("role", rol);
            return "rol_form";
        }
        return "roles";

    }

    @PostMapping("/roles/edit/{id}")
    public String updateRol(@PathVariable Integer id, @Validated @ModelAttribute Rol rol, BindingResult bindingResult, Model model) {
        Rol rolExist = rolService.getOneById(id);
        if (rolExist != null) {
            if (bindingResult.hasErrors()) {
                model.addAttribute("role", rolExist);
                return "rol_form";
            }

            //rolExist.setIdRol(rol.getIdRol());
            //rolExist.setRol(rol.getRol());
            //rolExist.setStatus(rol.isStatus());

            rolService.update(rol);
        }
        return "redirect:/roles";
    }

    @GetMapping("/roles/delete/{id}")
    public String deleteRol(@PathVariable Integer id) {
        Rol rol = rolService.getOneById(id);

        if (rol != null) {
            rolService.deleteById(id);
            return "redirect:/roles";
        }
        return "redirect:/roles";
    }

}
