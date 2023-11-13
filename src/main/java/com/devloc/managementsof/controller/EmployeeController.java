package com.devloc.managementsof.controller;


import com.devloc.managementsof.entity.*;
import com.devloc.managementsof.service.*;
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
public class EmployeeController {

    @Autowired
    private IEmployeeService service;
    @Autowired
    private IDocumentService documentService;
    @Autowired
    private IPositionService positionService;
    @Autowired
    private IWorkAreaService workAreaService;
    @Autowired
    private ISubsidiaryService subsidiaryService;

    @GetMapping("/employees")
    public String allEmployees(Model model){
        List<Employee> employees = service.getAll();
        model.addAttribute("employees", employees);
        return "employee";
    }

    @GetMapping("/employees/new")
    public String createEmployeeTemplate(Model model){
        Employee employee = new Employee();
        List<Document> documents = documentService.getAll();
        List<Position> positions = positionService.getAll();
        List<WorkArea> workareas = workAreaService.getAll();
        List<Subsidiary> subsidiaries = subsidiaryService.getAll();

        model.addAttribute("employee", employee);
        model.addAttribute("positions", positions);
        model.addAttribute("workareas", workareas);
        model.addAttribute("documents", documents);
        model.addAttribute("subsidiaries", subsidiaries);

        return "employee_form";
    }

    @PostMapping("/employees/new")
    public String saveEmployee(@Validated @ModelAttribute("employee") Employee employee, BindingResult bindingResult, Model model){
        if (bindingResult.hasErrors()){
            model.addAttribute("employee", employee);
            return "employee_form";
        }

        service.create(employee);

        return "redirect:/employees";
    }

    @GetMapping("/employees/edit/{id}")
    public String editEmployeeTemplate(@PathVariable Integer id, Model model){
        Employee employee = service.getOneById(id);

        List<Document> documents = documentService.getAll();
        List<Position> positions = positionService.getAll();
        List<WorkArea> workareas = workAreaService.getAll();
        List<Subsidiary> subsidiaries = subsidiaryService.getAll();

        model.addAttribute("employee", employee);
        model.addAttribute("positions", positions);
        model.addAttribute("workareas", workareas);
        model.addAttribute("documents", documents);
        model.addAttribute("subsidiaries", subsidiaries);


        return "employee_form";
    }

    @PostMapping("/employees/edit/{id}")
    public String updateEmployee(@PathVariable Integer id,@Validated @ModelAttribute("employee") Employee employee, BindingResult bindingResult, Model model){

        if(bindingResult.hasErrors()){
            model.addAttribute("employee", employee);
            return "employee_form";
        }

        Employee existEmployee = service.getOneById(id);

//        existEmployee.setIdEmployee(employee.getIdEmployee());
//        existEmployee.setCodEmployee(employee.getCodEmployee());
//        existEmployee.setNameEmployee(employee.getNameEmployee());
//        existEmployee.setRucEmployee(employee.getRucEmployee());
//        existEmployee.setAddress(employee.getAddress());
//        existEmployee.setStatus(employee.getStatus());

        service.update(existEmployee);

        return "redirect:/employees";
    }

    @GetMapping("/employees/delete/{id}")
    public String deleteEmployee(@PathVariable Integer id){
        service.deleteById(id);
        return "redirect:/employees";
    }




}
