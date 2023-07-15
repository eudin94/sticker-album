package br.edu.ifrs.restinga.comerlato.stickeralbum.repository.dao;

import br.edu.ifrs.restinga.comerlato.stickeralbum.model.entity.Album;
import br.edu.ifrs.restinga.comerlato.stickeralbum.model.entity.Sticker;
import br.edu.ifrs.restinga.comerlato.stickeralbum.repository.dao.generic.GenericCrudRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface AlbumDAO extends GenericCrudRepository<Album, Long> {

    List<Album> findAllByNameOrderByNameAsc(final String name);

    List<Album> findAllByHostCountryContainingOrderByNameAsc(final String country);

    List<Album> findAllByYearGreaterThanOrderByYearAsc(final Integer year);

    List<Album> findAllBySpecialStickersGreaterThanOrderBySpecialStickersAsc(final Integer specialQuantity);

    @Query("SELECT a FROM Album a JOIN Sticker s ON s.album.id = a.id WHERE s = ?1")
    Optional<Album> getAlbumBySticker(final Sticker sticker);
}
