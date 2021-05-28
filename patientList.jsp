<%@ page import="java.util.List" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
<head>
  <jsp:include page="/meta.jsp"/>
  <title>Patient Data App</title>
</head>
<body>
<jsp:include page="/header.jsp"/>
<div class="main">
  <h2>Patients Lists:</h2>
  <p id="top"> <a href="#bottom" title = "nav to bottom"> go to bottom</a> </p>
  <ul>
    <%
      List<String> patients = (List<String>) request.getAttribute("patientNames");
      int i = 0;
      int pages = (int) request.getAttribute("pages");
      i = (int) request.getAttribute("current");
      i*=25;
      i-=25;
      for (String patient : patients)
      {
        String href = "patients.html?"+"pat="+i+"&current2=1";
        i++;
    %>
    <li><a href="<%=href%>"><%=patient%></a>
    </li>
    <% } %>
  </ul>
  <p id = "bottom">  <a href="#top" title="nav to top"> go to top </a> </p>
</div>

<nav aria-label="Navigation for patient List">
  <ul class="pagination">
    <c:if test="${current != 1}">
      <li class="page-item"><a class="page-link"
                               href="/patientList.html?current=${current-1}">Previous</a>
      </li>
    </c:if>

    <c:forEach begin="1" end="${pages}" var="i">
      <c:choose>
        <c:when test="${current eq i}">
          <li class="page-item active"><a class="page-link">
              ${i} <span class="sr-only">(current)</span></a>
          </li>
        </c:when>
        <c:otherwise>
          <li class="page-item"><a class="page-link"
                                   href="/patientList.html?current=${i}">${i}</a>
          </li>
        </c:otherwise>
      </c:choose>
    </c:forEach>


    <c:if test="${current lt pages}">
      <li class="page-item"><a class="page-link"
                               href="/patientList.html?current=${current+1}">Next</a>
      </li>
    </c:if>
  </ul>
</nav>

<jsp:include page="/footer.jsp"/>
</body>
</html>
