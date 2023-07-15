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

            final var albumName = albums.get(random.nextInt(albums.size())).getName();
            log.warn("ALBUM-findAllByNameOrderByNameAsc[" + albumName + "]");
            albumDAO.findAllByNameOrderByNameAsc(albumName).forEach(
                    album -> log.info("\nID = " + album.getId() + "\n" + album)
            );

            final var hostCountry = albums.get(random.nextInt(albums.size())).getHostCountry();
            log.warn("ALBUM-findAllByHostCountryContainingOrderByNameAsc[" + hostCountry + "]");
            albumDAO.findAllByHostCountryContainingOrderByNameAsc(hostCountry).forEach(
                    album -> log.info("\nID = " + album.getId() + "\n" + album)
            );

            final var year = random.nextInt(1900, 1970);
            log.warn("ALBUM-findAllByYearGreaterThanOrderByYearAsc[" + year + "]");
            albumDAO.findAllByYearGreaterThanOrderByYearAsc(year).forEach(
                    album -> log.info("\nID = " + album.getId() + "\n" + album)
            );

            final var specialQuantity = random.nextInt(1, 5);
            log.warn("ALBUM-findAllBySpecialStickersGreaterThanOrderBySpecialStickersAsc[" + specialQuantity + "]");
            albumDAO.findAllBySpecialStickersGreaterThanOrderBySpecialStickersAsc(specialQuantity).forEach(
                    album -> log.info("\nID = " + album.getId() + "\n" + album)
            );

            final var sampleSticker = stickers.get(random.nextInt(stickers.size()));
            log.warn("ALBUM-getAlbumBySticker[" + sampleSticker.getId() + "." + sampleSticker.getName() + "]");
            albumDAO.getAlbumBySticker(sampleSticker).ifPresent(
                    album -> log.info("\nID = " + album.getId() + "\n" + album)
            );

            log.warn("STICKER-findAllByRareTrue");
            stickerDAO.findAllByRareTrue().forEach(
                    sticker -> log.info("\nID = " + sticker.getId() + "\n" + sticker)
            );

            final var randomIndex = random.nextInt(stickers.size());

            final var team = stickers.get(randomIndex).getTeam();
            log.warn("STICKER-findAllByTeamContainingOrderByNameDesc[" + team + "]");
            stickerDAO.findAllByTeamContainingOrderByNameDesc(team).forEach(
                    sticker -> log.info("\nID = " + sticker.getId() + "\n" + sticker)
            );

            final var position = stickers.get(randomIndex).getPosition();
            log.warn("STICKER-findAllByPositionContainingOrderByNameDesc[" + position + "]");
            stickerDAO.findAllByPositionContainingOrderByNameDesc(position).forEach(
                    sticker -> log.info("\nID = " + sticker.getId() + "\n" + sticker)
            );

            log.warn("STICKER-findAllByPositionContainingAndTeamContainingOrderByTeamDesc[" + position + ", " + team + "]");
            stickerDAO.findAllByPositionContainingAndTeamContainingOrderByTeamDesc(
                    stickers.get(randomIndex).getPosition(), stickers.get(randomIndex).getTeam()
            ).forEach(
                    sticker -> log.info("\nID = " + sticker.getId() + "\n" + sticker)
            );

            final var sampleAlbum = albums.get(random.nextInt(albums.size()));
            log.warn("STICKER-getStickersByAlbum[" + sampleAlbum.getId() + "." + sampleAlbum.getName() + "]");
            stickerDAO.getStickersByAlbum(sampleAlbum).forEach(
                    sticker -> log.info("\nID = " + sticker.getId() + "\n" + sticker)
            );

            albums.forEach(album -> {
                log.warn("STICKER-getStickersByAlbumAndTeam[" + album.getId() + "." + album.getName() + ", " + team + "]");
                stickerDAO.getStickersByAlbumAndTeam(album, team).forEach(
                        sticker -> log.info("\nID = " + sticker.getId() + "\n" + sticker)
                );
            });
        };
    }
}
