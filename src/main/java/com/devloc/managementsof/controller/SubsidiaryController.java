package com.devloc.managementsof.controller;


import com.devloc.managementsof.entity.Company;
import com.devloc.managementsof.entity.Subsidiary;
import com.devloc.managementsof.service.ICompanyService;
import com.devloc.managementsof.service.ISubsidiaryService;
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
public class SubsidiaryController {

    @Autowired
    private ISubsidiaryService subsidiaryService;

    @Autowired
    private ICompanyService companyService;

    @GetMapping("/subsidiaries")
    public String getSubsidiary(Model model){

        List<Subsidiary> subsidiaries = subsidiaryService.getAll();
        model.addAttribute("subsidiaries", subsidiaries);
        return "subsidiary";
    }

    @GetMapping("/subsidiaries/new")
    public String createSubsidiaryForm(Model model){
        Subsidiary subsidiary = new Subsidiary();
        List<Company> companies = companyService.getAll() ;
        model.addAttribute("subsidiary", subsidiary);
        model.addAttribute("companies", companies);
        return "subsidiary_form";
    }

    @PostMapping("/subsidiaries/new")
    public String createSubsidiary(@Validated @ModelAttribute("subsidiary") Subsidiary subsidiary, BindingResult bindingResult, Model model){

        if(bindingResult.hasErrors()){
            model.addAttribute("subsidiary", subsidiary);
            return "subsidiary_form";
        }
        subsidiaryService.create(subsidiary);
        return "redirect:/subsidiries";
    }

    @GetMapping("/subsidiaries/edit/{id}")
    public String editSubsidiaryForm(@PathVariable Integer id, Model model){
        Subsidiary subsidiary = subsidiaryService.getOneById(id);
        List<Company> companies = companyService.getAll();
        model.addAttribute("subsidiary", subsidiary);
        model.addAttribute("companies", companies);
        return "subsidiary_form";
    }
    @PostMapping("/subsidiaries/edit/{id}")
    public String updateSubsidiary(@PathVariable Integer id, @Validated @ModelAttribute("subsidiary") Subsidiary subsidiary, BindingResult bindingResult, Model model){

        if(bindingResult.hasErrors()){
            model.addAttribute("subsidiary", subsidiary);
            return "subsidiary_form";
        }

        Subsidiary subsidiarydb = subsidiaryService.getOneById(id);

        subsidiarydb.setIdSubsidiary(subsidiary.getIdSubsidiary());
        subsidiarydb.setCodSubsidiary(subsidiary.getCodSubsidiary());
        subsidiarydb.setNameSubsidiary(subsidiary.getNameSubsidiary());
        subsidiarydb.setAddress(subsidiary.getAddress());
        subsidiarydb.setStatus(subsidiary.isStatus());

        subsidiaryService.update(subsidiary);

        return "redirect:/subsidiaries";
    }

    @GetMapping("/subsidiaries/delete/{id}")
    public String deleteSubsidiary(@PathVariable Integer id){
        Subsidiary subsidiary = subsidiaryService.getOneById(id);
        if(subsidiary != null){
            subsidiaryService.deleteById(id);
            return "redirect:/subsidiaries";
        }

        return "redirect:/subsidiaries";

    }

}
