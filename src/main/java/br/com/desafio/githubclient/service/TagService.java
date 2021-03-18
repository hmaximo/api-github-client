package br.com.desafio.githubclient.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.desafio.githubclient.entity.Tag;
import br.com.desafio.githubclient.repository.TagRepopsitory;

@Service
public class TagService {
    
    @Autowired
    private TagRepopsitory tagRepopsitory;

    public Tag save(Tag tag) {
        return tagRepopsitory.save(tag);
    }

    public void delete(String tagId) {
        tagRepopsitory.deleteById(tagId);
    }
}
