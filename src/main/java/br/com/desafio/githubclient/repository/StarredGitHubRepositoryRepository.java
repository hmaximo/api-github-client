package br.com.desafio.githubclient.repository;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import br.com.desafio.githubclient.entity.StarredGitHubRepository;

@Repository
public interface StarredGitHubRepositoryRepository extends MongoRepository<StarredGitHubRepository, String> {
    
    List<StarredGitHubRepository> findByGitHubUser(String gitHubUser);

    List<StarredGitHubRepository> findByTags(String tagName);
}
