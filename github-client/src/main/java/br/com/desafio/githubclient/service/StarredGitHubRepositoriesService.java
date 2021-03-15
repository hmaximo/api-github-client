package br.com.desafio.githubclient.service;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

import br.com.desafio.githubclient.entity.StarredGitHubRepositories;
import reactor.core.publisher.Mono;

@Service
public class StarredGitHubRepositoriesService {
    
    @Autowired
    private WebClient webClient;

    public List<StarredGitHubRepositories> list() {
        Mono<StarredGitHubRepositories[]> response = this.webClient
            .method(HttpMethod.GET)
            .uri("/hmaximo/starred")
            .accept(MediaType.APPLICATION_JSON)
            .retrieve()
            .bodyToMono(StarredGitHubRepositories[].class).log();
        StarredGitHubRepositories[] starredRepositories = response.block();

        response.subscribe(r ->  {
            System.out.println("Aqui sim, finalizou de verdade.");
        });

        System.out.println("Finalizou.");

        return Arrays.stream(starredRepositories)
            .collect(Collectors.toList());
    }
}
