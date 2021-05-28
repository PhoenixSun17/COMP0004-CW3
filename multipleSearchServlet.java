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

@WebServlet("/runMultipleSearch.html")
public class multipleSearchServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // call model-factory
        Model model = ModelFactory.getModel();
        List<patient> patients = model.getAllPatient();

        // get field 1 & search string 1
        String fld1 = request.getParameter("field1");
        String str1 = request.getParameter("searchStr1");
        String fld2 = request.getParameter("field2");
        String str2 = request.getParameter("searchStr2");

        // do search
        List<patient> list1 = model.singleSearch(patients, fld1, str1);
        List<patient> list2 = model.singleSearch(list1, fld2, str2);
        List<patient> result = list2;

        //store all info in request object
        request.setAttribute("model",model);
        request.setAttribute("field1", fld1);
        request.setAttribute("keywords1", str1);
        request.setAttribute("field2", fld2);
        request.setAttribute("keywords2", str2);
        request.setAttribute("resultList", result);

        // Invoke the JSP page
        ServletContext context = getServletContext();
        RequestDispatcher dispatcher = context.getRequestDispatcher("/multipleSearchResult.jsp");
        dispatcher.forward(request, response);
        model.autoSave();
    }
}