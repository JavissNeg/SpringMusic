package com.negrete.music;

import com.negrete.music.principal.Principal;
import com.negrete.music.repository.AlbumRepository;
import com.negrete.music.repository.ArtistRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class MusicApplication implements CommandLineRunner {

	@Autowired
	private ArtistRepository artistRepository;

	@Autowired
	private AlbumRepository albumRepository;

	public static void main(String[] args) {
		SpringApplication.run(MusicApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		Principal principal = new Principal(artistRepository, albumRepository);
		principal.showPrincipalMenu();
	}
}
