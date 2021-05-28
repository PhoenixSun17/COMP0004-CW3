<%@ page import="uk.ac.ucl.model.patient" %>
<%@ page import="uk.ac.ucl.model.Model" %>
<%@ page import="java.util.List" %>
<%--
  Created by IntelliJ IDEA.
  User: Phoenix
  Date: 2021/5/24
  Time: 14:46
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Multiple Search Result Page</title>
</head>
<body>
<jsp:include page="/header.jsp"/>

<div class="main">
  <h1>Multiple Search</h1>
  <%
    Model model = (Model) request.getAttribute("model");
    String field1 = (String)request.getAttribute("field1");
    String keywords1 = (String)request.getAttribute("keywords1");
    String field2 = (String)request.getAttribute("field2");
    String keywords2 = (String)request.getAttribute("keywords2");
  %>
  <p> You search by &lt; <%=field1%> & <%=field2%> &gt;.</p>
  <p>Your search keywords are &lt; <%=keywords1%> & <%=keywords2%> &gt; </p>

  <h2> Search result: </h2>
  <%
    List<patient> patients = (List<patient>) request.getAttribute("resultList");
    if (patients.size() !=0)
    {
  %>
  <ul>
    <%
      for (patient pat : patients)
      {
        String href = "profiles.html?id=" + pat.getId()+"&pat="+model.findIdsList(pat.getId());
    %>
    <li><a href="<%=href%>" title = "<%=pat.getId()%>"> <%=pat.getFirst() + " " +pat.getLast()%> </a> </li>
    <% }
    } else
    {%>
    <p>Nothing was found based on search keywords</p>
    <%}%>
  </ul>
</div>
<jsp:include page="/footer.jsp"/>
</body>
</html>
