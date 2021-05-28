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

@WebServlet("/runEditPatientListObj.html")
public class editPatientListObjServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Model model = ModelFactory.getModel();
        String listname = request.getParameter("removeName");
        String ID = request.getParameter("ID");
        boolean allList = false;
        if (listname.equals(null)||listname.equals(""))
            allList = true;
        String field = request.getParameter("field");
        String searchStr = request.getParameter("searchStr");
        boolean a = model.getListNames().contains(listname);
        List<patient> patients = new ArrayList<>();
        patient edit;
        request.setAttribute("name", "no lists");
        if (allList) {
            int j = 0;
            for (int i = 0; i<model.getListNames().size();i++) {
                edit = model.searchById(ID, i);
                if (edit != null) {
                    switch (field) {
                        case "id":
                            edit.setId(searchStr);
                            break;
                        case "birthdaate":
                            edit.setBirthdate(searchStr);
                            break;
                        case "deathdate":
                            edit.setDeathdate(searchStr);
                            break;
                        case "ssn":
                            edit.setSsn(searchStr);
                            break;
                        case "driver":
                            edit.setDrivers(searchStr);
                            break;
                        case "passport":
                            edit.setPassport(searchStr);
                            break;
                        case "first":
                            edit.setFirst(searchStr);
                            break;
                        case "last":
                            edit.setLast(searchStr);
                            break;
                        case "marital":
                            edit.setMarital(searchStr);
                            break;
                        case "race":
                            edit.setRace(searchStr);
                            break;
                        case "ethnicity":
                            edit.setEthnicity(searchStr);
                            break;
                        case "gender":
                            edit.setGender(searchStr);
                            break;
                        case "birthplace":
                            edit.setBirthplace(searchStr);
                            break;
                        case "address":
                            edit.setAddress(searchStr);
                            break;
                        case "city":
                            edit.setCity(searchStr);
                            break;
                        case "state":
                            edit.setState(searchStr);
                            break;
                        case "zip":
                            edit.setZip(searchStr);
                            break;
                        default:
                            System.out.println("No changes conducted.");
                    }
                }else
                    j++;
            }
            if (j<model.getListOList().size()) {
                request.setAttribute("Result", "SUCCESS");
                request.setAttribute("patientsList", patients);
                request.setAttribute("name", "all lists");
            }else
                request.setAttribute("Result","FAIL");
        }else if (!allList &&a){
            int i = model.getListNames().indexOf(listname);
            edit = model.searchById(ID,i);;
            if (edit!=null) {
                switch (field) {
                    case "id":
                        edit.setId(searchStr);
                        break;
                    case "birthdate":
                        edit.setBirthdate(searchStr);
                        break;
                    case "deathdate":
                        edit.setDeathdate(searchStr);
                        break;
                    case "ssn":
                        edit.setSsn(searchStr);
                        break;
                    case "driver":
                        edit.setDrivers(searchStr);
                        break;
                    case "passport":
                        edit.setPassport(searchStr);
                        break;
                    case "first":
                        edit.setFirst(searchStr);
                        break;
                    case "last":
                        edit.setLast(searchStr);
                        break;
                    case "marital":
                        edit.setMarital(searchStr);
                        break;
                    case "race":
                        edit.setRace(searchStr);
                        break;
                    case "ethnicity":
                        edit.setEthnicity(searchStr);
                        break;
                    case "gender":
                        edit.setGender(searchStr);
                        break;
                    case "birthplace":
                        edit.setBirthplace(searchStr);
                        break;
                    case "address":
                        edit.setAddress(searchStr);
                        break;
                    case "city":
                        edit.setCity(searchStr);
                        break;
                    case "state":
                        edit.setState(searchStr);
                        break;
                    case "zip":
                        edit.setZip(searchStr);
                        break;
                    case "prefix":
                        edit.setPrefix(searchStr);
                        break;
                    case "suffix":
                        edit.setSuffix(searchStr);
                        break;
                    case "maiden":
                        edit.setMaiden(searchStr);
                        break;

                    default:
                        System.out.println("No changes conducted.");
                }
                request.setAttribute("Result", "SUCCESS");
                request.setAttribute("patientsList", patients);
                request.setAttribute("name", listname);
            }else
                request.setAttribute("Result","FAIL");
        }else
            request.setAttribute("Result","FAIL");
        request.setAttribute("ID", ID);
        request.setAttribute("field", field);
        request.setAttribute("keywords",searchStr);
        request.setAttribute("actionType","OBJT EDIT");
        //Invoke the JSP page
        ServletContext context = getServletContext();
        RequestDispatcher dispatcher = context.getRequestDispatcher("/actionResult.jsp");
        dispatcher.forward(request, response);
    }
}