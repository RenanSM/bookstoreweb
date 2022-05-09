/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bookstoreweb.controller;

import bookstoreweb.model.bean.User;
import bookstoreweb.model.dao.UserDAO;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author devsys-b
 */
@WebServlet(name = "UserLoginServlet", urlPatterns = {"/login"})
public class UserLoginServlet extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        
        String auxEmail = request.getParameter("email");
        String auxPassword = request.getParameter("password");
        
       UserDAO userDao = new UserDAO();
        
        try {
            User user = userDao.checkLogin(auxEmail, auxPassword);
            
            String destPage = "/loginPage.jsp";
            
            if(user != null) {
                    HttpSession session = request.getSession();
                session.setAttribute("user", user);
                destPage = "/bstore/list";
                Logger.getLogger(UserDAO.class.getName()).log(Level.INFO, "Usuario Logado: (0)", user.getEmail() + " | " + user.getFullname());
            } else {
                String msgAux = "Email ou Password Inválido!!!";
                request.setAttribute("message", msgAux);
                
                Logger.getLogger(UserDAO.class.getName()).log(Level.INFO, "Erro login: {0}", auxEmail);
            }
            
            RequestDispatcher dispatcher = request.getRequestDispatcher(destPage);
            dispatcher.forward(request, response);
            
        } catch (ServletException ex){
            Logger.getLogger(UserDAO.class.getName()).log(Level.SEVERE, "Servlet Exception na UserLoginServlet. {0}", ex);
            throw new ServletException(ex);
        }
    }


    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }


    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
