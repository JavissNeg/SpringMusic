package com.negrete.music.principal;

import com.negrete.music.model.Album;
import com.negrete.music.model.Artist;
import com.negrete.music.model.Genre;
import com.negrete.music.repository.AlbumRepository;
import com.negrete.music.repository.ArtistRepository;
import com.negrete.music.service.GeminiIA;

import java.util.List;
import java.util.Optional;
import java.util.Scanner;
import java.util.concurrent.atomic.AtomicInteger;

public class Principal {
    private ArtistRepository artistRepository;
    private AlbumRepository albumRepository;

    private Scanner sn = new Scanner(System.in);
    private final AtomicInteger atomicInteger = new AtomicInteger(1);
    private List<Artist> currentListArtists;

    public Principal(ArtistRepository artistRepository, AlbumRepository albumRepository) {
        this.artistRepository = artistRepository;
        this.albumRepository = albumRepository;
    }

    public void showPrincipalMenu() {
        byte option = -1;

        do {
            System.out.print("""
                    \n------ MENU PRINCIPAL ------
                    
                    1. Añadir un artista
                    2. Añadir albúm
                    3. Ver artistas guardados
                    4. Ver albúms
                    5. Generar descripción con IA
                    6. Eliminar un artista
                    7. Eliminar todo
                    
                    0. Salir
                    
                    Seleccione una opción: 
                    """);


            option = sn.nextByte();
            sn.nextLine();

            System.out.println();

            switch (option) {
                case 1:
                    addArtist();
                    break;
                case  2:
                    addAlbum();
                    break;
                case 3:
                    showArtistSaved();
                    break;
                case 4:
                    showAlbums();
                    break;
                case 5:
                    generateIADescription();
                    break;
                case 6:
                    removeArtist();
                    break;
                case 7:
                    removeArtists();
                    break;

                default:
                    break;
            }


        } while (option != 0);
    }

    private void addArtist() {
        try {
            System.out.println("----- 🎵 AÑADIR ARTISTA NUEVO 🎵 -----");
            System.out.print("Ingresa el nombre artistico: ");
            String inArtistName = formatName(sn.nextLine());
            System.out.print("Ingresa el nombre real: ");
            String inRealName = formatName(sn.nextLine());

            System.out.println("\n---- 🎵 SELECCIONA SU GÉNERO 🎵 ----");
            for (Genre g: Genre.values()) {
                System.out.println(g.getGenreName());
            }
            System.out.print("\nEscribe el género que mejor represente a tu ártista en la lista (Ej. Rap): ");
            String inGenre = sn.nextLine();

            Genre genre = Genre.findGenre(inGenre);

            Artist artist = new Artist(inArtistName, inRealName, genre);
            artistRepository.save(artist);

            System.out.println(inArtistName + " se ha añadido. 🎵");

        } catch (IllegalArgumentException e) {
            System.out.println("Numbre con caracteres no válidos");
        }

    }

    private void showArtistSaved() {
        atomicInteger.set(1);

        System.out.println("------ 🎵 LISTA DE ARTISTAS 🎵 ------");
        currentListArtists = artistRepository.findAll();

        if (currentListArtists.isEmpty()) {
            System.out.println("No hay artistas. 🎵");
        }

        currentListArtists.forEach(a -> {
            System.out.println(atomicInteger.getAndIncrement() +". "+ a.toString());
        });
    }

    private void addAlbum() {
        Optional<Artist> artistFound = getArtist();

        if (artistFound.isPresent()) {
            System.out.println("\n----- 🎵 NUEVO ALBUM 🎵 -----");
            System.out.print("Escriba el nombre del albúm: ");
            String inAlbumName = formatName(sn.nextLine());

            if (albumRepository.existsByNameAndArtist(inAlbumName, artistFound.get())) {
                System.out.println("Este álbum ya existe. 🎵");
                return;
            }

            System.out.print("Escriba el número de canciones que contiene (Ej. 10): ");
            byte inTotalSongs;

            try {
                inTotalSongs = sn.nextByte();
            } catch (Exception e) {
                inTotalSongs = 0;
            }

            Album album = new Album(inAlbumName, inTotalSongs, artistFound.get());
            albumRepository.save(album);


        } else {
            System.out.println("Artista no encontrado. 🎵");
        }

    }

    private void showAlbums() {
        Optional<Artist> artistFound = getArtist();
        artistFound.ifPresent(artist -> {
            atomicInteger.set(1);

            List<Album> albums = albumRepository.findByArtist(artist);
            if (albums.isEmpty()) {
                System.out.println("Este artista aún no tiene álbumes guardados. 🎵");
            } else {
                albums.forEach(a -> {
                    System.out.println(atomicInteger.getAndIncrement() +". "+ a.toString());
                });
            }
        });
    }

    private void generateIADescription() {
        Optional<Artist> artistFound = getArtist();

        System.out.println("\n---- 🎵 DESCRIPCIÓN CON AI 🎵 -----");

        artistFound.ifPresentOrElse(
                a -> System.out.println(GeminiIA.getDescription(a)),
                () -> System.out.println("🚫 Artista no encontrado. No se puede generar descripción.")
        );
    }

    private void removeArtist() {
        Optional<Artist> artistFound = getArtist();

        artistFound.ifPresent(artist -> {
            if (askShowArtist()) {
                artistRepository.delete(artist);
                System.out.println("Artista eliminado correctamente. 🎵");
            } else {
                System.out.println("Cancelado. 🎵");
            }
        });
    }

    private void removeArtists() {
        if (askShowArtist()) {
            artistRepository.deleteAll();
            System.out.println("Artistas eliminados correctamente. 🎵");
        } else {
            System.out.println("Cancelado. 🎵");
        }
    }


    private boolean askShowArtist() {
        System.out.println("\n---- 🎵  ELIMINAR ARTISTA(S)? 🎵 ");

        System.out.print("""
                    1. Si
                    2. No
                    
                    Elija una opción: 
                    """);

        return sn.nextByte() == 1;
    }

    private Optional<Artist> getArtist() {
        showArtistSaved();

        System.out.print("\nEscriba el numero de algún artista de la lista: ");
        int inIndex = sn.nextInt();
        sn.nextLine();

        return Optional.ofNullable(currentListArtists.get(inIndex - 1));
    }

    private String formatName(String name) {
        if (name == null || name.isBlank()) {
            throw new IllegalArgumentException("Texto vacío");
        }

        String[] words = name.trim().toLowerCase().split("\\s+");
        StringBuilder textFormatted = new StringBuilder();

        for (String word : words) {
            textFormatted.append(Character.toUpperCase(word.charAt(0)))
                    .append(word.substring(1))
                    .append(" ");
        }

        return textFormatted.toString().trim();
    }

}
