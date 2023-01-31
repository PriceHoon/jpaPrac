package jpa.pricehoon.jdbc.template;

import jpa.pricehoon.jdbc.vo.AccountVO;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;


public class AccountRowMapper implements RowMapper<AccountVO> {

    @Override
    public AccountVO mapRow(ResultSet rs, int rowNum) throws SQLException {


        var accountVO = new AccountVO();


        accountVO = new AccountVO();
        accountVO.setId(rs.getInt("ID"));
        accountVO.setUsername(rs.getString("USERNAME"));
        accountVO.setPassword(rs.getString("PASSWORD"));


        return accountVO;
    }
}
