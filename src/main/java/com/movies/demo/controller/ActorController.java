package com.movies.demo.controller;

import com.movies.demo.Repository.Castjdbc;
import com.movies.demo.Repository.actorjdbc;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class ActorController {

    private final actorjdbc actorsview;
    private final Castjdbc castjdbc;

    @Autowired
    public ActorController(actorjdbc actorsview, Castjdbc castjdbc) {
        this.actorsview = actorsview;
        this.castjdbc = castjdbc;
    }

    @GetMapping("/viewActors")
    public String Actor_displayall(Model model){
        model.addAttribute("all_actor",actorsview.findAll() );
        return "viewActors";

    }

    @GetMapping("/viewActorPage")
    public String Actor_display(@RequestParam(name ="id" , required = false, defaultValue = "1")int id, Model model){
        model.addAttribute("actor",actorsview.findBYid(id) );
        model.addAttribute("movies",castjdbc.findmovies(id));
        return "viewActorPage";

    }
}
