<%@ page import="java.util.List" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="uk.ac.ucl.model.Model" %>
<%@ page import="uk.ac.ucl.model.patient" %>
<%@ page import="uk.ac.ucl.model.ModelFactory" %>
<%@ page import="java.util.ArrayList" %>
<html>
<head>
  <jsp:include page="/meta.jsp"/>
  <title>Patient Data App</title>
</head>
<body>
<jsp:include page="/header.jsp"/>
<div class="main">
  <h1>Statistics (On ages)</h1>
  <%
    Model model = ModelFactory.getModel();
    List<patient> patients = new ArrayList<>();
    patients.add(model.getOldest(model.getAllPatient()));
    patients.add(model.getYoungest(model.getAllPatient()));
    double i = model.averageAge(model.getAllPatient());
    String href =  "profiles.html?id=" + patients.get(0).getId()+ "&pat="+model.findIdsList(patients.get(0).getId());
    String href2 =  "profiles.html?id=" + patients.get(1).getId()+ "&pat="+model.findIdsList(patients.get(1).getId());
  %>
  <li><a href="<%=href%>" title = "<%=patients.get(0).getId()%>"> <%="The Oldest Patient "+patients.get(0).getFirst() +
          " " +patients.get(0).getLast()+" "+model.getAge(patients.get(0))+" years old."%> </a> </li>
  <li><a href="<%=href2%>" title = "<%=patients.get(1).getId()%>"> <%="The Youngest Patient "+patients.get(1).getFirst() +
          " " +patients.get(1).getLast()+" "+model.getAge(patients.get(1))+" years old."%> </a> </li>
  <h2>The average age is <%=i%></h2>
  </ul>
</div>
<jsp:include page="/footer.jsp"/>
</body>
</html>