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
import java.util.List;

@WebServlet("/runAgeRangeSearch.html")
public class ageRangeSearchServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Model model = ModelFactory.getModel();
        List<patient> patients = model.getAllPatient();
        //get maximum and minimum age boundaries
        String minAge = request.getParameter("searchMin");
        String maxAge = request.getParameter("searchMax");
        int min = Integer.parseInt(minAge);
        int max = Integer.parseInt(maxAge);
        // get the result list
        List<patient> resultList = model.ageSearch(patients, min, max);
        //store all info in request object
        request.setAttribute("model",model);
        request.setAttribute("resultList", resultList);
        request.setAttribute("min", min);
        request.setAttribute("max", max);
        //Invoke the JSP page
        ServletContext context = getServletContext();
        RequestDispatcher dispatcher = context.getRequestDispatcher("/ageRangeSearchResult.jsp");
        dispatcher.forward(request, response);

    }
}
