package jpa.pricehoon.my;

import jakarta.persistence.EntityManager;
import jpa.pricehoon.user.User;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class MyRepositoryCreateImpl implements MyRepositoryCreate<User>{


    @Autowired
    EntityManager entityManager;

    @Override
    public void delete(User user) {

        entityManager.remove(user);
    }

    //유저의 이름만 가져올 수 있는 리파지토리로 커스텀한 것
    @Override
    public List<String> findNameAll() {

        return entityManager.createQuery("SELECT u.username FROM User as u",String.class).getResultList();
    }
}
