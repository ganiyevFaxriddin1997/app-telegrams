package services;

import java.nio.file.attribute.UserPrincipal;
import java.util.List;

/**
 * @param <T> ObjectRequest
 * @param <R> ObjectResponse
 * @param <I> UUID
 * @param <E> ObjectEntity
 */

public interface BaseService<T, R, I, E> {


    boolean create (T t);
    R get (I id);
    List<R> getList ();
    boolean delete(I id);
    boolean update (I id, T t);
    List<E> getData();
    boolean writeData(List<E> data);

    E getEntity (I id);
}
