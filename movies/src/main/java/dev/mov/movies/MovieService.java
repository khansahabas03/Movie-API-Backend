package dev.mov.movies;

import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MovieService {
    @Autowired
    private MovieRepository movieRepository;

    public List<Movie> allMovies() {
        return movieRepository.findAll();
    }

    public Optional<Movie> singleMovie(String imdbId) {
        return movieRepository.findByImdbId(imdbId);
    }

    public Movie createMovie(Movie movie) {
        return movieRepository.save(movie);
    }

    public Movie updateMovie(String imdbId, Movie updatedMovie) {
        Movie existing = movieRepository.findByImdbId(imdbId).orElseThrow();

        existing.setTitle(updatedMovie.getTitle());
        existing.setReleaseDate(updatedMovie.getReleaseDate());
        existing.setPoster(updatedMovie.getPoster());
        existing.setTrailerLink(updatedMovie.getTrailerLink());
        existing.setGenres(updatedMovie.getGenres());
        existing.setBackdrops(updatedMovie.getBackdrops());

        return movieRepository.save(existing);
    }

    public void deleteMovie(String imdbId) {
        movieRepository.deleteByImdbId(imdbId);
    }
}
