package jpa.pricehoon.mybatis;// 이외 의존성 클래스는 아래 깃헙링크 참조
// https://github.com/thesun4sky/jpastudy/tree/work-tea-1day/src/test/java/me/whitebear/jpastudy/mybatis

import jpa.pricehoon.mybatis.configuration.DBConfiguration;
import jpa.pricehoon.mybatis.mapper.AccountMapper;
import jpa.pricehoon.mybatis.mapper.AccountMapperV2;
import jpa.pricehoon.mybatis.vo.AccountMyBatisVO;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mybatis.spring.boot.test.autoconfigure.MybatisTest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.Import;

@SpringBootTest
@MybatisTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
@Import(DBConfiguration.class)


public class MyBatisTest {

    // Mapper 클래스를 받으려면 mapper.xml 빌드 해야하고, 그러려면 main 으로 옮겨서 해야함...
    @Autowired
    AccountMapper accountMapper;// xml 로 쿼리관리

    @Autowired
    AccountMapperV2 accountMapperV2;// annotation 으로 쿼리관리

    @Test
    @DisplayName("SQL Mapper - MyBatis 실습(XML)")
    void sqlMapper_MyBatisTest() {
        // given

        // when
        accountMapper.insertAccount(new AccountMyBatisVO("new user3", "new password3"));
        var account = accountMapper.selectAccount(1);

        // then
        assert !account.getUsername().isEmpty();
    }

    @Test
    @DisplayName("SQL Mapper - MyBatis V2 실습(Annotation")
    void sqlMapper_MyBatisV2Test() {
        // given

        // when
        accountMapperV2.insertAccount(new AccountMyBatisVO("new user4", "new password4"));
        var account = accountMapperV2.selectAccount(1);

        // then
        assert !account.getUsername().isEmpty();
    }
}