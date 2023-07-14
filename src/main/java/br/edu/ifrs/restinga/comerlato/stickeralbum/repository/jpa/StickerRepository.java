package br.edu.ifrs.restinga.comerlato.stickeralbum.repository.jpa;

import br.edu.ifrs.restinga.comerlato.stickeralbum.model.entity.Sticker;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface StickerRepository extends JpaRepository<Sticker, Long> {

    Optional<Sticker> findFirstByAlbum_Id(final Long albumId);
}
