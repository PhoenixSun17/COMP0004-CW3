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

@WebServlet("/runRemovePatientList.html")
public class removePatientListServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Model model = ModelFactory.getModel();
        List<String> names = model.getListNames();
        String listname = request.getParameter("removeName");
        if (model.getListNames().contains(listname)) {
            model.removeList(listname);
            request.setAttribute("Result","SUCCESS");
        }else
            request.setAttribute("Result","FAIL");
        //store all info in request object
        request.setAttribute("model",model);
        request.setAttribute("name", listname);
        request.setAttribute("actionType","LIST REMOVE");
        //Invoke the JSP page
        ServletContext context = getServletContext();
        RequestDispatcher dispatcher = context.getRequestDispatcher("/actionResult.jsp");
        dispatcher.forward(request, response);
        model.autoSave();
    }
}
