package br.com.desafio.githubclient.repository;

import java.util.Optional;

import org.springframework.data.mongodb.repository.MongoRepository;

import br.com.desafio.githubclient.entity.Tag;

public interface TagRepopsitory extends MongoRepository<Tag, String> {

    Optional<Tag> findByName(String name);
    
}
