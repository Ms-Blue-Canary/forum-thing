package com.example.forumthing.controllers;

import com.example.forumthing.models.NewPost;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.validation.Valid;

@Controller
@RequestMapping("home")
public class Home {

    //@Autowired
    //private CheeseDao cheeseDao;

    //@Autowired
    //private MenuDao menuDao;

    @RequestMapping(value = "")
    public String index(Model model) {
        model.addAttribute("title", "Posts");
        //model.addAttribute("menus", menuDao.findAll());

        return "home/index";
    }

    @RequestMapping(value = "submit", method = RequestMethod.GET)
    public String add (Model model) {
        model.addAttribute("title", "New Post");
        model.addAttribute(new NewPost());
        return "newpost/submit";
    }

    @RequestMapping(value = "submit", method = RequestMethod.POST)
    public String add (Model model, @ModelAttribute @Valid NewPost newpost, Errors errors) {

        if (errors.hasErrors()) {
            model.addAttribute("title", "Add Menu");
            return "newpost/submit";
        }

        homeDao.save(home);

        return "redirect:view/" + newpost.getId();
    }

    @RequestMapping(value = "view/{menuId}", method = RequestMethod.GET)
    public String viewMenu(Model model, @PathVariable int menuId) {

        Menu menu = menuDao.findOne(menuId);
        model.addAttribute("menu", menu);

        //model.addAttribute("menuId", menu.getId());
        //model.addAttribute("title", menu.getName());
        //model.addAttribute("cheeses", menu.getCheese());

        return "menu/view";
    }

    @RequestMapping(value = "add-item/{menuId}", method = RequestMethod.GET)
    public String addItem(Model model, @PathVariable int menuId) {

        Menu menu = menuDao.findOne(menuId);
        AddMenuItemForm form = new AddMenuItemForm(cheeseDao.findAll(), menu);

        model.addAttribute("title", "Add Item to Menu:" + menu.getName());
        model.addAttribute("form", form);

        return "menu/add-item";
    }

    @RequestMapping(value = "add-item/{menuId}", method = RequestMethod.POST)
    public String addItem(Model model, @ModelAttribute @Valid AddMenuItemForm form, Errors errors) {

        if (errors.hasErrors()) {
            model.addAttribute("form", form);
            return "menu/add-item";
        }

        //Cheese theCheese = cheeseDao.findOne(form.getCheeseId());
        //Menu theMenu = menuDao.findOne(form.getMenuId());
        //theMenu.addItem(theCheese);
        //Menu save = menuDao.save(theMenu);
        //return "redirect:/menu/view/" + theMenu.getId();
    }
}