package DataAccessLayer;

import ApplicationLayer.DataTypes.Movie;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Created by Andrei on 29/09/2016.
 */
public class DBMovies {

    //gets connection from database class
    private static Connection conn = Database.getConn();
    private static PreparedStatement stmt = null;

    public ObservableList readAll() {
        ObservableList<Movie> movies = FXCollections.observableArrayList();
        movies.clear();
        try {
            String sql = "SELECT * FROM movies";

            stmt = conn.prepareStatement(sql);
            ResultSet rs = stmt.executeQuery(sql);

            while (rs.next()) {
                Movie movie = new Movie();
                movie.setMovie_id(rs.getInt("movie_id"));
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
            String sql = "insert into movies values\n" +
                    "(default,\"" + movie.getName() + "\",\"" + movie.getDuration() +
                    "\",\"" + movie.getPrice() + "\",\"" + movie.getActors() + "\",\"" + movie.getDescription()
                    + "\", ?, \"" + movie.getAgeLimit() + "\",\"" + movie.getGenre()
                    + "\",\"" + movie.getRating() + "\");";

            stmt = conn.prepareStatement(sql);
            stmt.setString(1, movie.getCoverPath());

            stmt.executeUpdate();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    public void update(Movie movie, String holdName) {
        try {
            String sql = "UPDATE movies SET movie_name = '" + movie.getName() + "', movie_duration = " + movie.getDuration() +
                    ", movie_price = " + movie.getPrice() + ", movie_actors = '" + movie.getActors() + "', movie_description = '" +
                    movie.getDescription() + "', movie_cover_path = ?, movie_age_limit = '" +
                    movie.getAgeLimit() + "', movie_genre = '" + movie.getGenre() + "', movie_rating = '" +
                    movie.getRating() + "' WHERE movie_name = '" + holdName + "';";

            stmt = conn.prepareStatement(sql);
            stmt.setString(1, movie.getCoverPath());

            stmt.executeUpdate();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    public void remove(Movie movie) {

        try {
            String sql = "delete from movies where movie_name=\"" + movie.getName() + "\"";
            stmt = conn.prepareStatement(sql);
            stmt.executeUpdate();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }
}