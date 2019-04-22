package com.movies.demo.Repository;

import com.movies.demo.module.Actor;

public interface actorjdbc {
    Iterable<Actor> findAll();
    Iterable<Actor> findBygender(String gender);
    Iterable<Actor> findByname(String actor_name);
    Actor findBYid(int id);
}
