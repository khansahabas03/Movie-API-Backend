package dev.mov.movies;

import lombok.Data;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
@Data
@RestController
@RequestMapping("/api/v1/movies")
public class MovieController {
    @Autowired
    private MovieService movieService;

    @GetMapping
    public ResponseEntity<List<Movie>> getAllMovies() {
        return ResponseEntity.ok(movieService.allMovies());
    }

    @GetMapping("/{imdbId}")
    public ResponseEntity<Optional<Movie>> getMovie(@PathVariable String imdbId) {
        return ResponseEntity.ok(movieService.singleMovie(imdbId));
    }

    @PostMapping
    public ResponseEntity<Movie> createMovie(@RequestBody Movie movie) {
        return new ResponseEntity<>(movieService.createMovie(movie), HttpStatus.CREATED);
    }

    @PutMapping("/{imdbId}")
    public ResponseEntity<Movie> updateMovie(@PathVariable String imdbId, @RequestBody Movie movie) {
        return ResponseEntity.ok(movieService.updateMovie(imdbId, movie));
    }

    @DeleteMapping("/{imdbId}")
    public ResponseEntity<Void> deleteMovie(@PathVariable String imdbId) {
        movieService.deleteMovie(imdbId);
        return ResponseEntity.noContent().build();
    }
}
