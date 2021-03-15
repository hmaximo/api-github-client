package br.com.desafio.githubclient.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import br.com.desafio.githubclient.entity.StarredGitHubRepositories;

@Repository
public interface StarredGitHubRepositoriesRepository extends MongoRepository<StarredGitHubRepositories, String>{
    
}
