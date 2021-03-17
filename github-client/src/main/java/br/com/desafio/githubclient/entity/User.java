package br.com.desafio.githubclient.entity;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.Data;

@Data
@Document(collection = "users")
public class User {

    @Id
    private String id;
    private String name;
    private String email;
    private String gitHubUser;
    private String password;

    public User(String name, String email, String gitHubUser, String password) {
        this.name = name;
        this.email = email;
        this.gitHubUser = gitHubUser;
        this.password = password;
    }
}
