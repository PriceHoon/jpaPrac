package jpa.pricehoon.my;


import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.Import;

@Import(MyRepositoryRegistrar.class)
@SpringBootTest
public class MyRepositoryReistrarTest {

    @Autowired
    MyRepository myRepository;

    @Test
    void myRepositoryTest(){
        //given
        var newData = "New Data";
        var savedId = myRepository.save(newData);

        //when
        var savedData = myRepository.find(savedId);

        //then
        System.out.println(savedData);

    }
}
