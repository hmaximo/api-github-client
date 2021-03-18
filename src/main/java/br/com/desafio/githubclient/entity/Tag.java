package br.com.desafio.githubclient.entity;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.Data;

@Data
@Document(collection = "tags")
public class Tag {

    @Id
    private String id;
    private String name;
    private String gitHubUser;
    
    public Tag(String name, String gitHubUser) {
        this.name = name;
        this.gitHubUser = gitHubUser;
    }
}
