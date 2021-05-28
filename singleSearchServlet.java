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

@WebServlet("/runSingleSearch.html")
public class singleSearchServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //call model-factory
        Model model = ModelFactory.getModel();
        List<patient> patients = model.getAllPatient();

        //get field & search String from the session
        String field = request.getParameter("field");
        String searchStr = request.getParameter("searchStr");
        System.out.println("You search by: " + field);
        System.out.println("You search for: " + searchStr);
        List<patient> resultList = model.singleSearch(patients, field, searchStr);

        //store all info in request object
        request.setAttribute("model",model);
        request.setAttribute("resultList", resultList);
        request.setAttribute("field", field);
        request.setAttribute("keywords",searchStr);

        // Invoke the JSP page
        ServletContext context = getServletContext();
        RequestDispatcher dispatcher = context.getRequestDispatcher("/singleSearchResult.jsp");
        dispatcher.forward(request, response);
        model.autoSave();
    }
}