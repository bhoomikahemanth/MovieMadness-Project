package com.movies.demo.Repository;


import com.movies.demo.module.Movie;
import org.springframework.stereotype.Service;
import org.sqlite.SQLiteConfig;

import java.sql.*;
import java.util.ArrayList;

@Service
public class MovieRepository {


    private Connection connectDB() {

        Connection con = null;

        try {
            Class.forName("org.sqlite.JDBC");
            SQLiteConfig config = new SQLiteConfig();
            config.enforceForeignKeys(true);
            con = DriverManager.getConnection("jdbc:sqlite:C:/Users/User/Downloads/MovieMadnessDB.db", config.toProperties());
        } catch (Exception ex) {
            System.out.println(ex.getClass());
            ex.printStackTrace();
        }
        return con;
    }



    public ArrayList<Movie> getmovies(Connection con) {

        ArrayList<Movie> all_movies = new ArrayList<>();
        Statement stmnt = null;

        try {
            String getBooksQuery = "SELECT movie_id , movie_title FROM tblMovies";
            stmnt = con.createStatement();
            ResultSet rs = stmnt.executeQuery(getBooksQuery);

            while (rs.next()) {
                Movie m = new Movie();
                m.setMovie_id(rs.getInt("movie_id"));
                m.setMovie_title(rs.getString("movie_title"));

                all_movies.add(m);
            }

        } catch (Exception ex) {
            System.out.println(ex.getClass());
            ex.printStackTrace();
        } finally {
            try {
                stmnt.close();
                con.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return all_movies;
    }


    public Connection getDBConnetion() {
        Connection con = connectDB();
      //  createTables(con);
        return con;
    }
}


