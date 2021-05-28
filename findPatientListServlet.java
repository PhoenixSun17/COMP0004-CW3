package uk.ac.ucl.servlets;
import uk.ac.ucl.model.Model;
import uk.ac.ucl.model.ModelFactory;
import uk.ac.ucl.model.patient;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet("/runViewPatientList.html")
public class findPatientListServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Model model = ModelFactory.getModel();
        String listname = request.getParameter("Name");
        boolean a = model.getListNames().contains(listname);
        int pat = 0;
        if (a) {
            pat = model.getListNames().indexOf(listname);
            request.setAttribute("Result","SUCCESS");
            ArrayList<patient> patients = model.getListOList().get(pat);
            request.setAttribute("pat", pat);
            // Then add the data to the request object that will be sent to the Java Server Page, so that
            // the JSP can access the data (a Java data structure).
            request.setAttribute("patients", patients);
        }else
            request.setAttribute("Result","FAIL");
        //store all info in request object

        request.setAttribute("model",model);
        request.setAttribute("name", listname);
        request.setAttribute("actionType","LIST VIEW");
        //Invoke the JSP page
        ServletContext context = getServletContext();
        RequestDispatcher dispatcher;
        if (a)
            dispatcher = context.getRequestDispatcher("/patients.jsp");
        else
            dispatcher = context.getRequestDispatcher("/actionResult.jsp");
        dispatcher.forward(request, response);
        model.autoSave();
    }
}