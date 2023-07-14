package br.edu.ifrs.restinga.comerlato.stickeralbum.repository.jpa;

import br.edu.ifrs.restinga.comerlato.stickeralbum.model.entity.Album;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface AlbumRepository extends JpaRepository<Album, Long> {

    @Query("SELECT a FROM Album a JOIN FETCH a.teams t JOIN a.stickerList s WHERE s.id = ?1")
    Optional<Album> findByStickerId(final Long stickerId);
}
