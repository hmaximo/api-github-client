package br.com.desafio.githubclient.entity;

import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "starred-github-repositories")
@JsonIgnoreProperties(ignoreUnknown = true)
public class StarredGitHubRepository {

    @Id
    private String id; 
    private String name;
    private String description;
    private String url;
    private String gitHubUser;
    private List<String> tags;

    public StarredGitHubRepository(String id, String name, String description, String url, String gitHubUser) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.url = url;
        this.gitHubUser = gitHubUser;
        this.tags = new ArrayList<String>();
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

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getGitHubUser() {
        return gitHubUser;
    }

    public void setGitHubUser(String gitHubUser) {
        this.gitHubUser = gitHubUser;
    }

    public List<String> getTags() {
        return tags;
    }

    public void setTags(String tagName) {
        tags.add(tagName);
    }
}

