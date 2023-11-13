package com.devloc.managementsof.controller;


import com.devloc.managementsof.entity.Company;
import com.devloc.managementsof.service.ICompanyService;
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
public class CompanyController {

    @Autowired
    private ICompanyService service;

    @GetMapping("/companies")
    public String allCompanies(Model model){
        List<Company> companies = service.getAll();
        model.addAttribute("companies", companies);
        return "company";
    }

    @GetMapping("/companies/new")
    public String createCompanyTemplate(Model model){
        Company company = new Company();
        model.addAttribute("company", company);

        return "company_form";
    }

    @PostMapping("/companies/new")
    public String saveCompany(@Validated @ModelAttribute("company") Company company, BindingResult bindingResult, Model model){
        if (bindingResult.hasErrors()){
            model.addAttribute("company", company);
            return "company_form";
        }

        service.create(company);

        return "redirect:/companies";
    }

    @GetMapping("/companies/edit/{id}")
    public String editCompanyTemplate(@PathVariable Integer id, Model model){
        Company company = service.getOneById(id);

        model.addAttribute("company", company);
        return "company_form";
    }

    @PostMapping("/companies/edit/{id}")
    public String updateCompany(@PathVariable Integer id,@Validated @ModelAttribute("company") Company company, BindingResult bindingResult, Model model){

        if(bindingResult.hasErrors()){
            model.addAttribute("company", company);
            return "company_form";
        }

        Company existCompany = service.getOneById(id);

        existCompany.setIdCompany(company.getIdCompany());
        existCompany.setCodCompany(company.getCodCompany());
        existCompany.setNameCompany(company.getNameCompany());
        existCompany.setRucCompany(company.getRucCompany());
        existCompany.setAddress(company.getAddress());
        existCompany.setStatus(company.getStatus());

        service.update(existCompany);

        return "redirect:/companies";
    }

    @GetMapping("/companies/delete/{id}")
    public String deleteCompany(@PathVariable Integer id){
        service.deleteById(id);
        return "redirect:/companies";
    }




}
