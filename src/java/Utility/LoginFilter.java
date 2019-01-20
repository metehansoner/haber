/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Utility;

import Entity.Admin;
import java.io.IOException;
import javax.faces.application.ResourceHandler;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author durmus
 */
@WebFilter("/Admin/Pages/*")
public class LoginFilter implements Filter {

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        HttpServletRequest req = (HttpServletRequest) request;
        HttpServletResponse res = (HttpServletResponse) response;

        String url = req.getRequestURI();

         //Admin u = (Admin) req.getSession().getAttribute("valid_user"); Böyle olması gerekiyodu
         String u = (String) req.getSession().getAttribute("admin");
   
        if (u == null) {
            if (url.contains("/Pages/")) {
                res.sendRedirect(req.getContextPath() + "/Admin/login.xhtml");
            } else {
                chain.doFilter(request, response);
            }
        } else {
            if (url.contains("/login")) {
                res.sendRedirect(req.getContextPath() + "/Admin/Pages/dashboard.xhtml");
            } else if (url.contains("logout")) {
                req.getSession().invalidate();
                res.sendRedirect(req.getContextPath() + "/Admin/login.xhtml");
            } else {
                chain.doFilter(request, response);
            }
        }

    }
}
