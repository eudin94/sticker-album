package br.edu.ifrs.restinga.comerlato.stickeralbum.runner.jpa;

import br.edu.ifrs.restinga.comerlato.stickeralbum.model.entity.Album;
import br.edu.ifrs.restinga.comerlato.stickeralbum.model.entity.Sticker;
import br.edu.ifrs.restinga.comerlato.stickeralbum.repository.jpa.AlbumRepository;
import br.edu.ifrs.restinga.comerlato.stickeralbum.repository.jpa.StickerRepository;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

import java.util.List;

import static java.lang.Boolean.FALSE;

@Slf4j
@Component
@AllArgsConstructor
public class JPARunner {

    private StickerRepository stickerRepository;
    private AlbumRepository albumRepository;

    @Bean
    private CommandLineRunner runJPA() {
        return args -> {

            final Sticker sticker = new Sticker(
                    FALSE, FALSE, "1.0", "Dummy"
            );
            final Album album = new Album(
                    "Soccer Album", "Dummylands", 1980, List.of("Dummers"), "New 1.0"
            );

            log.info("CREATED\n" + sticker);
            log.info("CREATED\n" + album);

            stickerRepository.save(sticker);
            albumRepository.save(album);

            log.info("SAVED\n" + sticker);
            log.info("SAVED\n" + album);

            sticker.setAlbum(album);
            stickerRepository.save(sticker);

            final var retrievedSticker = stickerRepository.findFirstByAlbum_Id(album.getId()).orElse(null);
            final var retrievedAlbum = albumRepository.findByStickerId(sticker.getId()).orElse(null);

            log.info("RETRIEVED\n" + retrievedSticker);
            log.info("RETRIEVED\n" + retrievedAlbum);
        };
    }
}
