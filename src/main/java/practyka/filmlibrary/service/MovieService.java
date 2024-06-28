package practyka.filmlibrary.service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import practyka.filmlibrary.model.Movie;
import practyka.filmlibrary.repository.MovieRepository;
import java.time.LocalDate;
import java.util.List;

@Service
public class MovieService {
    private final MovieRepository movieRepository;
    @Autowired
    public MovieService(@Qualifier("MovieRepository") MovieRepository movieRepository) {
        this.movieRepository = movieRepository;
    }
    public void addMovie(Movie movie) {
        movieRepository.addMovie(movie);
    }

    public Movie findID(Long id) {
        return movieRepository.findID(id);
    }

    public List<Movie> allMovies() {
        return movieRepository.allMovies();
    }

    public void remove(Long id) {
        movieRepository.remove(id);
    }

    public void removeAll() {
        movieRepository.removeAll();
    }

    public void updateMovie(Long id, Movie update_movie) {
        movieRepository.updateMovie(id, update_movie);
    }

    public List<Movie> findByReleaseDate(LocalDate release_date) {
        return movieRepository.findByReleaseDate(release_date);
    }

    public List<Movie> findByActors(String actor) {
        return movieRepository.findByActors(actor);
    }

    public List<Movie> findByProductionCompany(String company) {
        return movieRepository.findByProductionCompany(company);
    }

    public List<Movie> findByImdbRating(double minRating, double maxRating) {
        return movieRepository.findByImdbRating(minRating, maxRating);
    }

    public List<Movie> findByUserRating(double minRating, double maxRating) {
        return movieRepository.findByUserRating(minRating, maxRating);
    }

    public List<Movie> findByGenre(String genre) {
        return movieRepository.findByGenre(genre);
    }
}
