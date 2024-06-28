package practyka.filmlibrary.repository;
import practyka.filmlibrary.model.Movie;

import java.time.LocalDate;
import java.util.List;

public interface MovieRepository {
    void addMovie(Movie movie);
    Movie findID(Long id);
    List<Movie> allMovies();
    void remove(Long id);
    void removeAll();
    void updateMovie(Long id, Movie update_movie);
    List<Movie> findByReleaseDate(LocalDate release_date);
    List<Movie> findByActors(String actor);
    List<Movie> findByProductionCompany(String company);
    List<Movie> findByImdbRating(double minRating, double maxRating);
    List<Movie> findByUserRating(double minRating, double maxRating);
    List<Movie> findByGenre(String genre);
}
