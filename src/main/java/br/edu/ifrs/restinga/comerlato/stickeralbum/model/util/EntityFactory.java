package br.edu.ifrs.restinga.comerlato.stickeralbum.model.util;

import br.edu.ifrs.restinga.comerlato.stickeralbum.model.entity.Album;
import br.edu.ifrs.restinga.comerlato.stickeralbum.model.entity.Sticker;

import java.util.List;
import java.util.Random;

import static br.edu.ifrs.restinga.comerlato.stickeralbum.model.util.FakerManager.initializeAlbumFields;
import static br.edu.ifrs.restinga.comerlato.stickeralbum.model.util.FakerManager.initializeStickerFields;
import static br.edu.ifrs.restinga.comerlato.stickeralbum.model.util.constants.StringConstants.*;
import static java.util.Objects.isNull;

public class EntityFactory {

    private static final Random random = new Random();

    public static Album createAlbum() {
        if (isNull(ALBUM_NAME_1)) initializeAlbumFields();
        try {
            var album = new Album(
                    getAlbumName(),
                    getHostCountry(),
                    random.nextInt(1900, 2024),
                    List.of(
                            TEAM_NAME_1,
                            TEAM_NAME_2,
                            TEAM_NAME_3
                    ),
                    getCover()
            );
            album.setSpecialStickers(random.nextInt(0, 5));
            return album;
        } catch (IllegalArgumentException e) {
            return createAlbum();
        }
    }

    public static Sticker createSticker() {
        if (isNull(VERSION)) initializeStickerFields();
        try {
            var sticker = new Sticker(
                    random.nextBoolean(),
                    random.nextBoolean(),
                    VERSION,
                    getStickerName()
            );
            sticker.setTeam(getStickerTeam());
            sticker.setPosition(getPosition());
            return sticker;
        } catch (IllegalArgumentException e) {
            return createSticker();
        }
    }


    private static String getAlbumName() {
        final var seed = random.nextInt(1, 4);
        return switch (seed) {
            case 1 -> ALBUM_NAME_1;
            case 2 -> ALBUM_NAME_2;
            default -> ALBUM_NAME_3;
        };
    }

    private static String getHostCountry() {
        final var seed = random.nextInt(1, 4);
        return switch (seed) {
            case 1 -> HOST_COUNTRY_1;
            case 2 -> HOST_COUNTRY_2;
            default -> HOST_COUNTRY_3;
        };
    }

    private static String getCover() {
        final var seed = random.nextInt(1, 4);
        return switch (seed) {
            case 1 -> COVER_1;
            case 2 -> COVER_2;
            default -> COVER_3;
        };
    }

    private static String getStickerName() {
        final var seed = random.nextInt(1, 4);
        return switch (seed) {
            case 1 -> STICKER_NAME_1;
            case 2 -> STICKER_NAME_2;
            default -> STICKER_NAME_3;
        };
    }

    private static String getStickerTeam() {
        final var seed = random.nextInt(1, 4);
        return switch (seed) {
            case 1 -> STICKER_TEAM_1;
            case 2 -> STICKER_TEAM_2;
            default -> STICKER_TEAM_3;
        };
    }

    private static String getPosition() {
        final var seed = random.nextInt(1, 4);
        return switch (seed) {
            case 1 -> POSITION_1;
            case 2 -> POSITION_2;
            default -> POSITION_3;
        };
    }
}
