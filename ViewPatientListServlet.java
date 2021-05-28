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
@WebServlet("/patientList.html")
public class ViewPatientListServlet extends HttpServlet
{
  private int listPerPage = 25;

  public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException
  {
    // Get the data from the model
    int current = Integer.parseInt(request.getParameter("current"));
    List<String> patientNames = getCurrentPage(current);
    // Then add the data to the request object that will be sent to the Java Server Page, so that
    // the JSP can access the data (a Java data structure).
    request.setAttribute("patientNames", patientNames);
    int rows = getRows();
    int pages = rows/listPerPage;
    if(pages%listPerPage>0){
      pages++;
    }
    if (current == pages){
      current = pages-1;
    }
    if (current == 0){
      current = 1;
    }
    request.setAttribute("pages",pages);
    request.setAttribute("current",current);
    // Invoke the JSP.
    // A JSP page is actually converted into a Java class, so behind the scenes everything is Java.
    ServletContext context = getServletContext();
    RequestDispatcher dispatch = context.getRequestDispatcher("/patientList.jsp");
    dispatch.forward(request, response);
  }

  private List<String> getCurrentPage(int current) throws IOException {
    List<String> cur = new ArrayList<>();
    int start = current*listPerPage - listPerPage;
    if (start<0)
      start = 0;
    Model model = ModelFactory.getModel();
    List<String> names = model.getListNames();
    int end = 0;
    if (start+25<names.size()){
      end = start+25;
    }else
      end = names.size();

    for (int i = start; i<end; i++){
      cur.add(names.get(i));
    }
    model.autoSave();
    return cur;
  }

  private int getRows() throws IOException {
    int num = 0;
    Model model = ModelFactory.getModel();
    List<String> names = model.getListNames();
    num = names.size();

    return num;
  }

}
