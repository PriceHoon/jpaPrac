package jpa.pricehoon.jdbc.dao;

import jpa.pricehoon.jdbc.vo.AccountVO;

import java.sql.*;

public class AccountDAO {

    //JDBC관련 변수

    private Connection conn = null;

    private PreparedStatement stmt = null;

    private ResultSet rs = null;

    private String url = "jdbc:postgresql://localhost:5432/messenger";
    private String username = "sanghoon";
    private String password = "pass";

    // SQL쿼리
    private final String ACCOUNT_INSERT = "INSERT INTO account(ID, USERNAME, PASSWORD)"
            +"VALUES((SELECT coalesce(MAX(ID), 0) +1 FROM ACCOUNT A), ?, ?)";

    private final String ACCOUNT_SELECT = "SELECT * FROM account WHERE ID = ?";

    //CRUD 기능 메소드

    public Integer insertAccount(AccountVO accountVO) throws SQLException {
        var id = -1;
        try{

            String [] returnId = {"id"};
            conn = DriverManager.getConnection(url,username,password);
            stmt = conn.prepareStatement(ACCOUNT_INSERT,returnId);
            stmt.setString(1,accountVO.getUsername());
            stmt.setString(2,accountVO.getPassword());
            stmt.executeUpdate(); // 따고 들어가보면 id가 아닌 count를 리턴

            try(ResultSet rs = stmt.getGeneratedKeys()){
                if(rs.next()){
                    id = rs.getInt(1);
                }
            }

        }catch (SQLException sqlException){
            sqlException.printStackTrace();
        }

        return id;
    }

    public AccountVO selectAccount(Integer id) throws SQLException{

        AccountVO accountVO = null;

        try{
            conn = DriverManager.getConnection(url,username,password);
            stmt = conn.prepareStatement(ACCOUNT_SELECT);
            stmt.setInt(1,id);
            var rs = stmt.executeQuery(); // 따고 들어가보면 id가 아닌 count를 리턴

            if(rs.next()){
                accountVO = new AccountVO();
                accountVO.setId(rs.getInt("ID"));
                accountVO.setUsername(rs.getString("USERNAME"));
                accountVO.setPassword(rs.getString("PASSWORD"));

            }

        }catch (SQLException sqlException){
            sqlException.printStackTrace();
        }

        return accountVO;

    }
}
