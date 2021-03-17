package br.com.desafio.githubclient.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import br.com.desafio.githubclient.entity.StarredGitHubRepository;
import br.com.desafio.githubclient.repository.StarredGitHubRepositoryRepository;
import br.com.desafio.githubclient.service.StarredGitHubRepositoryService;

@RestController
@RequestMapping("/starred-repositories")
public class StarredGitHubRepositoriesController {

    @Autowired
    private StarredGitHubRepositoryRepository starredGitHubRepositoryRepository;

    @Autowired
    private StarredGitHubRepositoryService starredGitHubRepositoryService;

    @GetMapping
    public List<StarredGitHubRepository> searchByGitHubUser(@RequestParam(required = false) String gitHubUser) {
        if (gitHubUser == null) {
           return starredGitHubRepositoryRepository.findAll();
        }
        return starredGitHubRepositoryRepository.findByGitHubUser(gitHubUser);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public List<StarredGitHubRepository> add(@RequestParam String gitHubUser) {
        return starredGitHubRepositoryService.createFromGitHubUser(gitHubUser);
    }
}
