package com.movies.demo.module;

import lombok.Data;

@Data
public class Actor {

    private int actor_id;
    private String actor_name;
    private int actor_age;
    private String actor_gender;
    private String actor_profile_image;

    public int getActor_id() {
        return actor_id;
    }

    public void setActor_id(int actor_id) {
        this.actor_id = actor_id;
    }

    public String getActor_name() {
        return actor_name;
    }

    public void setActor_name(String actor_name) {
        this.actor_name = actor_name;
    }

    public int getActor_age() {
        return actor_age;
    }

    public void setActor_age(int actor_age) {
        this.actor_age = actor_age;
    }

    public String getActor_gender() {
        return actor_gender;
    }

    public void setActor_gender(String actor_gender) {
        this.actor_gender = actor_gender;
    }

    public String getActor_profile_image() {
        return actor_profile_image;
    }

    public void setActor_profile_image(String actor_profile_image) {
        this.actor_profile_image = actor_profile_image;
    }
}
