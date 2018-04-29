package com.example.forumthing.controllers;

import com.example.forumthing.models.data.ThreadDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.validation.Valid;

@Controller

@RequestMapping("thread")
public class ThreadController {

    @Autowired
    private ThreadDao threadDao;

    @RequestMapping(value="")
    public String index(Model model){

        model.addAttribute("threads", threadDao.findAll());
        model.addAttribute("title", "Posts");

        return "thread/index";
    }

    @RequestMapping(value = "add", method = RequestMethod.GET)
    public String add(Model model){

        model.addAttribute("thread", new Thread());
        model.addAttribute("title", "Reply");

        return "thread/reply";
    }

    @RequestMapping(value = "add", method = RequestMethod.POST)
    public String add(Model model, @ModelAttribute @Valid Thread thread, Errors errors) {

        if(errors.hasErrors() ){
            model.addAttribute("title", "Reply");
            return "category/add";
        }

        //threadDao.save(thread);
        return "redirect:";
    }

}