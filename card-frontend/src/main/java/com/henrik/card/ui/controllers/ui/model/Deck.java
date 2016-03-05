package com.henrik.card.ui.controllers.ui.model;

/**
 * This is the ui model representation of the Deck found in card-service domain package. There are no annotations here.
 * Also, it IS duplicated code, but it seems like this is the "microservice way" to avoid shared domain objects and hence troubles deploying separately.
 */
public class Deck {

    private String name;
    private String author;
    private String format;
    private int rating;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getFormat() {
        return format;
    }

    public void setFormat(String format) {
        this.format = format;
    }

    public int getRating() {
        return rating;
    }

    public void setRating(int rating) {
        this.rating = rating;
    }
}
