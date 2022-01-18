/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package users;

import com.google.gson.Gson;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import patients.Patient;
import patients.PatientsMemoryDAO;

/**
 *
 * @author alumne
 */
@WebServlet(name = "PatientWS", urlPatterns = {"/PatientWS"})
public class PatientWS extends HttpServlet {

    private PatientsMemoryDAO patientDAO;

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        Gson gson = new Gson();
        // calcula la ruta absoluta para llegar a WEB-INF, si tenemos un fichero.
        // Cuando hacemos Clean & Build, se genera otra estructura de directorios: LoginApplication/build/web/WEB-INF/
        // path = getServletContext().getRealPath("/WEB-INF");
        patientDAO = new PatientsMemoryDAO();
        List<Patient> patients = new ArrayList<>();
        String action=request.getParameter("action");
        switch(action){
            case "ListAll":
                // Llegim els pacients de la base de dades
                patients = patientDAO.listAllPatients();
                break;
            case "ListWomen": 
                // Llegim els pacients de la base de dades
                patients = patientDAO.listWomanPatients();
                break; 
        }  
        // Posem la llista de pacients en un fitxer JSON.
        String patientsJsonString = gson.toJson(patients);
        // Responem incloent la llista de pacients en format JSON
        PrintWriter out = response.getWriter();
        response.setContentType("application/json");
        response.setCharacterEncoding("UTF-8");
        out.print(patientsJsonString);
        out.flush();
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
