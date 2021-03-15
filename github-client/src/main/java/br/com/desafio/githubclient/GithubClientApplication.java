package br.com.desafio.githubclient;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.web.reactive.function.client.WebClient;

import br.com.desafio.githubclient.entity.Users;
import br.com.desafio.githubclient.repository.StarredGitHubRepositoriesRepository;
import br.com.desafio.githubclient.repository.UsersRepository;
import br.com.desafio.githubclient.service.StarredGitHubRepositoriesService;

@SpringBootApplication
public class GithubClientApplication implements CommandLineRunner {

	@Autowired
	UsersRepository usersRepository;

	@Autowired
	StarredGitHubRepositoriesRepository starredRepository;

	@Autowired
	StarredGitHubRepositoriesService starredService;

	@Bean
	public WebClient webClient(WebClient.Builder builder) {
		return builder
			.baseUrl("https://api.github.com/users/")
			.defaultHeader(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON_VALUE)
			.defaultHeader("User-Agent", "hmaximo")
			.build();
	}

	public static void main(String[] args) {
		SpringApplication.run(GithubClientApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		deleteAll();
		addSampleData();
		listAll();
		starredService.list();
	}

	public void deleteAll() {
		System.out.println("Deleting all records...");
		usersRepository.deleteAll();
	}

	public void addSampleData() {
		System.out.println("Adding sample data");
		usersRepository.save(new Users("Jack Numerous Bauer", "jack.bauer", "123456"));
		usersRepository.save(new Users("Harvey Spectre", "harvey.spectre", "234567"));
		usersRepository.save(new Users("Mike Ross", "mike.ross", "345678"));
		usersRepository.save(new Users("Louise Litt", "louise.litt", "456789"));
	}

	public void listAll() {
		System.out.println("Listing sampe data");
		usersRepository.findAll();
	}
}
