package org.example;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class TicketDao {
    Connection con = null;
    PreparedStatement ps = null;
    ResultSet rs = null;
    int st;

    public int insert(String username, int count) {
        con = ConnectionFactory.getConnection();
        try {
            String query = "insert into ticket(username,guesses) " + "values(?,?)";
            ps = con.prepareStatement(query);
            ps.setString(1, username);
            ps.setInt(2, count);
            st = ps.executeUpdate();
            System.out.println("inserted ticket " + st);
        } catch (Exception e) {
            st = -2;
            e.printStackTrace();
        } finally {
            try {
                con.close();
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        }
        return st;
    }

}
