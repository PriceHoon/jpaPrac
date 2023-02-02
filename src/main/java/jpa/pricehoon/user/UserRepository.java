package jpa.pricehoon.user;

import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;


//@RepositoryDefinition(domainClass = User.class ,idClass = Long.class)//내가 Repository에 선언해준 메서드만 사용할 수 있음
public interface UserRepository extends JpaRepository<User,Long>{

    //페이징 실습
    // 아래와 같이 AS user_password 로 Alias(AS) 를 걸어주면
    @Query("SELECT u, u.password AS user_password FROM User u WHERE u.username = ?1")
    List<User> findByUsername(String username, Sort sort);

    // 아래와 같이 일반적인 쿼리에서
    @Query("SELECT u FROM User u WHERE u.username = ?1") // 이건 없어도됨
    List<User> findByUsernameWithLength(String username, Sort sort);

    // 이렇게 해당 user_password 를 기준으로 정렬할 수 있다.
    //List<User> users = findByUsername("user", Sort.by("user_password"));


    //, MyRepositoryCreate<User> << 커스텀 한 리파지토리를 쓰고 싶다면..

    //findByPassword를 막아주기위해!!! -> 깊은 뜻..!
   // public Optional<User> findByUsername(String username);

    // 기존의 Repository
//    @PersistenceContext
//    EntityManager entityManager;
//
//    public User insertUser(User user){
//        entityManager.persist(user);
//        return user;
//    }
//
//    public User selectUser(Long id){
//       return entityManager.find(User.class,id);
//    }
}
