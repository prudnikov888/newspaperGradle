package services;

import java.io.Serializable;

public interface IService<T> {

    void saveOrUpdate(T t);

    T get(Serializable id);

    void delete(T t);
}
