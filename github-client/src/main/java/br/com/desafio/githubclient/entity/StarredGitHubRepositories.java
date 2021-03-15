package br.com.desafio.githubclient.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.Data;

@Data
@Document(collection = "stared-github-repositories")
@JsonIgnoreProperties(ignoreUnknown = true)
public class StarredGitHubRepositories {

    @Id
    private String id;
    
    private String name;
    
    private String description;
    
    private String url;

    public StarredGitHubRepositories(String name, String description, String url) {
        this.name = name;
        this.description = description;
        this.url = url;
    }

    @Override
    public String toString() {
        return "Stared GitHub Repository{" + 
            "id='" + id + '\'' +
            ", name='" + name + '\'' +
            ", description='" + description + '\'' +
            ", url='" + url +
            '}';
    }
}

