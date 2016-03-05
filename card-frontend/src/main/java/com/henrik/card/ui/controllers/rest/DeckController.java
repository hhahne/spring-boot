package com.henrik.card.ui.controllers.rest;

import com.henrik.card.ui.controllers.ui.client.DeckServiceClient;
import com.henrik.card.ui.controllers.ui.model.Deck;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

/**
 * Created by henrikhahne on 27/02/16.
 */
@RestController
public class DeckController {

    @RequestMapping("/resource")
    public Map<String, Object> getDecks() {

        Map<String,Object> model = new HashMap<String,Object>();
        model.put("id", UUID.randomUUID().toString());
        model.put("content", "Hello Norge" +
                "");
        return model;
    }
}
