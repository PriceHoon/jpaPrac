package jpa.pricehoon.channel;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;
import org.springframework.stereotype.Repository;

@Repository
public interface ChannelRepository extends JpaRepository<Channel,Long>, QuerydslPredicateExecutor<Channel> {

//, QuerydslPredicateExecutor<Channel> -> Querydsl사용을 위한 추가


    // 변경 전
//    @PersistenceContext
//    EntityManager entityManager;
//
//    public Channel insertChannel(Channel channel){
//        entityManager.persist(channel); // 영속성 상태로 만듬
//        return channel;
//    }
//
//    public Channel selectChannel(Long id){
//        return entityManager.find(Channel.class,id);
//    }
}
