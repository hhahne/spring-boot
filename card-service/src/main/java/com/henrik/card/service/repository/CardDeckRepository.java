package com.henrik.card.service.repository;

import com.henrik.card.service.domain.Deck;
import org.springframework.cloud.netflix.hystrix.EnableHystrix;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import java.util.List;

@RepositoryRestResource(collectionResourceRel = "decks", path = "decks")
public interface CardDeckRepository extends CrudRepository<Deck, Long> {

    List<Deck> findByAuthor(@Param("author") String author);
    List<Deck> findByName(@Param("name") String name);

}
