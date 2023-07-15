package br.edu.ifrs.restinga.comerlato.stickeralbum.runner.dao;

import br.edu.ifrs.restinga.comerlato.stickeralbum.model.entity.Album;
import br.edu.ifrs.restinga.comerlato.stickeralbum.model.entity.Sticker;
import br.edu.ifrs.restinga.comerlato.stickeralbum.repository.dao.AlbumDAO;
import br.edu.ifrs.restinga.comerlato.stickeralbum.repository.dao.StickerDAO;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Random;

import static br.edu.ifrs.restinga.comerlato.stickeralbum.model.util.EntityFactory.createAlbum;
import static br.edu.ifrs.restinga.comerlato.stickeralbum.model.util.EntityFactory.createSticker;
import static br.edu.ifrs.restinga.comerlato.stickeralbum.model.util.constants.StringConstants.*;

@Slf4j
@Component
@AllArgsConstructor
public class DAORunner {

    private StickerDAO stickerDAO;
    private AlbumDAO albumDAO;

    private static final Random random = new Random();

    @Bean
    private CommandLineRunner runDAO() {
        return args -> {
            final var stickers = new ArrayList<Sticker>();
            final var albums = new ArrayList<Album>();

            for (int i = 0; i < 30; i++) {
                stickers.add(createSticker());
            }

            for (int i = 0; i < 10; i++) {
                albums.add(createAlbum());
            }

            stickers.forEach(sticker -> sticker.setAlbum(albums.get(random.nextInt(albums.size()))));

            stickerDAO.saveAll(stickers);
            albumDAO.saveAll(albums);

            albumDAO.findAll().forEach(album -> log.info("SAVED ALBUM\n" + album));
            stickerDAO.findAll().forEach(sticker -> log.info("SAVED STICKER\n" + sticker));


            log.warn("ALBUM-findAllByNameOrderByNameAsc[" + ALBUM_NAME_1 + "]");
            albumDAO.findAllByNameOrderByNameAsc(ALBUM_NAME_1).forEach(
                    album -> log.info("ID = " + album.getId() + "\n" + album)
            );

            log.warn("ALBUM-findAllByNameOrderByNameAsc[" + ALBUM_NAME_2 + "]");
            albumDAO.findAllByNameOrderByNameAsc(ALBUM_NAME_2).forEach(
                    album -> log.info("ID = " + album.getId() + "\n" + album)
            );

            log.warn("ALBUM-findAllByNameOrderByNameAsc[" + ALBUM_NAME_3 + "]");
            albumDAO.findAllByNameOrderByNameAsc(ALBUM_NAME_3).forEach(
                    album -> log.info("ID = " + album.getId() + "\n" + album)
            );

            log.warn("ALBUM-findAllByHostCountryContainingOrderByNameAsc[" + HOST_COUNTRY_1 + "]");
            albumDAO.findAllByHostCountryContainingOrderByNameAsc(HOST_COUNTRY_1).forEach(
                    album -> log.info("ID = " + album.getId() + "\n" + album)
            );

            log.warn("ALBUM-findAllByHostCountryContainingOrderByNameAsc[" + HOST_COUNTRY_2 + "]");
            albumDAO.findAllByHostCountryContainingOrderByNameAsc(HOST_COUNTRY_2).forEach(
                    album -> log.info("ID = " + album.getId() + "\n" + album)
            );

            log.warn("ALBUM-findAllByHostCountryContainingOrderByNameAsc[" + HOST_COUNTRY_3 + "]");
            albumDAO.findAllByHostCountryContainingOrderByNameAsc(HOST_COUNTRY_3).forEach(
                    album -> log.info("ID = " + album.getId() + "\n" + album)
            );

            final var year = random.nextInt(1900, 1970);
            log.warn("ALBUM-findAllByYearGreaterThanOrderByYearAsc[" + year + "]");
            albumDAO.findAllByYearGreaterThanOrderByYearAsc(year).forEach(
                    album -> log.info("ID = " + album.getId() + "\n" + album)
            );

            final var specialQuantity = random.nextInt(1, 5);
            log.warn("ALBUM-findAllBySpecialStickersGreaterThanOrderBySpecialStickersAsc[" + specialQuantity + "]");
            albumDAO.findAllBySpecialStickersGreaterThanOrderBySpecialStickersAsc(specialQuantity).forEach(
                    album -> log.info("ID = " + album.getId() + "\n" + album)
            );

            final var sampleSticker = stickers.get(random.nextInt(stickers.size()));
            log.warn("ALBUM-getAlbumBySticker[" + sampleSticker.getId() + "." + sampleSticker.getName() + "]");
            albumDAO.getAlbumBySticker(sampleSticker).ifPresent(
                    album -> log.info("ID = " + album.getId() + "\n" + album)
            );

            log.warn("STICKER-findAllByRareTrue");
            stickerDAO.findAllByRareTrue().forEach(
                    sticker -> log.info("ID = " + sticker.getId() + "\n" + sticker)
            );

            log.warn("STICKER-findAllByTeamContainingOrderByNameDesc[" + STICKER_TEAM_1 + "]");
            stickerDAO.findAllByTeamContainingOrderByNameDesc(STICKER_TEAM_1).forEach(
                    sticker -> log.info("ID = " + sticker.getId() + "\n" + sticker)
            );

            log.warn("STICKER-findAllByTeamContainingOrderByNameDesc[" + STICKER_TEAM_2 + "]");
            stickerDAO.findAllByTeamContainingOrderByNameDesc(STICKER_TEAM_2).forEach(
                    sticker -> log.info("ID = " + sticker.getId() + "\n" + sticker)
            );

            log.warn("STICKER-findAllByTeamContainingOrderByNameDesc[" + STICKER_TEAM_3 + "]");
            stickerDAO.findAllByTeamContainingOrderByNameDesc(STICKER_TEAM_3).forEach(
                    sticker -> log.info("ID = " + sticker.getId() + "\n" + sticker)
            );

            log.warn("STICKER-findAllByPositionContainingOrderByNameDesc[" + POSITION_1 + "]");
            stickerDAO.findAllByPositionContainingOrderByNameDesc(POSITION_1).forEach(
                    sticker -> log.info("ID = " + sticker.getId() + "\n" + sticker)
            );

            log.warn("STICKER-findAllByPositionContainingOrderByNameDesc[" + POSITION_2 + "]");
            stickerDAO.findAllByPositionContainingOrderByNameDesc(POSITION_1).forEach(
                    sticker -> log.info("ID = " + sticker.getId() + "\n" + sticker)
            );

            log.warn("STICKER-findAllByPositionContainingOrderByNameDesc[" + POSITION_3 + "]");
            stickerDAO.findAllByPositionContainingOrderByNameDesc(POSITION_1).forEach(
                    sticker -> log.info("ID = " + sticker.getId() + "\n" + sticker)
            );

            log.warn("STICKER-findAllByPositionContainingAndTeamContainingOrderByTeamDesc[" + POSITION_1 + ", " + STICKER_TEAM_1 + "]");
            stickerDAO.findAllByPositionContainingAndTeamContainingOrderByTeamDesc(
                    POSITION_1, STICKER_TEAM_1
            ).forEach(
                    sticker -> log.info("ID = " + sticker.getId() + "\n" + sticker)
            );

            log.warn("STICKER-findAllByPositionContainingAndTeamContainingOrderByTeamDesc[" + POSITION_2 + ", " + STICKER_TEAM_2 + "]");
            stickerDAO.findAllByPositionContainingAndTeamContainingOrderByTeamDesc(
                    POSITION_2, STICKER_TEAM_2
            ).forEach(
                    sticker -> log.info("ID = " + sticker.getId() + "\n" + sticker)
            );

            log.warn("STICKER-findAllByPositionContainingAndTeamContainingOrderByTeamDesc[" + POSITION_3 + ", " + STICKER_TEAM_3 + "]");
            stickerDAO.findAllByPositionContainingAndTeamContainingOrderByTeamDesc(
                    POSITION_3, STICKER_TEAM_3
            ).forEach(
                    sticker -> log.info("ID = " + sticker.getId() + "\n" + sticker)
            );

            final var sampleAlbum = albums.get(random.nextInt(albums.size()));
            log.warn("STICKER-getStickersByAlbum[" + sampleAlbum.getId() + "." + sampleAlbum.getName() + "]");
            stickerDAO.getStickersByAlbum(sampleAlbum).forEach(
                    sticker -> log.info("ID = " + sticker.getId() + "\n" + sticker)
            );

            albums.forEach(album -> {
                log.warn("STICKER-getStickersByAlbumAndTeam[" + album.getId() + "." + album.getName() + ", " + STICKER_TEAM_1 + "]");
                stickerDAO.getStickersByAlbumAndTeam(album, STICKER_TEAM_1).forEach(
                        sticker -> log.info("ID = " + sticker.getId() + "\n" + sticker)
                );
            });
        };
    }
}
