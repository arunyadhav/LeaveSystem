package com.sgc.data;

import com.sgc.model.Login;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class LoginDao {

    static Connection conn = MyDB.connect();
    static Statement st=null;
    static ResultSet rs = null;  
    

    public static Login logIn(Login log) {
        try {
            String email, password;
            email = log.getEmail();
            password = log.getPassword();
            String query = "select Name,Password from login where Name='" + email + "' and Password='" + password + "'";
            st =conn.createStatement();
            ResultSet rs = st.executeQuery(query);
            boolean more = rs.next();
            if (!more) {
                System.out.println("Sorry, you are not a registered user! Please sign up first");
                log.setValid(false);
            } //if user exists set the isValid variable to true
            else if (more) {
                String Name = rs.getString("Name");
                String Password = rs.getString("Password");
                
                System.out.println("Welcome " + Name);
                log.setEmail(Name);
                log.setPassword(Password);
                log.setValid(true);
            }
        } catch (SQLException ex) {
            //Logger.getLogger(LoginDao.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("Testing error: " + ex.getMessage() + ex);
        }
        
        return log;
    }
    
    public static Login logEmp(Login log) {
        try {
            String email, password;
            email = log.getEmail();
            password = log.getPassword();
            String query = "select Name,Password from loginEmp where Name='" + email + "' and Password='" + password + "'";
            st =conn.createStatement();
            ResultSet rs = st.executeQuery(query);
            boolean more = rs.next();
            if (!more) {
                System.out.println("Sorry, you are not a registered user! Please sign up first");
                log.setValid(false);
            } //if user exists set the isValid variable to true
            else if (more) {
                String Name = rs.getString("Name");
                String Password = rs.getString("Password");
                
                System.out.println("Welcome " + Name);
                log.setEmail(Name);
                log.setPassword(Password);
                log.setValid(true);
            }
        } catch (SQLException ex) {
            //Logger.getLogger(LoginDao.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("Testing error: " + ex.getMessage() + ex);
        }
        
        return log;
    }

//                catch (Exception ex) 
//              {
//                 System.out.println("Log In failed: An Exception has occurred! " + ex);
//              } 
//	    
//      //some exception handling
//      finally 
//      {
//         if (rs != null)	{
//            try {
//               rs.close();
//            } catch (Exception e) {}
//               rs = null;
//            }
//	
//         if (st != null) {
//            try {
//               st.close();
//            } catch (Exception e) {}
//               st = null;
//            }
//	
//         if (conn != null) {
//            try {
//               conn.close();
//            } catch (Exception e) {
//            }
//
//            conn = null;
//         }
//      }
//
//return log;
//	
//      }	
   }



