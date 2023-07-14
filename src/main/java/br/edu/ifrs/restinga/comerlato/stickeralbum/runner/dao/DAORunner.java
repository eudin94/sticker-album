package br.edu.ifrs.restinga.comerlato.stickeralbum.runner.dao;

import br.edu.ifrs.restinga.comerlato.stickeralbum.repository.dao.AlbumDAO;
import br.edu.ifrs.restinga.comerlato.stickeralbum.repository.dao.StickerDAO;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

@Slf4j
@Component
@AllArgsConstructor
public class DAORunner {

    private StickerDAO stickerDAO;
    private AlbumDAO albumDAO;

    @Bean
    private CommandLineRunner runDAO() {
        return args -> {


        };
    }
}
