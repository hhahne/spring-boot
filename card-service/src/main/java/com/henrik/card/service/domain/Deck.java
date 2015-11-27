package com.henrik.card.service.domain;

/**
 *
 */

import javax.persistence.*;

@Entity
public class Deck {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @Column(name="NAME")
    private String name;

    @Column(name="AUTHOR")
    private String author;

    @Column(name="FORMAT")
    private DeckFormat format;

    @Column(name="RATING")
    private int rating;


    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public DeckFormat getFormat() {
        return format;
    }

    public void setFormat(DeckFormat format) {
        this.format = format;
    }

    public int getRating() { return rating;  }

    public void setRating(int rating) { this.rating = rating; }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
