package com.cy.example.demo;

import org.springframework.data.repository.CrudRepository;

public interface RedditCloneRepository extends CrudRepository<RedditClone, Long> {

        Iterable <RedditClone> findAllByTitleContainingIgnoreCase(String search);
    }
