package com.movies.demo.Repository;


import com.movies.demo.module.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
@Repository
public class UserReposiory implements Userjdbc {

    private JdbcTemplate jdbc;
private  reviewJdbc rev;

    @Autowired
    public UserReposiory(JdbcTemplate jdbc)
    {
        this.jdbc = jdbc;
        //  this.c= c;
        // this.m=m;
    }
    @Override
    public Iterable<User> findAll() {
        return jdbc.query("SELECT * FROM tblUsers", this::mapRowToUser);

    }

    @Override
    public User findByID(int id) {
        return  jdbc.queryForObject("SELECT * FROM tblUsers Where user_id=? ", this::mapRowToUser, id);
    }

   /* @Override
    public Iterable<Review> findallreviewsbyid(int user_id) {
        //return jdbc.query("SELECT * FROM tblReviews where user_id=?", this::mapRowToUser, user_id);


    }
*/
    private User mapRowToUser(ResultSet rs, int rowNum)
            throws SQLException {
        User user= new User();
        user.setUser_id(rs.getInt("user_id"));
        user.setUser_name(rs.getString("username"));
        user.setPassword(rs.getString("password"));
        user.setUser_name(rs.getString("user_name"));
        user.setUser_age(rs.getInt("user_age"));
        user.setUser_email(rs.getString("user_email"));
        user.setUser_join_date(rs.getString("user_join_date"));
        return  user;
    }


}
