package root.service;

import java.io.Serializable;
import java.util.List;
import java.util.Optional;

public interface BaseService<T, ID extends Serializable> {
    <S extends T> S save(S entity);
    Optional<T> findById(ID primaryKey);
    List<T> findAll();
    void delete(T entity);
    void deleteById(ID primaryKey);

}
