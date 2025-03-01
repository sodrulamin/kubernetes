package com.shaon.bookmark;

import org.springframework.boot.SpringApplication;

public class TestKubernetesApplication {

	public static void main(String[] args) {
		SpringApplication.from(BookmarkApplication::main).with(TestcontainersConfiguration.class).run(args);
	}

}
