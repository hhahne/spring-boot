package com.henrik.card.service;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

import com.henrik.card.service.CardServiceApplication;
import com.henrik.card.service.domain.Deck;
import com.henrik.card.service.domain.DeckFormat;
import com.henrik.card.service.repository.CardDeckRepository;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.IntegrationTest;
import org.springframework.boot.test.SpringApplicationContextLoader;
import org.springframework.boot.test.WebIntegrationTest;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.web.context.WebApplicationContext;

import java.util.List;

@ContextConfiguration(classes = {CardServiceApplication.class}, loader = SpringApplicationContextLoader.class)
@WebAppConfiguration
@IntegrationTest
@RunWith(SpringJUnit4ClassRunner.class)
public class CardDeckRepositoryStepDefinitions {

    @Autowired
    private WebApplicationContext context;

    @Autowired
    private CardDeckRepository repository;

    Deck savedDeck = null;
    Deck foundDeck = null;

//    @Given("^I have stored (\\d+) deck with Henrik Hahne as an author in the repository$")
//    public void i_have_stored_deck_with_Henrik_Hhane_as_an_author_in_the_repository(int numberOfBooks) throws Throwable {
//        Deck aDeck = new Deck();
//        aDeck.setAuthor("Henrik Hahne");
//        aDeck.setFormat(DeckFormat.LEGACY);
//        aDeck.setName("Black Aggro");
//
//        savedDeck = repository.save(aDeck);
//    }
//
//    @When("^I perform a search on the repository on author (.*)$")
//    public void i_perform_deck_search_on_author(String author) throws Throwable {
//        List<Deck> foundDecks = repository.findByAuthor(author);
//        foundDeck = foundDecks.get(0);
//    }
//
//    @Then("^The one deck with (.*) as author that was previously stored shall be returned$")
//    public void then_the_one_deck_with_author_should_be_found(String author) {
//        assertThat(foundDeck, is(savedDeck));
//    }


    @Given("^(\\d+) stored deck in the repository with author (.*)$")
    public void stored_deck_in_the_repository_with_author(int arg1, String author) throws Throwable {
        Deck aDeck = new Deck();
        aDeck.setAuthor(author);
        aDeck.setFormat(DeckFormat.LEGACY);
        aDeck.setName("Black Aggro");

        savedDeck = repository.save(aDeck);
    }

    @When("^search repository on author (.*)$")
    public void search_repository_on_author(String author) throws Throwable {
        List<Deck> foundDecks = repository.findByAuthor(author);
        foundDeck = foundDecks.get(0);
    }

    @Then("^The deck with (.*) as author shall be found$")
    public void the_deck_with_as_author_shall_be_found(String author) throws Throwable {
        assertThat(foundDeck.getAuthor(), is(savedDeck.getAuthor()));
    }
}
