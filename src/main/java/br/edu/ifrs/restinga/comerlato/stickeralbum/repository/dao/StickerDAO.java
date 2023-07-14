package br.edu.ifrs.restinga.comerlato.stickeralbum.repository.dao;

import br.edu.ifrs.restinga.comerlato.stickeralbum.model.entity.Sticker;
import br.edu.ifrs.restinga.comerlato.stickeralbum.repository.dao.generic.GenericCrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StickerDAO extends GenericCrudRepository<Sticker, Long> {

    List<Sticker> findAllByRareTrue();

    List<Sticker> findAllByTeamContainingOrderByNameDesc(final String team);

    List<Sticker> findAllByPositionContainingOrderByNameDesc(final String position);

    List<Sticker> findAllByPositionContainingAndTeamContainingOrderByTeamDesc(final String position, final String team);
}
