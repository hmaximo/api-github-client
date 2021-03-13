package br.com.desafio.githubclient.entity;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.Data;

@Data
@Document(collection = "users")
public class Users {

    @Id
    private String id;
    private String name;
    private String login;
    private String password;

    public Users(String name, String login, String password) {
        this.name = name;
        this.login = login;
        this.password = password;
    }
}
