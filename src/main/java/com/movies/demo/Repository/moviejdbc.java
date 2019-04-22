package com.movies.demo.Repository;


import com.movies.demo.module.Movie;

public interface moviejdbc {
    Iterable<Movie> findAll();
    Movie findByid(int id);

   // Iterable<Actor> findCast(int movie_id);

}
