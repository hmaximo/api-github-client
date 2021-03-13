package br.com.desafio.githubclient.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import br.com.desafio.githubclient.entity.Users;

@Repository
public interface UsersRepository extends MongoRepository<Users, String> {
    
}
