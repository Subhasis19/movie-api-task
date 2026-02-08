package com.subhasis.movieapi;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import jakarta.validation.Valid;

import java.util.ArrayList;
import java.util.List;

@RestController // This tells Spring "This class handles Web Requests"
@RequestMapping("/movies") // All URLs will start with /movies
public class MovieController {

    // REQUIREMENT: "Implement an in-memory data store... You can use an ArrayList"
    private List<Movie> movieList = new ArrayList<>();

    // We need a simple counter to give every movie a unique ID (1, 2, 3...)
    private long currentId = 1;

    // --- ENDPOINT 1: Add a new Item ---
    // REQUIREMENT: "Add a new item" & "Input Validation"
    @PostMapping
    public ResponseEntity<String> addMovie(@Valid @RequestBody Movie movie) {
        // 1. Assign the ID
        movie.setId(currentId++);

        // 2. Add to our ArrayList
        movieList.add(movie);

        // 3. Return success message
        return new ResponseEntity<>("Movie added successfully with ID: " + movie.getId(), HttpStatus.CREATED);
    }

    // --- ENDPOINT 2: Get a single item by ID ---
    // REQUIREMENT: "Get a single item by ID"
    @GetMapping("/{id}")
    public ResponseEntity<Movie> getMovieById(@PathVariable Long id) {
        // Loop through the list to find the movie (Simple Java Logic)
        for (Movie m : movieList) {
            if (m.getId().equals(id)) {
                return new ResponseEntity<>(m, HttpStatus.OK);
            }
        }

        // If we finish the loop and find nothing, return 404 Not Found
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    // --- BONUS: Get All Movies (Helpful for you to test) ---
    @GetMapping
    public List<Movie> getAllMovies() {
        return movieList;
    }
}