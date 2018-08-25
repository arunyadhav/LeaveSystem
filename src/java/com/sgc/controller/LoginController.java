package com.sgc.controller;

import com.sgc.data.LoginDao;
import com.sgc.model.Login;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet(name = "LoginController", urlPatterns = {"/LoginController"})
public class LoginController extends HttpServlet {

   

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {

        }
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
    }
   
@Override
        protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
       if (request.getParameter("log") != null) {
           if(request.getParameter("log") != null && request.getParameter("select").equals("manager"))
           {
            Login log = new Login();
            LoginDao logdao = new LoginDao();
            String email=request.getParameter("email");
            String password=request.getParameter("password");
            log.setEmail(email);
            log.setPassword(password);
            log= LoginDao.logIn(log);
            if (log.isValid()) {
                
                HttpSession session = request.getSession(true);
                session.setAttribute("login", log);
                response.sendRedirect("success.jsp"); //logged-in page
            } else {
                response.sendRedirect("index.jsp"); //error page
            }
            }
        
       
       else if(request.getParameter("log") != null && request.getParameter("select").equals("employee"))
           {
            Login log = new Login();
            LoginDao logdao = new LoginDao();
            String email=request.getParameter("email");
            String password=request.getParameter("password");
            log.setEmail(email);
            log.setPassword(password);
            log= LoginDao.logEmp(log);
            if (log.isValid()) {
                
                HttpSession session = request.getSession(true);
                session.setAttribute("login", log);
                response.sendRedirect("Employee.jsp"); //logged-in page
            } else {
                response.sendRedirect("index.jsp"); //error page
            }
            }
       }
        }
    

    
    @Override
        public String getServletInfo() {
        return "Short description";
    }

    

}
