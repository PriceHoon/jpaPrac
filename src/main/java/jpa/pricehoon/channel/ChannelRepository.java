package jpa.pricehoon.channel;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.springframework.stereotype.Repository;

@Repository
public class ChannelRepository {

    @PersistenceContext
    EntityManager entityManager;

    public Channel insertChannel(Channel channel){
        entityManager.persist(channel); // 영속성 상태로 만듬
        return channel;
    }

    public Channel selectChannel(Long id){
        return entityManager.find(Channel.class,id);
    }
}
