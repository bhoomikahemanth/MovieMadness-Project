package com.movies.demo.Repository;


import com.movies.demo.module.Actor;
import com.movies.demo.module.Cast;
import com.movies.demo.module.Movie;

public interface Castjdbc {

    Iterable<Cast> findbymovie(int movie_id);
    Iterable<Cast> findbyactor(int actor_id);
    Iterable<Movie> findmovies(int id);
    Iterable<Actor> findCast(int movie_id);
}
