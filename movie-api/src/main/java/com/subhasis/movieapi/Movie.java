package com.subhasis.movieapi;

// These imports are for validation (Requirement #3)
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;

public class Movie {

    private Long id;

    // VALIDATION: The title cannot be empty
    @NotEmpty(message = "Movie title is required")
    private String title;

    // VALIDATION: Description must be at least 5 characters
    @Size(min = 5, message = "Description must be at least 5 characters")
    private String description;

    // VALIDATION: Year must be valid (e.g., after 1900)
    @Min(value = 1900, message = "Release year must be after 1900")
    private int releaseYear;

    // --- CONSTRUCTORS ---
    // Empty constructor is needed by Spring
    public Movie() {}

    public Movie(Long id, String title, String description, int releaseYear) {
        this.id = id;
        this.title = title;
        this.description = description;
        this.releaseYear = releaseYear;
    }

    // --- GETTERS AND SETTERS ---
    // These allow the code to read and write the data
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getTitle() { return title; }
    public void setTitle(String title) { this.title = title; }

    public String getDescription() { return description; }
    public void setDescription(String description) { this.description = description; }

    public int getReleaseYear() { return releaseYear; }
    public void setReleaseYear(int releaseYear) { this.releaseYear = releaseYear; }
}