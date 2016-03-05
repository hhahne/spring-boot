package com.henrik.card.ui.controllers.rest;

import com.henrik.card.ui.controllers.ui.client.DeckServiceClient;
import com.henrik.card.ui.controllers.ui.model.Deck;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.PagedResources;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.*;

/**
 * Created by henrikhahne on 25/09/15.
 */

@RestController
public class CardRestController {

    @Autowired
    private DeckServiceClient deckServiceClient;

    @RequestMapping("/feigndecks")
    public List<Deck> index() {

        Collection<Deck> decks = deckServiceClient.findAll().getContent();
        List<Deck> returnedDecks = new ArrayList();
        returnedDecks.addAll(decks);
        return returnedDecks;
    }

}
