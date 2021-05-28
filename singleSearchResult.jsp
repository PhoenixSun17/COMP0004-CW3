<%@ page import="uk.ac.ucl.model.patient" %>
<%@ page import="uk.ac.ucl.model.Model" %>
<%@ page import="java.util.List" %>
<%--
  Created by IntelliJ IDEA.
  User: Phoenix
  Date: 2021/5/24
  Time: 13:10
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <jsp:include page="/meta.jsp"/>
    <title>Patient Data Management System</title>
</head>
<body>
<jsp:include page="/header.jsp"/>
<div class="main">
  <h1>Single Search</h1>
  <%
    String field = (String)request.getAttribute("field");
    String keywords = (String)request.getAttribute("keywords");
  %>
  <p> You search by &lt; <%=field%> &gt;, Your search keywords are &lt; <%=keywords%> &gt; </p>
  <h2> Search result: </h2>
  <%
    List<patient> patients = (List<patient>) request.getAttribute("resultList");
    if (patients.size() !=0)
    {
  %>
  <ul>
    <%
      Model mod = (Model) request.getAttribute("model");
      for (patient pat : patients)
      {
        String href = "profiles.html?id=" + pat.getId()+ "&pat="+mod.findIdsList(pat.getId());
    %>
    <li><a href="<%=href%>" title = "<%=pat.getId()%>"> <%=pat.getFirst() + " " +pat.getLast()%> </a> </li>
    <% }
    } else
    {%>
    <p>Nothing found</p>
    <%}%>
  </ul>
</div>
<jsp:include page="/footer.jsp"/>
</body>
</html>
