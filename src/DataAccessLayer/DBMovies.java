package DataAccessLayer;

import ApplicationLayer.DataTypes.Movie;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * Created by Andrei on 29/09/2016.
 */
public class DBMovies {

    //gets connection from database class
    private static Connection conn = Database.getConn();
    private static Statement stmt = null;

    public ObservableList readAll() {
        ObservableList<Movie> movies = FXCollections.observableArrayList();
        movies.clear();
        try {
            String sql = "SELECT * FROM movies";

            stmt = conn.createStatement();

            ResultSet rs = stmt.executeQuery(sql);

            while (rs.next()) {
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
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return movies;
    }

    public void insert(Movie movie) {

        try {
            stmt = conn.createStatement();
            String sql = "insert into movies values\n" +
                    "(default,\"" + movie.getName() + "\",\"" + movie.getDuration() +
                    "\",\"" + movie.getPrice() + "\",\"" + movie.getActors() + "\",\"" + movie.getDescription()
                    + "\",\"" + movie.getCoverPath() + "\",\"" + movie.getAgeLimit() + "\",\"" + movie.getGenre()
                    + "\",\"" + movie.getRating() + "\");";
            stmt.executeUpdate(sql);
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    public void update(Movie movie, String holdName) {
        try {
            stmt = conn.createStatement();
            String sql = "UPDATE movies SET movie_name = '" + movie.getName() + "', movie_duration = " + movie.getDuration() +
                    ", movie_price = " + movie.getPrice() + ", movie_actors = '" + movie.getActors() + "', movie_description = '" +
                    movie.getDescription() + "', movie_cover_path = '" + movie.getCoverPath() + "', movie_age_limit = '" +
                    movie.getAgeLimit() + "', movie_genre = '" + movie.getGenre() + "', movie_rating = '" +
                    movie.getRating() + "' WHERE movie_name = '" + holdName + "';";

            stmt.executeUpdate(sql);
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    public void remove(Movie movie) {

        try {
            stmt = conn.createStatement();
            String sql = "delete from movies where movie_name=\"" + movie.getName() + "\"";
            stmt.executeUpdate(sql);
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }
}
