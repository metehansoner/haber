/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entity;

/**
 *
 * @author durmus
 */
public class Document {
    private String id;
    private int adminid;
    private String title;
    private String abouttext;
    private String footertext;
    private String sitetext;
    private int durum;
    private String yol;

    public int getAdminid() {
        return adminid;
    }

    public void setAdminid(int adminid) {
        this.adminid = adminid;
    }
    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAbouttext() {
        return abouttext;
    }

    public void setAbouttext(String abouttext) {
        this.abouttext = abouttext;
    }

    public String getFootertext() {
        return footertext;
    }

    public void setFootertext(String footertext) {
        this.footertext = footertext;
    }

    public String getSitetext() {
        return sitetext;
    }

    public void setSitetext(String sitetext) {
        this.sitetext = sitetext;
    }

    public int getDurum() {
        return durum;
    }

    public void setDurum(int durum) {
        this.durum = durum;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getYol() {
        return yol;
    }

    public void setYol(String yol) {
        this.yol = yol;
    }
    
}
