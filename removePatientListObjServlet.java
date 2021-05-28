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

@WebServlet("/runRemovePatientListObj.html")
public class removePatientListObjServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Model model = ModelFactory.getModel();
        String listname = request.getParameter("removeName");
        boolean allList = false;
        if (listname.equals(null)||listname.equals(""))
            allList = true;
        String field = request.getParameter("field");
        String searchStr = request.getParameter("searchStr");
        boolean a = model.getListNames().contains(listname);
        List<patient> patients = new ArrayList<>();
        List<patient> removal = new ArrayList<>();
        request.setAttribute("name", "no lists");
        if (allList) {
            patients = model.getAllPatient();
            removal = model.singleSearch(patients,field,searchStr);
            for (List<patient> l : model.getListOList()){
                for (patient p: removal){
                    if (l.contains(p))
                        l.remove(p);
                }
            }
            request.setAttribute("Result","SUCCESS");
            request.setAttribute("patientsList", patients);
            request.setAttribute("name", "all lists");
        }else if (!allList &&a){
            patients = model.getListOList().get(model.getListNames().indexOf(listname));
            removal = model.singleSearch(patients,field,searchStr);
            for (patient p : removal){
                model.removePatient(listname,p);
            }
            request.setAttribute("Result","SUCCESS");
            request.setAttribute("patientsList", patients);
            request.setAttribute("name", listname);
        }else
            request.setAttribute("Result","FAIL");

        request.setAttribute("field", field);
        request.setAttribute("keywords",searchStr);
        request.setAttribute("actionType","OBJT REMOVE");
        //Invoke the JSP page
        ServletContext context = getServletContext();
        RequestDispatcher dispatcher = context.getRequestDispatcher("/actionResult.jsp");
        dispatcher.forward(request, response);
        model.autoSave();
    }
}