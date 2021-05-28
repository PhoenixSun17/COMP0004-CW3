<%@ page import="uk.ac.ucl.model.patient" %>
<%@ page import="uk.ac.ucl.model.Model" %>
<%@ page import="java.util.List" %>
<%--
  Created by IntelliJ IDEA.
  User: Phoen
  Date: 2021/5/24
  Time: 15:32
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <jsp:include page="/meta.jsp"/>
    <title>Age Range Search Result Page</title>
</head>
<body>
<jsp:include page="/header.jsp"/>

<div class="main">
  <h1>Age Range Search</h1>
  <%
    int min = (int)request.getAttribute("min");
    int max = (int)request.getAttribute("max");
  %>
  <p> You are searching by &lt; ageRange &gt;.</p>
  <p> Your minimum age boundary is &lt; <%=min%> &gt;, Your maximum age boundary is &lt; <%=max%> &gt;  </p>

  <h2> Search result: </h2>
  <%
    List<patient> patients = (List<patient>) request.getAttribute("resultList");
    if (patients.size() !=0)
    {
  %>
  <ul>
    <%
      Model model = (Model) request.getAttribute("model");
      for (patient pat : patients)
      {
        String href = "profiles.html?id=" + pat.getId() + "&pat=" + model.findIdsList(pat.getId());
    %>
    <li><a href="<%=href%>" title = "<%=pat.getId()%>"> <%=pat.getFirst() + " " +pat.getLast()%> </a> </li>
    <% }
    } else
    {%>
    <p>Nothing was found within given age range</p>
    <%}%>
  </ul>
</div>
<jsp:include page="/footer.jsp"/>
</body>
</html>
