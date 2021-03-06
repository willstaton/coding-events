package org.launchcode.codingevents.controllers;

import org.launchcode.codingevents.data.TagRepository;
import org.launchcode.codingevents.models.EventCategory;
import org.launchcode.codingevents.models.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.validation.Valid;

@Controller
@RequestMapping("tags")
public class TagController {

    @Autowired
    private TagRepository tagRepository;

    @GetMapping
    public String displayAllTags(Model model) {
        model.addAttribute("title", "All Tags");
        model.addAttribute("tags", tagRepository.findAll());
        return "tags/index";
    }

    @GetMapping("create")
    public String displayCreateTagForm(Model model, @ModelAttribute Tag tag) {
        model.addAttribute("title", "Create Tag");
        return "tags/create";
    }

    @PostMapping("create")
    public String processCreateEventCategoryForm(Model model, @ModelAttribute @Valid Tag tag, Errors errors) {
        model.addAttribute("title", "Create Tag");
        if (errors.hasErrors()) {
            return "tags/create";
        } else {
            tagRepository.save(tag);
            return "redirect:";
        }
    }
}
