package com.movieflix.entities;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.Set;

@Entity   // maps the class to the table in the databas
@NoArgsConstructor
@AllArgsConstructor
@Getter
public class Movie {
    @Id  // specifies the primary key of an entity
    @GeneratedValue(strategy = GenerationType.IDENTITY)  // auto-generates the value for the primary key
    private Integer movieId;

    @Column(nullable = false)
    @NotBlank(message = "Please provide movie title")
    private String title;

    @Column(nullable = false)
    @NotBlank(message = "Please provide movie director")
    private String director;

    @Column(nullable = false)
    @NotBlank(message = "Please provide movie studio")
    private String studio;

    @ElementCollection
    @CollectionTable(name = "movie_cast")  // specifies the table that is used for the mapping
    private Set<String> movieCast;

    @Column(nullable = false)
    @NotBlank(message = "Please provide movie release year")
    private Integer releaseYear;

    @Column(nullable = false)
    @NotBlank(message = "Please provide movie poster")
    private String poster;
}