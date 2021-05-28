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
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

// The servlet invoked to display a list of patients.
// The url http://localhost:8080/patientList.html is mapped to calling doGet on the servlet object.
// The servlet object is created automatically, you just provide the class.
@WebServlet("/patients.html")
public class ViewPatientsServlet extends HttpServlet
{
    private int listPerPage = 25;

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException
    {
        // Get the data from the model
        int current2 = Integer.parseInt(request.getParameter("current2"));
        int pat = Integer.parseInt(request.getParameter("pat"));
        Model model = ModelFactory.getModel();
        ArrayList<patient> patients = model.getListOList().get(pat);
        request.setAttribute("pat", pat);
        // Then add the data to the request object that will be sent to the Java Server Page, so that
        // the JSP can access the data (a Java data structure).
        request.setAttribute("patients", patients);
        // Invoke the JSP.
        // A JSP page is actually converted into a Java class, so behind the scenes everything is Java.
        ServletContext context = getServletContext();
        RequestDispatcher dispatch = context.getRequestDispatcher("/patients.jsp");
        dispatch.forward(request, response);
        model.autoSave();
    }


}
