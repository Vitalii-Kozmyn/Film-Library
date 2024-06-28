package practyka.filmlibrary.controllers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import practyka.filmlibrary.model.Movie;
import practyka.filmlibrary.service.MovieService;
import java.time.LocalDate;
import java.util.List;

@RequestMapping("/api/app")
@RestController
public class Controller {
    private MovieService movieService;

    @Autowired
    public Controller(MovieService movieService) {
        this.movieService = movieService;
    }

    @PostMapping("/add")
    public void addMovie(@RequestBody Movie movie) {
        movieService.addMovie(movie);
    }

    @GetMapping(path = "/{id}")
    public Movie findID(@PathVariable("id") Long id) {
        return movieService.findID(id);
    }

    @GetMapping("/all")
    public List<Movie> allMovies() {
        return movieService.allMovies();
    }

    @DeleteMapping(path = "/{id}")
    public void remove(@PathVariable("id") Long id) {
        movieService.remove(id);
    }

    @DeleteMapping("/all")
    public void removeAll() {
        movieService.removeAll();
    }

    @PutMapping("/{id}")
    public void updateMovie(@PathVariable("id") Long id, @RequestBody Movie update_movie) {
        movieService.updateMovie(id, update_movie);
    }

    @GetMapping("/release/{release_date}")
    public List<Movie> findByReleaseDate(@PathVariable("release_date") LocalDate release_date) {
        return movieService.findByReleaseDate(release_date);
    }

    @GetMapping("/actor/{actor}")
    public List<Movie> findByActors(@PathVariable("actor") String actor) {
        return movieService.findByActors(actor);
    }

    @GetMapping(path = "/company/{company}")
    public List<Movie> findByProductionCompany(@PathVariable("company") String company) {
        return movieService.findByProductionCompany(company);
    }

    @GetMapping("/IMDB/{minRating}/{maxRating}")
    public List<Movie> findByImdbRating(@PathVariable("minRating") double minRating, @PathVariable("maxRating") double maxRating) {
        return movieService.findByImdbRating(minRating, maxRating);
    }

    @GetMapping("/rating/{minRating}/{maxRating}")
    public List<Movie> findByUserRating(@PathVariable("minRating") double minRating, @PathVariable("maxRating") double maxRating) {
        return movieService.findByUserRating(minRating, maxRating);
    }

    @GetMapping(path = "/genre/{genre}")
    public List<Movie> findByGenre(@PathVariable("genre") String genre) {
        return movieService.findByGenre(genre);
    }
}
