package com.movies.demo.Repository;


import com.movies.demo.module.User;

public interface Userjdbc {

    Iterable<User> findAll();
    User findByID(int id);
}
