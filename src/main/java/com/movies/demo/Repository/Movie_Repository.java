package com.movies.demo.Repository;

import com.movies.demo.module.Movie;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;

@Repository
public class Movie_Repository implements moviejdbc {

    private JdbcTemplate jdbc;
   //private CastRepository c;
  // private  actorjdbc a;
    @Autowired
  public Movie_Repository(JdbcTemplate jdbc)
  {
      this.jdbc = jdbc;
   //   this.c=c;
    //  this.a=a;
  }
//end::classShell[]

    //tag::finders[]
    public Iterable<Movie> findAll() {
        return jdbc.query("SELECT * FROM tblMovies ", this::mapRowToMovie);
    }

    public Movie findByid(int id ) {

        return jdbc.queryForObject(
                "select * from tblMovies where movie_id=?",
                this::mapRowToMovie, id);
    }

   /* @Override
    public Iterable<Actor> findCast(int movie_id) {

        ArrayList<Actor> movie_cast= new ArrayList<>();
        for (Cast actor: c.findbymovie(movie_id)   ) {
          movie_cast.add(a.findBYid(actor.getActor_id()) );
        }
return  movie_cast;

    }
*/

    private Movie mapRowToMovie(ResultSet rs, int rowNum)
            throws SQLException {
        Movie m= new Movie();
        m.setMovie_id(rs.getInt("movie_id"));
        m.setMovie_title(rs.getString("movie_title"));
        m.setMovie_summery(rs.getString("movie_summary"));
        m.setMovie_duration(rs.getString("movie_duration"));
        m.setMovie_genre(rs.getString("movie_genre"));
        m.setMovie_release_date(rs.getString("movie_release_date"));
        m.setMovie_cover_image(rs.getString("movie_cover_image"));
        m.setMovie_trailer(rs.getString("movie_trailer"));


        return  m;
    }
}
