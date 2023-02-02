package jpa.pricehoon.my;

import java.util.List;

public interface MyRepositoryCreate <T>{

    void delete(T entity);

    List<String> findNameAll();
}
