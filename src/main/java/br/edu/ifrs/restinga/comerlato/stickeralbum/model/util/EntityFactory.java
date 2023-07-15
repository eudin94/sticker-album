package br.edu.ifrs.restinga.comerlato.stickeralbum.model.util;

import br.edu.ifrs.restinga.comerlato.stickeralbum.model.entity.Album;
import br.edu.ifrs.restinga.comerlato.stickeralbum.model.entity.Sticker;
import com.github.javafaker.Faker;

import java.util.List;

public class EntityFactory {

    private static final Faker faker = new Faker();

    public static Album createAlbum() {
        try {
            var album = new Album(
                    getName(10, 100),
                    faker.country().name(),
                    faker.number().numberBetween(1900, 2023),
                    List.of(faker.gameOfThrones().city(), faker.lordOfTheRings().location(), faker.elderScrolls().city()),
                    getName(4, 10)
            );
            album.setSpecialStickers(faker.number().numberBetween(0, 5));
            return album;
        } catch (IllegalArgumentException e) {
            return createAlbum();
        }
    }

    public static Sticker createSticker() {
        try {
            var sticker = new Sticker(
                    faker.random().nextBoolean(),
                    faker.random().nextBoolean(),
                    faker.app().version(),
                    getName(3, 100)
            );
            sticker.setTeam(getName(1, 3));
            sticker.setPosition(getName(1, 3));
            return sticker;
        } catch (IllegalArgumentException e) {
            return createSticker();
        }
    }

    private static String getName(final int min, final int max) {
        var name = "";

        final var opt = faker.random().nextInt(1, 7);

        switch (opt) {
            case 1 -> name = faker.lordOfTheRings().character();
            case 2 -> name = faker.gameOfThrones().character();
            case 3 -> name = faker.rickAndMorty().character();
            case 4 -> name = faker.dragonBall().character();
            case 5 -> name = faker.programmingLanguage().name();
            case 6 -> name = faker.pokemon().name();
            default -> name = faker.superhero().name();
        }

        while (name.length() < min) {
            name = name.concat(" " + getName(1, max / 2));
        }

        if (name.length() > max) {
            name = name.substring(0, max);
        }

        return name.toUpperCase();
    }
}
