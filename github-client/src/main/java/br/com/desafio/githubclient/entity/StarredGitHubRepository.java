package br.com.desafio.githubclient.entity;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.Data;

@Data
@Document(collection = "starred-github-repositories")
@JsonIgnoreProperties(ignoreUnknown = true)
public class StarredGitHubRepository {

    @Id
    private String id; 
    private String name;
    private String description;
    private String url;
    private String gitHubUser;
    private List<Tag> tags;

    public StarredGitHubRepository(String id, String name, String description, String url, String gitHubUser) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.url = url;
        this.gitHubUser = gitHubUser;
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

