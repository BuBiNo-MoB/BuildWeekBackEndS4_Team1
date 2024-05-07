package it.epicode.dao.interfaces;

import java.util.Optional;

public interface Dao<T> extends AutoCloseable{

    T save(T e);

}
