package practyka.filmlibrary.model;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.time.LocalDate;
public class Movie {
    private Long id;
    private String poster_path;
    private String name;
    private LocalDate release_date;
    private String genre;
    private String film_company;
    private String actors;
    private double IMDB;
    private double assessment;

    public Movie() {}

    public Movie(@JsonProperty("id") Long id,
                  @JsonProperty("poster_path") String poster_path,
                  @JsonProperty("name") String name,
                  @JsonProperty("date") LocalDate release_date,
                  @JsonProperty("genre") String genre,
                  @JsonProperty("film_company") String film_company,
                  @JsonProperty("actors") String actors,
                  @JsonProperty("IMDB") double IMDB,
                  @JsonProperty("assessment") double assessment) {
        this.id = id;
        this.poster_path = poster_path;
        this.name = name;
        this.release_date = release_date;
        this.genre = genre;
        this.film_company = film_company;
        this.actors = actors;
        this.IMDB = IMDB;
        this.assessment = assessment;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getPoster_path() {
        return poster_path;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public LocalDate getRelease_date() {
        return release_date;
    }

    public void setRelease_date(LocalDate release_date) {
        this.release_date = release_date;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public String getFilm_company() {
        return film_company;
    }

    public void setFilm_company(String film_company) {
        this.film_company = film_company;
    }

    public String getActors() {
        return actors;
    }

    public void setActors(String actors) {
        this.actors = actors;
    }

    public double getIMDB() {
        return IMDB;
    }

    public void setIMDB(double IMDB) {
        this.IMDB = IMDB;
    }

    public double getAssessment() {
        return assessment;
    }

    public void setAssessment(double assessment) {
        this.assessment = assessment;
    }
}
