package com.example.forumthing.controllers;

import com.example.forumthing.models.Home;
import com.example.forumthing.models.NewPost;
import com.example.forumthing.models.data.HomeDao;
import com.example.forumthing.models.data.NewPostDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.example.forumthing.models.data.HomeDao;
import com.example.forumthing.models.data.NewPostDao;

import javax.validation.Valid;
import javax.xml.crypto.dsig.Reference;

@Controller
@RequestMapping("home")
public class HomeController {

    @Autowired
    private HomeDao homeDao;
    private NewPost newpost;

    @RequestMapping(value = "")
    public String index(Model model) {
        model.addAttribute("title", "Posts");
        model.addAttribute("home", homeDao.findAll());

        return "home/index";
    }

    @RequestMapping(value = "submit", method = RequestMethod.GET)
    public String displaySubmitNewPostForm (Model model) {
        model.addAttribute("title", "Submit New Post");
        model.addAttribute(new NewPost());

        return "newpost/submit";
    }

    @RequestMapping(value = "submit", method = RequestMethod.POST)
    public String processSubmitNewPostForm (Model model, @ModelAttribute @Valid NewPost NewNewPost, Errors errors) {

        if (errors.hasErrors()) {
            model.addAttribute("title", "Submit New Post");
            return "newpost/submit";
        }

        newpostDao.save(newpost);

        return "redirect:view/" + newpost.getId();
    }

    @RequestMapping(value = "view/{newpostId}", method = RequestMethod.GET)
    public String viewNewpost(Model model, @PathVariable int newpostId) {

        NewPost newpost = NewPostDao.findOne(newpostId);
        model.addAttribute("newpost", newpost);

        return "home/view";
    }
}