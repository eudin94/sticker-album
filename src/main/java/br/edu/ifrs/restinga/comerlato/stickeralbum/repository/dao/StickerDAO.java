package br.edu.ifrs.restinga.comerlato.stickeralbum.repository.dao;

import br.edu.ifrs.restinga.comerlato.stickeralbum.model.entity.Sticker;
import br.edu.ifrs.restinga.comerlato.stickeralbum.repository.dao.generic.GenericCrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StickerDAO extends GenericCrudRepository<Sticker, Long> {
}
