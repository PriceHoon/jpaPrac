package jpa.pricehoon.jdbc.template;

import jpa.pricehoon.jdbc.vo.AccountVO;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;

import java.sql.SQLException;

public class AccountTemplateDAO {

    private final JdbcTemplate jdbcTemplate;

    private final String ACCOUNT_INSERT = "INSERT INTO account(ID, USERNAME, PASSWORD)"
            +"VALUES((SELECT coalesce(MAX(ID), 0) +1 FROM ACCOUNT A), ?, ?)";

    private final String ACCOUNT_SELECT = "SELECT * FROM account WHERE ID = ?";
    public AccountTemplateDAO(JdbcTemplate jdbcTemplate) {

        this.jdbcTemplate = jdbcTemplate;

    }


    //CRUD 기능 메소드

    public Integer insertAccount(AccountVO accountVO) throws SQLException {
        KeyHolder keyHolder = new GeneratedKeyHolder();

        //DB연결정보 넣어서 connection객체만듬 -> 그 연결 객체에 SQL쿼리문 넣어서 PrepaerStatement객체만듬, 거기에 필요한 저장값,파라미터 등의 값 set!

        jdbcTemplate.update(con->{
            var ps = con.prepareStatement(ACCOUNT_INSERT,new String[]{"id"});
            ps.setString(1,accountVO.getUsername());
            ps.setString(2,accountVO.getPassword());
            return ps;
        },keyHolder);

        return (Integer) keyHolder.getKey();
    }

    public AccountVO selectAccount(Integer id) throws SQLException{

        return jdbcTemplate.queryForObject(ACCOUNT_SELECT, new AccountRowMapper(),id);

    }
}
