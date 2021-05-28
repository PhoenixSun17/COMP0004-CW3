<%@ page import="java.util.List" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="uk.ac.ucl.model.patient" %>
<%@ page import="java.util.ArrayList" %>
<html>
<head>
  <jsp:include page="/meta.jsp"/>
  <title>Patient Data App</title>
</head>
<body>
<jsp:include page="/header.jsp"/>
<div class="main">
  <h2>Patients:</h2>
  <ul>
    <%
    ArrayList<patient> patientss = (ArrayList<patient>) request.getAttribute("patients");
    for (patient pat : patientss)
    {
    String href = "profiles.html?id="+pat.getId()+"&pat="+request.getAttribute("pat");
    %>
    <li><a href="<%=href%>"><%=pat%></a>
    </li>
    <% } %>
  </ul>
</div>
<jsp:include page="/footer.jsp"/>
</body>
</html>