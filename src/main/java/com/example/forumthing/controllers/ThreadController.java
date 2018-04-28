package com.example.forumthing.controllers;

import com.example.forumthing.models.NewPost;
import com.example.forumthing.models.Reply;
import com.example.forumthing.models.data.ThreadDao;
import com.example.forumthing.models.data.ReplyDao;
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

    @RequestMapping(value = "")
    public String index(Model model) {
        model.addAttribute("title", "Posts");
        model.addAttribute("Thread", threadDao.findAll());

        return "thread/index";
    }

    @RequestMapping(value = "submit", method = RequestMethod.GET)
    public String submit (Model model) {
        model.addAttribute("title", "Reply");
        model.addAttribute(new Reply());
        return "reply/submit";
    }

    @RequestMapping(value = "submit", method = RequestMethod.POST)
    public String submit (Model model, @ModelAttribute @Valid Reply reply, Errors errors) {

        if (errors.hasErrors()) {
            model.addAttribute("title", "Submit Reply");
            return "reply/submit";
        }

        threadDao.save(thread);

        return "redirect:view/" + reply.getId();
    }

    @RequestMapping(value = "view/{newpostId}", method = RequestMethod.GET)
    public String viewNewpost(Model model, @PathVariable int newpostId) {

        NewPost newpost = Reply.findOne(replyId);
        model.addAttribute("reply", reply);

        return "thread/view";
    }

}