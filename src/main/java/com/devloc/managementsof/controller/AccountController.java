package com.devloc.managementsof.controller;



import com.devloc.managementsof.entity.Account;
import com.devloc.managementsof.service.IAccountService;
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
public class AccountController {

    @Autowired
    private IAccountService accountService;

    @GetMapping("/accounts")
    public String getAll(Model model){
        List<Account> accounts = accountService.getAll();
        model.addAttribute("accounts", accounts);
        return "account";
    }
    @GetMapping("/accounts/new")
    public String createAccountForm(Model model){
        Account account = new Account();
        model.addAttribute("account", account);
        return "account_form";
    }

    @PostMapping("/accounts/new")
    public String saveAccount(@Validated @ModelAttribute Account account, BindingResult bindingResult, Model model){
        if(bindingResult.hasErrors()){
            model.addAttribute("account", account);
            return "account_form";
        }
        accountService.create(account);
        return "redirect:/accounts";
    }

    @GetMapping("/accounts/edit/{id}")
    public String editAccountForm(@PathVariable Integer id, Model model){
        Account account = accountService.getOneById(id);
        if(account != null){
            model.addAttribute("account", account);
            return "account_form";
        }
        return "accounts";

    }

    @PostMapping("/accounts/edit/{id}")
    public String updateAccount(@PathVariable Integer id, @Validated @ModelAttribute Account account,BindingResult bindingResult, Model model){
        Account accountExist = accountService.getOneById(id);
        if(accountExist != null){
            if(bindingResult.hasErrors()){
                model.addAttribute("account", accountExist);
                return "account_form";
            }

            //rolExist.setIdRol(rol.getIdRol());
            //rolExist.setRol(rol.getRol());
            //rolExist.setStatus(rol.isStatus());

            accountService.update(account);
        }
        return  "redirect:/accounts";
    }

    @GetMapping("/accounts/delete/{id}")
    public String deleteAccount(@PathVariable Integer id){
        Account account = accountService.getOneById(id);

        if(account != null){
            accountService.deleteById(id);
            return "redirect:/accounts";
        }
        return "redirect:/accounts";
    }

}
