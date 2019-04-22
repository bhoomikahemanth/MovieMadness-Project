package com.movies.demo.Repository;

import com.movies.demo.module.Review;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
@Repository
public class reviewRepository implements reviewJdbc {


    private JdbcTemplate jdbc;

    @Autowired
    public reviewRepository(JdbcTemplate jdbc) {
        this.jdbc = jdbc;
    }


    @Override
    public Iterable<Review> findAll() {
        return jdbc.query("select * from tblReviews ", this::mapRowToReview);
    }


    @Override
    public Iterable<Review> findBymovie(int movie_id) {
        return jdbc.query(
                "select * from tblReviews where movie_id=?",
                this::mapRowToReview,movie_id);    }


    @Override
    public Iterable<Review> findByuser(int user_id) {
        return  jdbc.query(
                "select * from tblReviews where user_id=?",
                this::mapRowToReview,user_id);    }

    private Review mapRowToReview(ResultSet rs, int rowNum)
            throws SQLException {
        Review review= new Review();
        review.setReview_id(rs.getInt("review_id"));
        review.setUser_id(rs.getInt("user_id"));
        review.setMovie_id(rs.getInt("movie_id"));
        review.setReview_comment(rs.getString("review_comment"));
        review.setReview_rating(rs.getInt("review_rating"));
        review.setReview_date(rs.getString("review_date"));
        return  review;
    }
}
