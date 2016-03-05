package com.henrik.card.ui.controllers.ui.client;

import com.henrik.card.ui.controllers.ui.model.Deck;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.hateoas.PagedResources;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.Collection;

@FeignClient("card-service")
public interface DeckServiceClient {


    @RequestMapping(method = RequestMethod.GET, value = "/decks")
    PagedResources<Deck> findAll();
}
