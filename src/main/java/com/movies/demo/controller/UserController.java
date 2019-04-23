package com.movies.demo.controller;

import com.movies.demo.Repository.Userjdbc;
import com.movies.demo.Repository.reviewJdbc;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class UserController {
    private final reviewJdbc jdbcreview;
    private  final Userjdbc userjdbc;
@Autowired
    public UserController(reviewJdbc jdbcreview, Userjdbc userjdbc) {
        this.jdbcreview = jdbcreview;
        this.userjdbc = userjdbc;
    }

    @GetMapping("/Allusers")
    public String user_displayAll(Model model){
        model.addAttribute("users",userjdbc.findAll() );
        return "AllUser";
    }
    @GetMapping("/user")
    public String user_display(@RequestParam(name ="id" , required = false, defaultValue = "1")int id, Model model){
        model.addAttribute("user",userjdbc.findByID(id) );

        model.addAttribute("reviews", jdbcreview.findByuser(id));
        return "User_pro";
    }
}
