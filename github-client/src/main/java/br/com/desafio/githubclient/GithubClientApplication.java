package br.com.desafio.githubclient;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import br.com.desafio.githubclient.entity.Users;
import br.com.desafio.githubclient.repository.UsersRepository;

@SpringBootApplication
public class GithubClientApplication implements CommandLineRunner {

	@Autowired
	UsersRepository usersRepository;

	public static void main(String[] args) {
		SpringApplication.run(GithubClientApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		deleteAll();
		addSampleData();
		listAll();
	}

	public void deleteAll() {
		System.out.println("Deleting all records...");
		usersRepository.deleteAll();
	}

	public void addSampleData() {
		System.out.println("Adding sample data");
		usersRepository.save(new Users("Jack Bauer", "jack.bauer", "123456"));
		usersRepository.save(new Users("Harvey Spectre", "harvey.spectre", "234567"));
		usersRepository.save(new Users("Mike Ross", "mike.ross", "345678"));
		usersRepository.save(new Users("Louise Litt", "louise.litt", "456789"));
	}

	public void listAll() {
		System.out.println("Listing sampe data");
		usersRepository.findAll();
	}

}
