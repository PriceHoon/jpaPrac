package jpa.pricehoon.thread;


import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jdk.jfr.Percentage;
import jpa.pricehoon.user.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;
import org.springframework.data.repository.RepositoryDefinition;
import org.springframework.stereotype.Repository;

import java.util.Optional;


public interface ThreadRepository extends JpaRepository<Thread,Long>, QuerydslPredicateExecutor<Thread> {



    //변경 전
//    @PersistenceContext
//    EntityManager entityManager;
//
//
//    public Thread insertThread(Thread thread){
//        entityManager.persist(thread);
//        return thread;
//    }
//
//    public Thread selectThread(Long id){
//        return entityManager.find(Thread.class,id);
//    }
}
