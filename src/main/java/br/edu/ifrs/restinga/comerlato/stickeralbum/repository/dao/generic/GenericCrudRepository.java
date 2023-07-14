package br.edu.ifrs.restinga.comerlato.stickeralbum.repository.dao.generic;

import org.springframework.data.repository.NoRepositoryBean;
import org.springframework.data.repository.Repository;

import java.util.Optional;

@NoRepositoryBean
public interface GenericCrudRepository<Type, ID> extends Repository<Type, ID> {

    <S extends Type> S save(S s);

    <S extends Type> Iterable<S> saveAll(Iterable<S> iterable);

    Optional<Type> findById(ID id);

    boolean existsById(ID id);

    Iterable<Type> findAll();

    Iterable<Type> findAllById(Iterable<ID> iterable);

    long count();

    void deleteById(ID id);

    void delete(Type t);

    void deleteAll(Iterable<? extends Type> iterable);

    void deleteAll();
}
