/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Dao.DocumentDao;
import Entity.Document;
import Functions.SopDate;
import java.io.File;
import java.io.InputStream;
import java.io.Serializable;
import java.nio.file.Files;
import java.util.List;
import javax.enterprise.context.SessionScoped;
import javax.faces.context.FacesContext;
import javax.inject.Named;
import javax.servlet.http.HttpSession;
import javax.servlet.http.Part;

/**
 *
 * @author durmus
 */
@Named
@SessionScoped
public class DocumentController implements Serializable {
    private Document document;
    private List<Document> documentList;
    private DocumentDao documentdao;
    private Part doc; 
    private String uploadpath="C:/Users/durmus/Documents/NetBeansProjects/mhaber/web/resources/images/";
    public void upload(){
        try{
        InputStream input=doc.getInputStream();
        File file=new File(uploadpath+doc.getSubmittedFileName());
        Files.copy(input, file.toPath());
        DocumentDao dao=new DocumentDao();
        FacesContext context2 = FacesContext.getCurrentInstance();
        HttpSession session = (HttpSession) context2.getExternalContext().getSession(true);
        SopDate pass=new SopDate();
        String id=pass.decrypt((String) session.getAttribute("id")) ;
        
        document.setYol("/resources/images/"+doc.getSubmittedFileName());
        document.setAdminid(Integer.valueOf(id));
        dao.DocumentInsert(document);
        }
        catch(Exception ex){
        System.out.println(ex.getMessage());
        }
    }
    
    
    
    public Document getDocument() {
        if(this.document==null)
            this.document=new Document();
        return document;
    }

    public void setDocument(Document document) {
        this.document = document;
    }

    public List<Document> getDocumentList() {
        this.documentList=this.getDocumentdao().findAll();
        return documentList;
    }

    public void setDocumentList(List<Document> documentList) {
        this.documentList = documentList;
    }

    public DocumentDao getDocumentdao() {
        if(this.documentdao==null)
            this.documentdao=new DocumentDao();
        return documentdao;
    }

    public void setDocumentdao(DocumentDao documentdao) {
        this.documentdao = documentdao;
    }

    public Part getDoc() {
        return doc;
    }

    public void setDoc(Part doc) {
        this.doc = doc;
    }

    public String getUploadpath() {
        return uploadpath;
    }

    public void setUploadpath(String uploadpath) {
        this.uploadpath = uploadpath;
    }
    
    
}
