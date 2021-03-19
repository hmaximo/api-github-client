package br.com.desafio.githubclient;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.web.reactive.function.client.WebClient;

@SpringBootApplication
public class GithubClientApplication implements CommandLineRunner {

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
	}
}
