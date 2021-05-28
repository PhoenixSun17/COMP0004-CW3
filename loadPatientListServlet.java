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
import java.util.List;

@WebServlet("/runLoadPatientList.html")
public class loadPatientListServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Model model = ModelFactory.getModel();
        String listname = "NULL";
        String path = request.getParameter("PATH");
        boolean a = false;
        a = model.readFile(new File(path),"add");
        if (a) {
            request.setAttribute("Result","SUCCESS");
            File file = new File(path);
            listname = file.getName();
        }else
            request.setAttribute("Result","FAIL");
        //store all info in request object
        request.setAttribute("model",model);
        request.setAttribute("name", listname);
        request.setAttribute("actionType","LIST LOAD");
        //Invoke the JSP page
        ServletContext context = getServletContext();
        RequestDispatcher dispatcher = context.getRequestDispatcher("/actionResult.jsp");
        dispatcher.forward(request, response);
        model.autoSave();
    }
}