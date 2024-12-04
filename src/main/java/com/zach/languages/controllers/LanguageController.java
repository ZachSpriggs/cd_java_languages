package com.zach.languages.controllers;

import java.util.*;
import javax.validation.Valid;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import com.zach.languages.models.Language;
import com.zach.languages.services.LanguageService;

@Controller
public class LanguageController {
	private final LanguageService languageService;
    
    public LanguageController(LanguageService languageService) {
        this.languageService = languageService;
    }
    
    @RequestMapping("/languages")
    public String index(@ModelAttribute("language") Language language, Model model) {
        List<Language> languages = languageService.allLanguages();
        model.addAttribute("languages", languages);
        return "/languages/index.jsp";
    }
    
    @RequestMapping("/languages/{id}")
    public String show(@PathVariable("id") Long id, Model model) {
    	Language language = languageService.findLanguage(id);
        model.addAttribute("language", language);
        return "/languages/show.jsp";
    }
    
    @RequestMapping(value="/languages/create", method=RequestMethod.POST)
    public String create(@Valid @ModelAttribute("language") Language language, BindingResult result) {
        if (result.hasErrors()) {
            return "/languages/index.jsp";
        } else {
            languageService.createLanguage(language);
            return "redirect:/languages";
        }
    }
    
    @RequestMapping("/languages/{id}/edit")
    public String edit(@PathVariable("id") Long id, Model model) {
        Language language = languageService.findLanguage(id);
        model.addAttribute("language", language);
        return "/languages/edit.jsp";
    }
    
    @RequestMapping(value="/languages/{id}", method=RequestMethod.PUT)
    public String update(@Valid @ModelAttribute("language") Language language, BindingResult result) {
        if (result.hasErrors()) {
            return "/languages/edit.jsp";
        } else {
            languageService.updateLanguage(language.getId(),language.getName(), language.getCreator(), language.getVersion());
            return "redirect:/languages";
        }
    }
    
    @RequestMapping(value="/languages/{id}", method=RequestMethod.DELETE)
    public String destroy(@PathVariable("id") Long id) {
        languageService.deleteLanguage(id);
        return "redirect:/languages";
    }
	
}
