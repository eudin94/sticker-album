package br.edu.ifrs.restinga.comerlato.stickeralbum.repository.dao;

import br.edu.ifrs.restinga.comerlato.stickeralbum.model.entity.Album;
import br.edu.ifrs.restinga.comerlato.stickeralbum.repository.dao.generic.GenericCrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AlbumDAO extends GenericCrudRepository<Album, Long> {

    List<Album> findAllByNameOrderByNameAsc(final String name);

    List<Album> findAllByHostCountryContainingOrderByHostCountryAsc(final String country);

    List<Album> findAllByYearGreaterThanOrderByYearAsc(final Integer year);

    List<Album> findAllBySpecialStickersGreaterThanOrderBySpecialStickersAsc(final Integer specialQuantity);

}
