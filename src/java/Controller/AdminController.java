/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Dao.AdminDao;
import Entity.Admin;
import Functions.SopDate;
import Utility.VerifyRecaptcha;
import java.io.IOException;
import java.io.Serializable;
import java.util.List;
import javax.enterprise.context.SessionScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Named;
import javax.servlet.http.HttpSession;

/**
 *
 * @author durmus
 */
@Named
@SessionScoped
public class AdminController implements Serializable {

    private List<Admin> adminlist;
    private AdminDao admindao;
    private Admin admin;

    public List<Admin> getAdminlist() {
        return adminlist;
    }

    public void setAdminlist(List<Admin> adminlist) {
        this.adminlist = adminlist;
    }

    public AdminDao getAdmindao() {
        if (this.admindao == null) {
            this.admindao = new AdminDao();
        }
        return admindao;
    }

    public void setAdmindao(AdminDao admindao) {
        this.admindao = admindao;
    }

    public Admin getAdmin() {
        if (this.admin == null) {
            this.admin = new Admin();
        }
        return admin;
    }

    public void setAdmin(Admin admin) {
        this.admin = admin;
    }

    public String login() throws IOException {
        String gRecaptchaResponse = FacesContext.getCurrentInstance().
                getExternalContext().getRequestParameterMap().get("g-recaptcha-response");
        boolean verify = VerifyRecaptcha.verify(gRecaptchaResponse);
        int giris;

        if (this.admin.getEmail().equals("") || this.admin.getPassword().equals("")) {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Lütfen bütün alanları doldurun"));
            return "/Admin/login";
        } else {
            if (1==1) {
                giris = this.getAdmindao().Search(this.admin);
                if (giris>0) {
                    //Birinden biri
                    FacesContext context2 = FacesContext.getCurrentInstance();
                    HttpSession session = (HttpSession) context2.getExternalContext().getSession(true);
                    session.setAttribute("admin", this.admin.getEmail());
                    session.setAttribute("password", this.admin.getPassword());
                    SopDate pass=new SopDate();
                    session.setAttribute("id", pass.encrypt(String.valueOf(giris)));
                    
                    //birinden biri
                    //FacesContext.getCurrentInstance().getExternalContext().getSessionMap().put("valid_user", this.admin.getEmail());

                    return "/Admin/Pages/dashboard?faces-redirect=true";
                } else {
                    FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Giriş Başarisiz"));
                    return "/Admin/login";
                }

            } else {
                FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Robot kontrolü boş!"));
                return "/Admin/login";
            }
        }
    }
}
