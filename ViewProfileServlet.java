package uk.ac.ucl.servlets;

import uk.ac.ucl.model.Model;
import uk.ac.ucl.model.ModelFactory;
import uk.ac.ucl.model.patient;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/profiles.html")
public class ViewProfileServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //call model-factory
        Model model = ModelFactory.getModel();

        //get the patient id from the session
        int pat = Integer.parseInt(request.getParameter("pat"));
        String id = request.getParameter("id");
        System.out.println("The current id is: " + id);
        patient patient = model.getPatientDetail(id,pat);
        //System.out.println(patient.getId());

        //store all info in request object
        request.setAttribute("patient", patient);

        //forward control to profile jsp
        RequestDispatcher dispatcher = request.getRequestDispatcher("/profiles.jsp");
        dispatcher.forward(request, response);
        model.autoSave();
    }
}