package jpa.pricehoon.my;

import org.springframework.data.repository.NoRepositoryBean;
import org.springframework.data.repository.Repository;

import java.io.Serializable;
import java.util.List;
import java.util.Optional;

@NoRepositoryBean
public interface MyRepositoryDefinition<User,ID extends Serializable> extends Repository<User,ID> {

    //이렇게 작성하고 상속 받도록 하면됨.

    User save(User user);

   Optional<User> findByUsername(String username);
}
