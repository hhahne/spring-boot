package com.henrik.card.service.repository;

import com.henrik.card.service.domain.Deck;
import com.henrik.card.service.domain.DeckFormat;
import org.junit.Before;
import org.junit.Test;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.test.web.client.MockRestServiceServer;
import org.springframework.web.client.RestTemplate;

import static org.springframework.test.web.client.match.MockRestRequestMatchers.method;
import static org.springframework.test.web.client.match.MockRestRequestMatchers.requestTo;
import static org.springframework.test.web.client.response.MockRestResponseCreators.withSuccess;


/**
 * Card Deck REST Controller Repository Test. Sounds like an integration test but everything is mocked.
 */
public class CardDeckRepositoryTest {

    private MockRestServiceServer mockServer;
    private RestTemplate restTemplate;

    @Before
    public void setUp(){
        restTemplate = new RestTemplate();
        mockServer = MockRestServiceServer.createServer(restTemplate);
    }

    @Test
    public void testGenericGetRequest() {

        String responseBody = "{\"links\" : {\"search\": {\"href\": \"http://localhost:8083/decks/search\"}}}";

        this.mockServer.expect(requestTo("/"))
                .andExpect(method(HttpMethod.GET))
                .andRespond(withSuccess(responseBody, MediaType.APPLICATION_JSON));

        restTemplate.getForObject("/", Object.class);

        this.mockServer.verify();
    }

    @Test
    public void testGetRequest() {

        String responseBody = "{\n" +
                "  \"name\": \"Black White Aggro\",\n" +
                "  \"author\": \"Henrik Hahne\",\n" +
                "  \"format\": \"LEGACY\",\n" +
                "  \"rating\": null,\n" +
                "  \"_links\": {\n" +
                "    \"self\": {\n" +
                "      \"href\": \"http://localhost:8083/decks/2\"\n" +
                "    }\n" +
                "  }\n" +
                "}";

        this.mockServer.expect(requestTo("/decks/1"))
                .andExpect(method(HttpMethod.GET))
                .andRespond(withSuccess(responseBody, MediaType.APPLICATION_JSON));

        restTemplate.getForObject("/decks/{id}", Deck.class, 1);

        this.mockServer.verify();
    }

    @Test
    public void testPostRequest() {
        Deck postedDeck = createPostedDeck();

        this.mockServer.expect(requestTo("/decks")).andExpect(method(HttpMethod.POST)).andRespond(withSuccess());

        restTemplate.postForLocation("/decks", postedDeck);

        this.mockServer.verify();
    }

    @Test
    public void testPutRequest() {
        Deck postedDeck = createPostedDeck();
        Deck updatedDeck = createPostedDeck();
        updatedDeck.setName("Laban");

        this.mockServer.expect(requestTo("/decks")).andExpect(method(HttpMethod.POST)).andRespond(withSuccess());
        this.mockServer.expect(requestTo("/decks/1")).andExpect(method(HttpMethod.PUT)).andRespond(withSuccess());

        restTemplate.postForLocation("/decks", postedDeck);
        restTemplate.put("/decks/{id}", updatedDeck, 1);

        this.mockServer.verify();
    }


    private Deck createPostedDeck() {
        Deck aDeck = new Deck();
        aDeck.setId(1);
        aDeck.setAuthor("Henrik");
        aDeck.setFormat(DeckFormat.LEGACY);
        aDeck.setName("Test deck");

        return aDeck;
    }

}
