package com.henrik.card.ui.controllers.service;

import com.henrik.card.ui.controllers.ui.client.DeckServiceClient;
import com.henrik.card.ui.controllers.ui.model.Deck;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.Collection;

/**
 * HystrixCommands only work on classes annotated with @Component or @Service so this wrapper is needed.
 */
@Service
public class DeckService {

    @Autowired
    private DeckServiceClient deckServiceClient;

    @HystrixCommand(fallbackMethod="getDefaultDecks")
    public Collection<Deck> getDecks() {
        return deckServiceClient.findAll().getContent();
    }

    public Collection<Deck> getDefaultDecks() {
        Deck aDefaultDeck = new Deck();
        aDefaultDeck.setName("Default Deck from failover");
        return Arrays.asList(aDefaultDeck);
    }
}
