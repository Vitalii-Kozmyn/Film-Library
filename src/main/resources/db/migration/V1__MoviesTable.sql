CREATE TABLE IF NOT EXISTS movie (
    id BIGINT NOT NULL PRIMARY KEY,
    poster_path VARCHAR(300) NOT NULL,
    name VARCHAR(150) NOT NULL,
    release_date DATE NOT NULL,
    genre VARCHAR(50) NOT NULL,
    film_company VARCHAR(50) NOT NULL,
    actors VARCHAR(150) NOT NULL,
    IMDB DOUBLE NOT NULL CHECK (IMDB >= 0 AND IMDB <= 10),
    assessment DOUBLE NOT NULL CHECK (assessment >= 0 AND assessment <= 10)
)