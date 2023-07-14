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

import static br.edu.ifrs.restinga.comerlato.stickeralbum.model.util.EntityFactory.createAlbum;
import static br.edu.ifrs.restinga.comerlato.stickeralbum.model.util.EntityFactory.createSticker;

@Slf4j
@Component
@AllArgsConstructor
public class DAORunner {

    private StickerDAO stickerDAO;
    private AlbumDAO albumDAO;

    @Bean
    private CommandLineRunner runDAO() {
        return args -> {
            final var stickers = new ArrayList<Sticker>();
            final var albums = new ArrayList<Album>();

            for (int i = 0; i < 20; i++) {
                stickers.add(createSticker());
            }

            for (int i = 0; i < 5; i++) {
                albums.add(createAlbum());
            }

            log.info("blab");
        };
    }
}
