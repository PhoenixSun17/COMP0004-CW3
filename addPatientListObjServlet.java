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

@WebServlet("/runAddPatientListObj.html")
public class addPatientListObjServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Model model = ModelFactory.getModel();
        String listname = request.getParameter("removeName");
        String para1 = request.getParameter("ID");
        String para2 = request.getParameter("BIRTHDATE");
        String para3 = request.getParameter("DEATHDATE");
        String para4 = request.getParameter("SSN");
        String para5 = request.getParameter("DRIVERS");
        String para6 = request.getParameter("PASSPORT");
        String para7 = request.getParameter("PREFIX");
        String para8 = request.getParameter("FIRST");
        String para9 = request.getParameter("LAST");
        String para10= request.getParameter("SUFFIX");
        String para11= request.getParameter("MAIDEN");
        String para12= request.getParameter("MARITAL");
        String para13= request.getParameter("RACE");
        String para14= request.getParameter("ETHNICITY");
        String para15= request.getParameter("GENDER");
        String para16= request.getParameter("BIRTHPLACE");
        String para17= request.getParameter("ADDRESS");
        String para18= request.getParameter("CITY");
        String para19= request.getParameter("STATE");
        String para20 = request.getParameter("ZIP");
        String[] infoset = {para1,para2,para3,para4,para5,para6,para7,para8,para9,para10,para11,para12,para13,para14,para15,para16,para17,para18,para19,para20};
        for (String a:infoset) {
            if (a == null){
                a = "";
            }
        }
        boolean allList = false;
        if (listname.equals(null)||listname.equals(""))
            allList = true;
        boolean a = model.getListNames().contains(listname);
        request.setAttribute("name", "no lists");
        if (allList &&(para8!=""&&para9!="")) {
            listname = "allList";
            model.addPatient(listname,infoset);
            request.setAttribute("Result","SUCCESS");
            request.setAttribute("name", "all lists");
        }else if (!allList &&a){
            model.addPatient(listname,infoset);
            request.setAttribute("Result","SUCCESS");
            request.setAttribute("name", listname);
        }else
            request.setAttribute("Result","FAIL");
        request.setAttribute("actionType","OBJT ADD");
        request.setAttribute("keywords", para8+" "+para9);
        //Invoke the JSP page
        ServletContext context = getServletContext();
        RequestDispatcher dispatcher = context.getRequestDispatcher("/actionResult.jsp");
        dispatcher.forward(request, response);
    }
}