/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bookstoreweb.controller;

import bookstoreweb.model.bean.User;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

/**
 *
 * @author devsys-b
 */
   @WebFilter(filterName = "AutorizaUserFilter", urlPatterns = {"/bstore/*"})
public class AutorizaUserFilter implements Filter{

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        
        Logger.getLogger(AutorizaUserFilter.class.getName()).log(Level.INFO, "AutorizaUserFilter Iniciado :D!");
        
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        
        HttpServletRequest httpRequest = (HttpServletRequest) request;
        
        //Carrega a Session
        HttpSession session = httpRequest.getSession(false);
        boolean isUsuarioLogado = (session != null && session.getAttribute("user") != null);
        
        if (isUsuarioLogado) {
            //Se tudo tiver ok o usuário segue a requisição com a autorização do session
            User userLogado = (User) session.getAttribute("user");
            
            Logger.getLogger(AutorizaUserFilter.class.getName()).log(Level.INFO, "Usuario autenticado: {0}", userLogado.getEmail());
            
            Logger.getLogger(AutorizaUserFilter.class.getName()).log(Level.INFO, "Carrega proximo filtro ou servlet - chain.doFilter()");
            chain.doFilter(request, response);
        }else {
            //puts....usuario não tá autenticado :/. Pra página de Login
            Logger.getLogger(AutorizaUserFilter.class.getName()).log(Level.INFO, "Usuario nao autenticado: ");
            
            RequestDispatcher dispatcher = request.getRequestDispatcher("/loginPage.jsp");
            dispatcher.forward(request, response);
            
        }
        
        Logger.getLogger(AutorizaUserFilter.class.getName()).log(Level.INFO, "*** Pos-Filtro ***");
        
                    
    }

    @Override
    public void destroy() {
        Logger.getLogger(AutorizaUserFilter.class.getName()).log(Level.INFO, "AutorizaUserFilter destruido >:O!");
        
    }
    
    
}
