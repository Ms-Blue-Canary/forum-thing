package com.example.forumthing.controllers;

mport org.springframework.beans.factory.annotation.Autowired;
import com.example.forumthing.models.NewPost;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import javax.validation.Valid;

@Controller
@RequestMapping("newpost")
public class NewPostController {

    @Autowired
    private NewPostDao newpostDao;

    @RequestMapping(value = "")
    public String index(Model model) {

        model.addAttribute("newpost", newpostDao.findAll());
        model.addAttribute("title", "Posts");

        return "newpost/index";
    }

    @RequestMapping(value = "submit", method = RequestMethod.GET)
    public String displaysubmitNewPostForm(Model model) {
        model.addAttribute("title", "Submit");
        model.addAttribute(new NewPost());

        return "newpost/submit";
    }

    @RequestMapping(value = "submit", method = RequestMethod.POST)
    public String processSubmitNewPostForm(@ModelAttribute  @Valid NewPost newNewPost,
                                       Errors errors, Model model) {

        if (errors.hasErrors()) {
            model.addAttribute("title", "Submit");

            return "newpost/submit";
        }
        newpostDao.save(newNewPost);

        return "redirect:";
    }

}