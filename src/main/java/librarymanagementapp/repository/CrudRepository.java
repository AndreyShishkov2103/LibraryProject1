package librarymanagementapp.repository;

import librarymanagementapp.entity.User;

import java.util.Collection;

public interface CrudRepository<K, V> {

    void put(V value);

    void put(Integer key, User value);

    V get (K key);

    void remove (K key);

    Collection<V> values();
}
