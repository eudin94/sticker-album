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
                    faker.programmingLanguage().name(),
                    faker.country().name(),
                    faker.number().numberBetween(1900, 2023),
                    List.of(faker.gameOfThrones().city(), faker.lordOfTheRings().location(), faker.elderScrolls().city()),
                    faker.pokemon().name()
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
                    faker.rickAndMorty().character()
            );
            sticker.setTeam(faker.rickAndMorty().location().substring(0, 3).toUpperCase());
            sticker.setPosition(faker.dragonBall().character().substring(0, 3).toUpperCase());
            return sticker;
        } catch (IllegalArgumentException e) {
            return createSticker();
        }
    }
}
