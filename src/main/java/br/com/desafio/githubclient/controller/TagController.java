package br.com.desafio.githubclient.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import br.com.desafio.githubclient.entity.Tag;
import br.com.desafio.githubclient.repository.TagRepopsitory;
import br.com.desafio.githubclient.service.TagService;

@RestController
@RequestMapping("/tags")
public class TagController {
    
    @Autowired
    private TagService tagService;

    @Autowired
    private TagRepopsitory tagRepopsitory;

    @GetMapping
    public List<Tag> list() {
        return tagRepopsitory.findAll();
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Tag add(@RequestBody Tag tag) {
        return tagService.save(tag);
    }

    @DeleteMapping("/{tagId}")
    public ResponseEntity<Void> remove(@PathVariable String tagId) {

        if (!tagRepopsitory.existsById(tagId)) {
            return ResponseEntity.notFound().build();
        }

        tagService.delete(tagId);

        return ResponseEntity.noContent().build();
    }    
}
