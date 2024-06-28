package practyka.filmlibrary.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import practyka.filmlibrary.model.Movie;
import practyka.filmlibrary.service.MovieService;

@Controller
public class WebController {
    @Autowired
    private MovieService movieService;
    @GetMapping("/")
    public String home(Model model) {
        Iterable<Movie> movies = movieService.allMovies();
        model.addAttribute("Movies", movies);
        return "home";
    }
}
