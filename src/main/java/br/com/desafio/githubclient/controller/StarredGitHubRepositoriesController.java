package br.com.desafio.githubclient.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import br.com.desafio.githubclient.entity.StarredGitHubRepository;
import br.com.desafio.githubclient.repository.StarredGitHubRepositoryRepository;
import br.com.desafio.githubclient.service.StarredGitHubRepositoryService;

@RestController
@RequestMapping("/users/{gitHubUser}/starred-repositories")
public class StarredGitHubRepositoriesController {

    @Autowired
    private StarredGitHubRepositoryRepository starredGitHubRepositoryRepository;

    @Autowired
    private StarredGitHubRepositoryService starredGitHubRepositoryService;

    @GetMapping
    public List<StarredGitHubRepository> searchByGitHubUser(@PathVariable String gitHubUser) {
        if (gitHubUser == null) {
           return starredGitHubRepositoryRepository.findAll();
        }
        return starredGitHubRepositoryRepository.findByGitHubUser(gitHubUser);
    }

    @GetMapping("/{tag}")
    public List<StarredGitHubRepository> searchByTag(@PathVariable String gitHubUser, @PathVariable String tag) {
        return starredGitHubRepositoryService.searchByTag(tag);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public List<StarredGitHubRepository> addRepositories(@PathVariable String gitHubUser) {
        return starredGitHubRepositoryService.createFromGitHubUser(gitHubUser);
    }

    @PostMapping("/{starredGitHubRepositoryId}")
    public ResponseEntity<StarredGitHubRepository> addTagToRepository(@PathVariable String gitHubUser, @PathVariable String starredGitHubRepositoryId,
                @RequestParam String tag) {
                    
        StarredGitHubRepository updatedRepository = starredGitHubRepositoryService.addTagToRepository(starredGitHubRepositoryId, tag);
        starredGitHubRepositoryRepository.save(updatedRepository);    
        return ResponseEntity.ok(updatedRepository);
    }
    
    
    @DeleteMapping("/{starredGitHubRepositoryId}")
    public ResponseEntity<StarredGitHubRepository> removeTagFromRepository(@PathVariable String gitHubUser, @PathVariable String starredGitHubRepositoryId,
            @RequestParam String tag) {

        StarredGitHubRepository updatedRepository = starredGitHubRepositoryService.deleteTagOfRepository(starredGitHubRepositoryId, tag);
        starredGitHubRepositoryRepository.save(updatedRepository);
        return ResponseEntity.ok(updatedRepository);
    }
}
