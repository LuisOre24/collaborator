package com.devloc.managementsof.controller;


import com.devloc.managementsof.entity.Document;
import com.devloc.managementsof.service.IDocumentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
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
public class DocumentController {

    @Autowired
    private IDocumentService documentService;

    @GetMapping("/documents")
    public String getAll(Model model){
        List<Document> documents = documentService.getAll();
        model.addAttribute("documents", documents);
        return "document";
    }
    @PreAuthorize("hasRole('USER')")
    @GetMapping("/documents/new")
    public String createDocumentForm(Model model){
        Document document = new Document();
        model.addAttribute("document", document);
        return "document_form";
    }
    @PreAuthorize("hasRole('USER')")
    @PostMapping("/documents/new")
    public String saveDocument(@Validated @ModelAttribute Document document, BindingResult bindingResult, Model model){
        if(bindingResult.hasErrors()){
            model.addAttribute("document", document);
            return "document_form";
        }
        documentService.create(document);
        return "redirect:/documents";
    }

    @GetMapping("/documents/edit/{id}")
    public String editDocumentForm(@PathVariable Integer id, Model model){
        Document document = documentService.getOneById(id);
        if(document != null){
            model.addAttribute("document", document);
            return "document_form";
        }
        return "documents";

    }

    @PostMapping("/documents/edit/{id}")
    public String updateDocument(@PathVariable Integer id, @Validated @ModelAttribute Document document,BindingResult bindingResult, Model model){
        Document documentExist = documentService.getOneById(id);
        if(documentExist != null){
            if(bindingResult.hasErrors()){
                model.addAttribute("document", documentExist);
                return "document_form";
            }

            //documentExist.setIdDocument(document.getIdDocument());
            //documentExist.setDocument(document.getDocument());
            //documentExist.setStatus(document.isStatus());

            documentService.update(document);
        }
        return  "redirect:/documents";
    }

    @GetMapping("/documents/delete/{id}")
    public String deleteDocument(@PathVariable Integer id){
        Document document = documentService.getOneById(id);

        if(document != null){
            documentService.deleteById(id);
            return "redirect:/documents";
        }
        return "redirect:/documents";
    }

}
