package it.epicode.dao.interfaces;

import java.util.Optional;

public interface Dao<T> extends AutoCloseable{
    /**
     * Salva un'entità.
     *
     * @param e l'entità da salvare.
     */
    T save(T e);

    /**
     * Recupera un'entità attraverso la chiave.
     *
     * @param id chiave dell'entità da recuperare.
     * @return l'entità richiesta, se trovata, oppure un {@code Optional} vuoto.
     */
    Optional<T> getById(String query, Class<T> entityType, long id);


    void deleteById(String query, Class<T> entityType, long id);
}
