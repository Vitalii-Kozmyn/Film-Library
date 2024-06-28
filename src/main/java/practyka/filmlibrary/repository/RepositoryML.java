package practyka.filmlibrary.repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import practyka.filmlibrary.model.Movie;

import java.sql.ResultSet;
import java.time.LocalDate;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

@Repository
@Qualifier("MovieRepository")
public class RepositoryML implements MovieRepository {

    private final JdbcTemplate jdbcTemplate;

    @Autowired
    public RepositoryML(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public void addMovie(Movie movie) {
        long id = ThreadLocalRandom.current().nextLong(Long.MAX_VALUE);
        jdbcTemplate.update(
                "INSERT INTO movie (id, name, release_date, genre, film_company, actors, IMDB, assessment) VALUES (?, ?, ?, ?, ?, ?, ?, ?)",
                 id, movie.getName(), movie.getRelease_date(), movie.getGenre(), movie.getFilm_company(), movie.getActors(), movie.getIMDB(), movie.getAssessment()
        );
    }

    @Override
    public Movie findID(Long id) {
        return jdbcTemplate.queryForObject(
                "SELECT * FROM movie WHERE id = ?",
                new Object[] {id}, (resultSet, i) -> {
                   Movie movie = new Movie(resultSet.getLong("id"), resultSet.getString("poster_path") , resultSet.getString("name"),
                           resultSet.getDate("release_date").toLocalDate(), resultSet.getString("genre"),
                           resultSet.getString("film_company"), resultSet.getString("actors"),
                           resultSet.getDouble("IMDB"), resultSet.getDouble("assessment"));
                    return movie;
                }
        );
    }

    @Override
    public List<Movie> allMovies() {
        final String sql = "SELECT * FROM movie";
        return jdbcTemplate.query(sql, (ResultSet resultSet, int i) -> {
            Long id = resultSet.getLong("id");
            String poster = resultSet.getString("poster_path");
            String name = resultSet.getString("name");
            LocalDate releaseDate = resultSet.getDate("release_date").toLocalDate();
            String genre = resultSet.getString("genre");
            String filmCompany = resultSet.getString("film_company");
            String actors = resultSet.getString("actors");
            double imdb = resultSet.getDouble("IMDB");
            double assessment = resultSet.getDouble("assessment");
            return new Movie(id, poster, name, releaseDate, genre, filmCompany, actors, imdb, assessment);
        });
    }
    @Override
    public void remove(Long id) {
        Object[] movie = new Object[] {id};
        jdbcTemplate.update("DELETE FROM movie WHERE id = ?", movie);
    }

    @Override
    public void removeAll() {
        jdbcTemplate.update("DROP TABLE movie");
    }

    @Override
    public void updateMovie(Long id, Movie update_movie) {
        jdbcTemplate.update("UPDATE movie SET name = ?, release_date = ?, genre = ?, film_company = ?, actors = ?, IMDB = ?, assessment = ? WHERE id = ?",
                update_movie.getName(), update_movie.getRelease_date(), update_movie.getGenre(), update_movie.getFilm_company(),
                update_movie.getActors(), update_movie.getIMDB(), update_movie.getAssessment(), id);
    }

    @Override
    public List<Movie> findByReleaseDate(LocalDate releaseDate) {
        return jdbcTemplate.query("SELECT * FROM movie WHERE release_date = ?",
                new BeanPropertyRowMapper<>(Movie.class), releaseDate);
    }

    @Override
    public List<Movie> findByActors(String actor) {
        return jdbcTemplate.query("SELECT * FROM movie WHERE actors LIKE ?",
                new BeanPropertyRowMapper<>(Movie.class), "%" + actor + "%");
    }

    @Override
    public List<Movie> findByProductionCompany(String film_company) {
        return jdbcTemplate.query("SELECT * FROM movie WHERE film_company = ?",
                new BeanPropertyRowMapper<>(Movie.class), film_company);
    }

    @Override
    public List<Movie> findByImdbRating(double minRating, double maxRating) {
        return jdbcTemplate.query("SELECT * FROM movie WHERE IMDB BETWEEN ? AND ?",
                new BeanPropertyRowMapper<>(Movie.class), minRating, maxRating);
    }

    @Override
    public List<Movie> findByUserRating(double minRating, double maxRating) {
        return jdbcTemplate.query("SELECT * FROM movie WHERE assessment BETWEEN ? AND ?",
                new BeanPropertyRowMapper<>(Movie.class), minRating, maxRating);
    }

    @Override
    public List<Movie> findByGenre(String genre) {
        return jdbcTemplate.query("SELECT * FROM movie WHERE genre = ?",
                new BeanPropertyRowMapper<>(Movie.class), genre);
    }
    public JdbcTemplate getJdbcTemplate() {
        return jdbcTemplate;
    }
}
