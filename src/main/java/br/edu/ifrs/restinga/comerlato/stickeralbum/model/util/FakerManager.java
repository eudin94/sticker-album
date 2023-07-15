package br.edu.ifrs.restinga.comerlato.stickeralbum.model.util;

import com.github.javafaker.Faker;

import static br.edu.ifrs.restinga.comerlato.stickeralbum.model.util.constants.StringConstants.*;

public class FakerManager {

    private static final Faker faker = new Faker();

    public static void initializeAlbumFields() {
        ALBUM_NAME_1 = getFakerString(10, 100, 1);
        ALBUM_NAME_2 = getFakerString(10, 100, 2);
        ALBUM_NAME_3 = getFakerString(10, 100, 3);
        HOST_COUNTRY_1 = getFakerString(3, 100, 4);
        HOST_COUNTRY_2 = getFakerString(3, 100, 5);
        HOST_COUNTRY_3 = getFakerString(3, 100, 6);
        TEAM_NAME_1 = getFakerString(3, 100, 7);
        TEAM_NAME_2 = getFakerString(3, 100, 8);
        TEAM_NAME_3 = getFakerString(3, 100, 9);
        COVER_1 = getFakerString(4, 10, 10);
        COVER_2 = getFakerString(4, 10, 11);
        COVER_3 = getFakerString(4, 10, 12);
    }

    public static void initializeStickerFields() {
        STICKER_NAME_1 = getFakerString(3, 100, 1);
        STICKER_NAME_2 = getFakerString(3, 100, 2);
        STICKER_NAME_3 = getFakerString(3, 100, 3);
        POSITION_1 = getFakerString(3, 3, 4);
        POSITION_2 = getFakerString(3, 3, 5);
        POSITION_3 = getFakerString(3, 3, 6);
        STICKER_TEAM_1 = getFakerString(3, 3, 7);
        STICKER_TEAM_2 = getFakerString(3, 3, 8);
        STICKER_TEAM_3 = getFakerString(3, 3, 9);
        VERSION = getFakerString(1, 10, 13);
    }

    private static String getFakerString(final int min, final int max, final int seed) {
        var string = "";

        switch (seed) {
            case 1 -> string = faker.lordOfTheRings().character();
            case 2 -> string = faker.gameOfThrones().character();
            case 3 -> string = faker.elderScrolls().firstName();
            case 4 -> string = faker.lordOfTheRings().location();
            case 5 -> string = faker.gameOfThrones().city();
            case 6 -> string = faker.elderScrolls().region();
            case 7 -> string = faker.gameOfThrones().house();
            case 8 -> string = faker.gameOfThrones().dragon();
            case 9 -> string = faker.elderScrolls().dragon();
            case 10 -> string = faker.food().sushi();
            case 11 -> string = faker.food().dish();
            case 12 -> string = faker.food().fruit();
            case 13 -> string = faker.app().version();
            default -> string = faker.pokemon().name();
        }

        while (string.length() < min) {
            string = string.concat(" " + getFakerString(1, max / 2, seed));
        }

        if (string.length() > max) {
            string = string.substring(0, max);
        }

        return string.toUpperCase();
    }
}
