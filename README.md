# Movie Management API

This is a RESTful API built with Java Spring Boot for managing a collection of movies. It serves as a backend assignment implementation.

## Features
* **Add Movie:** Create new movie records with validation.
* **Get Movie:** Retrieve movie details by ID.
* **In-Memory Storage:** Uses an `ArrayList` for temporary data persistence.
* **Validation:** Ensures data integrity (e.g., non-empty titles, valid years).

## Tech Stack
* Java 17
* Spring Boot 3.x
* Maven

## API Endpoints

### 1. Add a New Movie
* **URL:** `/movies`
* **Method:** `POST`
* **Content-Type:** `application/json`
* **Body Example:**
    ```json
    {
      "title": "Inception",
      "description": "A thief who steals corporate secrets through the use of dream-sharing technology.",
      "releaseYear": 2010
    }
    ```
* **Constraints:**
    * `title`: Required.
    * `description`: Must be at least 5 characters.
    * `releaseYear`: Must be after 1900.

### 2. Get a Movie by ID
* **URL:** `/movies/{id}`
* **Method:** `GET`
* **Example:** `/movies/1`
* **Response:** Returns the JSON object of the movie.

## How to Run Locally
1.  Clone the repository.
2.  Open the project in your IDE (IntelliJ/Eclipse).
3.  Run the `MovieApiApplication` class.
   4.  The server will start on `http://localhost:8080`.