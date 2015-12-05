package com.henrik.card.service;

import com.google.common.collect.Iterables;
import com.henrik.card.service.domain.Deck;
import com.henrik.card.service.domain.DeckFormat;
import com.henrik.card.service.repository.CardDeckRepository;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.IntegrationTest;
import org.springframework.boot.test.SpringApplicationContextLoader;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.web.context.WebApplicationContext;

import java.util.List;

import static junit.framework.TestCase.assertEquals;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertThat;

@ContextConfiguration(classes = {CardServiceApplication.class}, loader = SpringApplicationContextLoader.class)
@WebAppConfiguration
@IntegrationTest
@RunWith(SpringJUnit4ClassRunner.class)
public class CardDeckRepositoryStepDefinitions {

    @Autowired
    private CardDeckRepository repository;

    Deck savedDeck = null;

    @Given("^(\\d+) stored deck in the repository with author (.*)$")
    public void stored_deck_in_the_repository_with_author(int arg1, String author) throws Throwable {
        Deck aDeck = createDeck(author);
        savedDeck = repository.save(aDeck);
    }


    @Given("^(\\d+) stored decks in the repository$")
    public void stored_decks_in_the_repository(int numberofDecksStored) throws Throwable {
        for(int i =0; i < numberofDecksStored; i++) {
            Deck aDeck = createDeck("TestAuthor");
            repository.save(aDeck);
        }
    }

    @When("^search repository on author (.*)$")
    public void search_repository_on_author(String author) throws Throwable {
        repository.findByAuthor(author);
    }

    @When("^search repository for all decks$")
    public void search_repository_for_all_decks() throws Throwable {
        repository.findAll();
    }

    @Then("^The deck with (.*) as author shall be found$")
    public void the_deck_with_as_author_shall_be_found(String author) throws Throwable {
        List<Deck> returnedDecks = repository.findByAuthor(author);
        assertThat(author, is(returnedDecks.get(0).getAuthor()));
    }

    @Then("^(\\d+) deck returned from repository with author (.*)$")
    public void deck_returned_from_repository(int numberOfDecksReturned, String author) {
        List<Deck> returnedDecks = repository.findByAuthor(author);
        assertNotNull(returnedDecks);
        assertEquals(1, returnedDecks.size());
    }

    @Then("^(\\d+) decks available in the repository$")
    public void decks_available_in_the_repository(int numberOfDecksAvailable) throws Throwable {
        Iterable<Deck> returnedDecks = repository.findAll();
        assertEquals(numberOfDecksAvailable, Iterables.size(returnedDecks));
    }

    //TODO: Extract this and all other similar methods into a TestFixture class to avoid polluting this class.
    private Deck createDeck(String author) {
        Deck aDeck = new Deck();
        aDeck.setAuthor(author);
        aDeck.setFormat(DeckFormat.LEGACY);
        aDeck.setName("Black Aggro");
        return aDeck;
    }
}
