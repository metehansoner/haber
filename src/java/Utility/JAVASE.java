/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Utility;

import Dao.DocumentDao;
import Entity.Document;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;
import sun.misc.BASE64Encoder;

/**
 *
 * @author durmus
 */
public class JAVASE {

    public static void main(String[] args) {
        DBConnection db = new DBConnection();
        Connection c = db.Connect();
        PreparedStatement ps = null;
        SimpleDateFormat bicim = new SimpleDateFormat("dd-M-yyyy hh:mm:ss");
        Date tarihSaat = new Date();
        String str = "Metehan";

        Random rand = new Random((new Date()).getTime());
        BASE64Encoder encoder = new BASE64Encoder();

        byte[] salt = new byte[8];

        rand.nextBytes(salt);

        // System.out.println(encoder.encode(salt) + encoder.encode(str.getBytes()));
     
            
            //String k = "mete";
            //int id = 1;
            //String sql = "INSERT INTO site_ayar(adminid,title,abouttext,footertext,sitetext,durum) VALUES(?,?,?,?,?,?)";
            //ps = c.prepareStatement(sql);
            //ps.setInt(1, 1);
            //ps.setString(2, k);
            //ps.setString(3, k);
            //ps.setString(4, k);
            //ps.setString(5, k);
            //ps.setInt(6,1);

            //int i = ps.executeUpdate();
            DocumentDao dao=new DocumentDao();
            Document d=new Document();
            System.out.print(d.getYol());
            //dao.DocumentInsert();
            

        
}}
