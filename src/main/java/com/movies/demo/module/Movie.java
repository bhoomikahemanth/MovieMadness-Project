package com.movies.demo.module;

import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.ArrayList;

@Component
@Data
@RequiredArgsConstructor
public class Movie {

private int movie_id;
private  String movie_title;
private String movie_summery;
private  String movie_duration;
private  String movie_genre;
private String movie_release_date;
private String movie_cover_image;
private  String movie_trailer;
ArrayList<Review> m_review= new ArrayList<>();

    public int getMovie_id() {
        return movie_id;
    }

    public void setMovie_id(int movie_id) {
        this.movie_id = movie_id;
    }

    public String getMovie_title() {
        return movie_title;
    }

    public void setMovie_title(String movie_title) {
        this.movie_title = movie_title;
    }

    public String getMovie_summery() {
        return movie_summery;
    }

    public void setMovie_summery(String movie_summery) {
        this.movie_summery = movie_summery;
    }

    public String getMovie_duration() {
        return movie_duration;
    }

    public void setMovie_duration(String movie_duration) {
        this.movie_duration = movie_duration;
    }

    public String getMovie_genre() {
        return movie_genre;
    }

    public void setMovie_genre(String movie_genre) {
        this.movie_genre = movie_genre;
    }

    public String getMovie_release_date() {
        return movie_release_date;
    }

    public void setMovie_release_date(String movie_release_date) {
        this.movie_release_date = movie_release_date;
    }

    public String getMovie_cover_image() {
        return movie_cover_image;
    }

    public void setMovie_cover_image(String movie_cover_image) {
        this.movie_cover_image = movie_cover_image;
    }

    public String getMovie_trailer() {
        return movie_trailer;
    }

    public void setMovie_trailer(String movie_trailer) {
        this.movie_trailer = movie_trailer;
    }

    public ArrayList<Review> getM_review() {
        return m_review;
    }

    public void setM_review(ArrayList<Review> m_review) {
        this.m_review = m_review;
    }
}

