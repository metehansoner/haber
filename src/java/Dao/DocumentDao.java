/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Dao;

import Entity.Document;
import Functions.SopDate;
import Utility.DBConnection;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpSession;

/**
 *
 * @author durmus
 */
public class DocumentDao {

    private DBConnection connector;
    private Connection connection;

    public List<Document> findAll() {
        List<Document> list = new ArrayList<>();

        return list;
    }

    public void DocumentInsert(Document document) {
        SopDate pass = new SopDate();
        DBConnection db = new DBConnection();
        Connection c = db.Connect();
        PreparedStatement ps = null;
        String query = "INSERT INTO site_ayar(adminid,title,abouttext,footertext,sitetext,durum,yol) VALUES(?,?,?,?,?,?,?)";
        if (document.getTitle().equals("")) {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Lütfen içerik kısmını doldurunuz"));
        }
        else if (document.getAbouttext().equals("")) {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Lütfen hakkında kısmını doldurunuz"));
        }
        else if (document.getFootertext().equals("")) {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Lütfen footer kısmını doldurunuz"));
        }
       else if (document.getSitetext().equals("")) {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Lütefen başlik kısmını doldurunuz"));
        }
       else{
        try {
            ps = c.prepareStatement(query);
            ps.setInt(1, document.getAdminid());
            ps.setString(2, document.getTitle());
            ps.setString(3, document.getAbouttext());
            ps.setString(4, document.getFootertext());
            ps.setString(5, document.getSitetext());
            ps.setInt(6, document.getDurum());
            ps.setString(7, document.getYol());
            int i = ps.executeUpdate();
            if(i==1){
             FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Yükleme işlemi başarılı"));
            }

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
       }
    }

    public DBConnection getConnector() {
        if (this.connector == null) {
            this.connector = new DBConnection();
        }
        return connector;
    }

    public Connection getConnection() {
        if (this.connection == null) {
            this.connection = this.getConnector().Connect();
        }
        return connection;
    }

}
