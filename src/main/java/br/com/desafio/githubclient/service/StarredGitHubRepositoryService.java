package br.com.desafio.githubclient.service;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

import br.com.desafio.githubclient.entity.StarredGitHubRepository;
import br.com.desafio.githubclient.repository.StarredGitHubRepositoryRepository;
import reactor.core.publisher.Mono;

@Service
public class StarredGitHubRepositoryService {
    
    @Autowired
    private WebClient webClient;

    @Autowired
    private StarredGitHubRepositoryRepository starredGitHubRepositoryRepository;

    public List<StarredGitHubRepository> createFromGitHubUser(String gitHubUser) {
        Mono<StarredGitHubRepository[]> response = this.webClient
            .get()
            .uri(uriBuilder -> uriBuilder.path("{gitHubUser}/starred").build(gitHubUser))
            .retrieve()
            .bodyToMono(StarredGitHubRepository[].class).log();
        StarredGitHubRepository[] starredRepositories = response.block();
        response.subscribe();

        List<StarredGitHubRepository> starredRepositoriesList = Arrays.stream(starredRepositories)    
            .collect(Collectors.toList());
        starredRepositoriesList.forEach(starredRepository -> starredRepository.setGitHubUser(gitHubUser));

        return starredGitHubRepositoryRepository.saveAll(starredRepositoriesList);
    }

    public StarredGitHubRepository addTagToRepository(String repositoryId, String tagName) {
        StarredGitHubRepository repository = starredGitHubRepositoryRepository.findById(repositoryId).get();
        List<String> tagsList = repository.getTags();
        if (!tagsList.contains(tagName)) {
                repository.setTags(tagName);
        }
        return repository;
    }

    public List<StarredGitHubRepository> searchByTag(String tagName) {
        return starredGitHubRepositoryRepository.findByTags(tagName);
    }

    public StarredGitHubRepository deleteTagOfRepository(String repositoryId, String tagName) {
        StarredGitHubRepository repository = starredGitHubRepositoryRepository.findById(repositoryId).get();
        List<String> tagsList = repository.getTags();
        if (tagsList.contains(tagName)) {
            tagsList.remove(tagName);
        }
        return repository;
    }
}
