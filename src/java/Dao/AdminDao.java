/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Dao;

import Entity.Admin;
import Utility.DBConnection;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author durmus
 */
public class AdminDao {

    public  int Search(Admin admin) {
        DBConnection connector = new DBConnection();
        Connection connection = connector.Connect();
        PreparedStatement ps = null;

        try {
            ps = connection.prepareStatement("Select id,email, password,id from admin where email = ? and password = ?");
            ps.setString(1, admin.getEmail());
            ps.setString(2, admin.getPassword());
            ResultSet rs = ps.executeQuery();
            if (rs.next() == true) {
                return rs.getInt("id");
            } else {
                return 0;
            }

        } catch (SQLException e) {
            System.out.println(e.getMessage());
            return 0;
        }

    }

}
