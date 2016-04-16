package com.epam.DBController.Entities.DAO;

import com.epam.DBController.ConnectionFabric;
import com.epam.DBController.Entities.Token;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by vrama on 16.04.2016.
 */
public class UserDAO {

    public List<Token> getTokensById(Long userID) {
        List<Token> tokens = new ArrayList<>();

        try(Connection con = ConnectionFabric.getDataSource().getConnection()) {
            PreparedStatement ps = con.prepareStatement("SELECT token FROM user_tokens, users" +
                    "WHERE users.id = " + userID + "AND users.id = user_tokens.user_id");
            ResultSet rs = ps.executeQuery();

            while(rs.next()) {
                Token token = new Token();
                token.setToken(rs.getString(1));
                tokens.add(token);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return tokens;
    }
}
