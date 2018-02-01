package com.cy.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.validation.Valid;

@Controller
public class RedditCloneController {

    @Autowired
    RedditCloneRepository redditcloneRepository;

    @RequestMapping("/")
    public String listRedditClones(Model model){
        model.addAttribute("redditclones", redditcloneRepository.findAll());
        return "list";
    }

    @GetMapping("/add")
    public String redditcloneForm(Model model){
        model.addAttribute("redditclone", new RedditClone());
        return "redditcloneform";
    }

    @PostMapping("/process")
    public String processForm(@Valid RedditClone redditclone, BindingResult result)
    {
        if (result.hasErrors()){
            return "redditcloneform";
        }
        redditcloneRepository.save(redditclone);
        return "redirect:/";
    }

    @RequestMapping("/detail")
    public String showRedditClone(@PathVariable("id")  long id, Model model)
    {
        model.addAttribute("redditclone", redditcloneRepository.findAll());
        return "show";
    }



}
