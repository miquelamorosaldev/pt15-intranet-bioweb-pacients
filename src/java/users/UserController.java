/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package users;

import users.model.UsersManager;
import java.io.IOException;
import java.util.Map;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author alumne
 */
@WebServlet(name = "UserController", urlPatterns = {"/UsersServlet"})
public class UserController extends HttpServlet {

   
    /**
     * Llama a la clase Manager de los usuarios de la app.
     */
    UsersManager usersManager;
    
    @Override
    public void init(ServletConfig config) throws ServletException{
        usersManager = new UsersManager();
        super.init(config);
    }
    
    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        if(request.getParameter("action")!=null){
            String action=request.getParameter("action");
            switch(action){
                case "Validate":
                    login(request,response);
                break;
                case "AdminPage":
                    admin(request,response);
                break;
                case "Invalidate":
                    logout(request,response);
                break;
            }  
        } else{
            response.sendRedirect("login.jsp");
        }
        
        
    }
    
    private void admin(HttpServletRequest request, HttpServletResponse response) throws IOException {
        // Agafem les dades de la sessió.
        HttpSession session=request.getSession();
        if(session.getAttribute("user")==null){
                response.sendRedirect("login.jsp");
         } else {
             if(!session.getAttribute("role").equals("ADMIN")){
                  response.sendRedirect("login.jsp");
             } else {
                response.sendRedirect("admin.jsp");
            }
        }
    }
        
    private void login(HttpServletRequest request, HttpServletResponse response) throws IOException {
        // Agafem les dades del formulari.
        String username=request.getParameter("username");
        String password=request.getParameter("password"); 
        
        // Si l'usuari amb contrassenya existeix a la nostra base de dades.
        if(usersManager.isValidUser(username,password)){
            //crear una variable de sesion
            HttpSession session=request.getSession();
            session.setAttribute("user", username);
            // I una cookie
            //setting session to expiry in 30 mins
            session.setMaxInactiveInterval(30*60);
            Cookie userName = new Cookie("user", username);
            userName.setMaxAge(30*60);
            response.addCookie(userName);
            // Indiquem a la vista si l'usuari es admin o user.
            session.setAttribute("role", usersManager.getRole(username));
            response.sendRedirect("./intranet/adn.jsp");
        } else {
            response.sendRedirect("login.jsp?error=1");
        }
    }
    
    private void logout(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.setContentType("text/html");
    	Cookie[] cookies = request.getCookies();
    	if(cookies != null){
    	for(Cookie cookie : cookies){
    		if(cookie.getName().equals("JSESSIONID")){
    			System.out.println("JSESSIONID="+cookie.getValue());
    			break;
    		}
    	}
    	}
    	//invalidate the session if exists
    	HttpSession session = request.getSession(false);
    	System.out.println("User="+session.getAttribute("user"));
    	if(session != null){
            session.removeAttribute("user");
            session.removeAttribute("role");
            session.invalidate();
    	}
        response.sendRedirect("login.jsp");
    }
             
    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

    

}
