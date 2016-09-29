package DataAccessLayer;

import ApplicationLayer.DataTypes.Movie;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

/**
 * Created by Andrei on 29/09/2016.
 */
public class DBMovies {

    //gets connection from database class
    private static Connection conn = Database.getConn();
    private static Statement stmt = null;

    public ArrayList readAll() {
        ArrayList<Movie> movies = new ArrayList<>();
        movies.clear();
        try {
            String sql = "SELECT * FROM movies";

            stmt = conn.createStatement();

            ResultSet rs = stmt.executeQuery(sql);

            while(rs.next()){
                Movie movie = new Movie();
                movie.setName(rs.getString("movie_name"));
                movie.setDuration(rs.getInt("movie_duration"));
                movie.setPrice(rs.getDouble("movie_price"));
                movie.setActors(rs.getString("movie_actors"));
                movie.setDescription(rs.getString("movie_description"));
                movie.setCoverPath(rs.getString("movie_cover_path"));
                movie.setAgeLimit(rs.getString("movie_age_limit"));
                movie.setGenre(rs.getString("movie_genre"));
                movie.setRating(rs.getString("movie_rating"));

                movies.add(movie);
            }
        }catch(SQLException e){
            e.printStackTrace();
        }
        return movies;
    }

    public void insert(Movie movie) {

        Connection conn = Database.getConn();
        try {
            stmt = conn.createStatement();
            String sql = "insert into movies values\n" +
                    "(default,\""+movie.getName()+"\",\""+movie.getDuration()+
                    "\",\""+movie.getPrice()+"\",\""+movie.getActors()+"\",\""+movie.getDescription()
                    +"\",\""+movie.getCoverPath()+"\",\""+movie.getAgeLimit()+"\",\""+movie.getGenre()
                    +"\",\""+movie.getRating()+"\")";

            stmt.executeUpdate(sql);
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }
}
