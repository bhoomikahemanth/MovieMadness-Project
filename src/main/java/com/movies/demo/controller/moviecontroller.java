package com.movies.demo.controller;


import com.movies.demo.Repository.*;
import com.movies.demo.module.Movie;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.thymeleaf.expression.Lists;

import java.util.List;

@Controller
//@RequestMapping("/movies")
public class moviecontroller {
    //MovieRepository movieRepo = new MovieRepository();
   private final moviejdbc jdbcRepos ;
   private final reviewJdbc jdbcreview;
   private final actorjdbc actorsview;
   private final Castjdbc castjdbc;
  // private  final Userjdbc userjdbc;

    @Autowired
    public moviecontroller( Movie_Repository jdbcRepos, Castjdbc castjdbc , reviewJdbc jdbcreview, actorjdbc actorsview)
    {
        this.jdbcRepos= jdbcRepos;
        this.jdbcreview= jdbcreview;
        this.actorsview= actorsview;
        this.castjdbc=castjdbc;
      //  this.userjdbc= userjdbc;
    }
    @GetMapping("/viewMovies")
    public String display (Model model){
//model.addAttribute("movies", movieRepo.getmovies(movieRepo.getDBConnetion()));
     //   List<Movie> ingredients = Lists.newArrayList(jdbcRepos.findAll());

        model.addAttribute("movie", jdbcRepos.findAll());
        return "viewMovies";
    }
    @GetMapping("/amovie")
    public String showamovie(@RequestParam(name ="id" , required = false, defaultValue = "1")int id, Model model  )
        {

model.addAttribute("data", jdbcRepos.findByid(id));
model.addAttribute("review", jdbcreview.findBymovie(id));

model.addAttribute("cast",castjdbc.findCast(id));
            return"amovie";
        }






}
