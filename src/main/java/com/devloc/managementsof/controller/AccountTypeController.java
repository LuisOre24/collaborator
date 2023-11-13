package com.devloc.managementsof.controller;


import com.devloc.managementsof.entity.AccountType;
import com.devloc.managementsof.service.IAccountTypeService;
import org.slf4j.LoggerFactory;
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
public class AccountTypeController {




    @Autowired
    private IAccountTypeService atypeService;

    @GetMapping("/accounts-types")
    public String getAll(Model model){
        List<AccountType> aTypes = atypeService.getAll();
        model.addAttribute("aTypes", aTypes);
        return "account_type";
    }
    @GetMapping("/accounts-types/new")
    public String createAccountTypeForm(Model model){
        AccountType accountType = new AccountType();
        model.addAttribute("accountType", accountType);
        return "account_type_form";
    }

    @PostMapping("/accounts-types/new")
    public String saveAccountType(@Validated @ModelAttribute AccountType accountType, BindingResult bindingResult, Model model){
        if(bindingResult.hasErrors()){
            model.addAttribute("accountType", accountType);
            return "account_type_form";
        }
        atypeService.create(accountType);
        return "redirect:/accounts-types";
    }

    @GetMapping("/accounts-types/edit/{id}")
    public String editAccountTypeForm(@PathVariable Integer id, Model model){
        AccountType accountType = atypeService.getOneById(id);
        if(accountType != null){
            model.addAttribute("accountType", accountType);
            return "account_type_form";
        }
        return "accounts-types";

    }

    @PostMapping("/accounts-types/edit/{id}")
    public String updateAccountType(@PathVariable Integer id, @Validated @ModelAttribute AccountType accountType,BindingResult bindingResult, Model model){
        AccountType aTypeExist = atypeService.getOneById(id);
        if(aTypeExist != null){
            if(bindingResult.hasErrors()){
                model.addAttribute("aTypeExist", aTypeExist);
                return "account_type_form";
            }

            //rolExist.setIdAccountType(rol.getIdAccountType());
            //rolExist.setAccountType(rol.getAccountType());
            //rolExist.setStatus(rol.isStatus());

            atypeService.update(accountType);
        }
        return  "redirect:/accounts-types";
    }

    @GetMapping("/accounts-types/delete/{id}")
    public String deleteAccountType(@PathVariable Integer id){
        AccountType accountType = atypeService.getOneById(id);

        if(accountType != null){
            atypeService.deleteById(id);
            return "redirect:/accounts-types";
        }
        return "redirect:/accounts-types";
    }

}
