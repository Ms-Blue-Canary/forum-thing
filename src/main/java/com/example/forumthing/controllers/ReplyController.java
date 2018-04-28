package com.example.forumthing.controllers;

import com.example.forumthing.models.NewPost;
import com.example.forumthing.models.data.ReplyDao;
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
@RequestMapping("reply")

public class ReplyController {

    @Autowired
    private ReplyDao replyDao;

    @RequestMapping(value = "")
    public String index(Model model) {

        model.addAttribute("reply", replyDao.findAll());
        model.addAttribute("title", "Posts");

        return "reply/index";
    }

    @RequestMapping(value = "submit", method = RequestMethod.GET)
    public String displaysubmitReplyForm(Model model) {
        model.addAttribute("title", "Submit");
        model.addAttribute(new NewPost());

        return "reply/submit";
    }

    @RequestMapping(value = "submit", method = RequestMethod.POST)
    public String processSubmitReplyForm(@ModelAttribute  @Valid NewPost newReply,
                                           Errors errors, Model model) {

        if (errors.hasErrors()) {
            model.addAttribute("title", "Submit");

            return "reply/submit";
        }

        //replyDao.save(newReply);

        return "redirect:";
    }


}
