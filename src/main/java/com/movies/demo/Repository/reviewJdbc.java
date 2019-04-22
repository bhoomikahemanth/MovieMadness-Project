package com.movies.demo.Repository;

import com.movies.demo.module.Review;

public interface reviewJdbc {
    Iterable<Review> findAll();
    Iterable<Review>  findBymovie(int movie_id);
    Iterable<Review>  findByuser(int user_id);

}
