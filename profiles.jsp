<%@ page import="uk.ac.ucl.model.patient" %>
<!DOCTYPE html>
<html>
<head>
  <jsp:include page="/meta.jsp"/>
  <title>Profile:</title>
</head>
<body>
<jsp:include page="/header.jsp"/>

<jsp:useBean id="patient" scope="request" type="uk.ac.ucl.model.patient"></jsp:useBean>
<section id="profile" class="section">
  <div class="container">
    <h2 class="headline">Patient Profile of &lt; <jsp:getProperty property="first" name="patient"/> <jsp:getProperty property="last" name="patient"/> &gt; </h2>
    <table id="profiletab">
      <%patient pat = (patient) request.getAttribute("patient");%>
      <tr>
        <td>id</td>
        <td><jsp:getProperty property="id" name="patient"/> </td>
      </tr>
      <tr>
        <td>birthdate</td>
        <%if (pat.getBirthdate()!=null){%>
        <td><jsp:getProperty property="birthdate" name="patient"/></td>
        <%}%>
      </tr>
      <tr>
        <td>deathdate</td>
        <%if (pat.getDeathdate()!=null){%>
        <td><jsp:getProperty property="deathdate" name="patient"/> </td>
        <%}%>
      </tr>
      <tr>
        <td>ssn</td>
        <%if (pat.getSsn()!=null){%>
        <td><jsp:getProperty property="ssn" name="patient"/></td>
        <%}%>
      </tr>
      <tr>
        <td>drivers</td>
        <%if (pat.getDrivers()!=null){%>
        <td><jsp:getProperty property="drivers" name="patient"/> </td>
        <%}%>
      </tr>
      <tr>
        <td>passport</td>
        <%if (pat.getPassport()!=null){%>
        <td><jsp:getProperty property="passport" name="patient"/></td>
        <%}%>
      </tr>
      <tr>
        <td>prefix</td>
        <%if (pat.getPrefix()!=null){%>
        <td><jsp:getProperty property="prefix" name="patient"/> </td>
        <%}%>
      </tr>
      <tr>
        <td>first</td>
        <%if (pat.getFirst()!=null){%>
        <td><jsp:getProperty property="first" name="patient"/></td>
        <%}%>
      </tr>
      <tr>
        <td>last</td>
        <%if (pat.getLast()!=null){%>
        <td><jsp:getProperty property="last" name="patient"/> </td>
        <%}%>
      </tr>
      <tr>
        <td>suffix</td>
        <%if (pat.getSuffix()!=null){%>
        <td><jsp:getProperty property="suffix" name="patient"/></td>
        <%}%>
      </tr>
      <tr>
        <td>maiden</td>
        <%if (pat.getMaiden()!=null){%>
        <td><jsp:getProperty property="maiden" name="patient"/> </td>
        <%}%>
      </tr>
      <tr>
        <td>martial</td>
        <%if (pat.getMarital()!=null){%>
        <td><jsp:getProperty property="marital" name="patient"/></td>
        <%}%>
      </tr>
      <tr>
        <td>race</td>
        <%if (pat.getRace()!=null){%>
        <td><jsp:getProperty property="race" name="patient"/> </td>
        <%}%>
      </tr>
      <tr>
        <td>ethnicity</td>
        <%if (pat.getEthnicity()!=null){%>
        <td><jsp:getProperty property="ethnicity" name="patient"/></td>
        <%}%>
      </tr>
      <tr>
        <td>gender</td>
        <%if (pat.getGender()!=null){%>
        <td><jsp:getProperty property="gender" name="patient"/> </td>
        <%}%>
      </tr>
      <tr>
        <td>birthplace</td>
        <%if (pat.getBirthplace()!=null){%>
        <td><jsp:getProperty property="birthplace" name="patient"/></td>
        <%}%>
      </tr>
      <tr>
        <td>address</td>
        <%if (pat.getAddress()!=null){%>
        <td><jsp:getProperty property="address" name="patient"/> </td>
        <%}%>
      </tr>
      <tr>
        <td>city</td>
        <%if (pat.getCity()!=null){%>
        <td><jsp:getProperty property="city" name="patient"/></td>
        <%}%>
      </tr>
      <tr>
        <td>state</td>
        <%if (pat.getState()!=null){%>
        <td><jsp:getProperty property="state" name="patient"/> </td>
        <%}%>
      </tr>
      <tr>
        <td>zip</td>
        <%if (pat.getZip()!=null){%>
        <td><jsp:getProperty property="zip" name="patient"/></td>
        <%}%>
      </tr>
    </table>
  </div>
</section>

<jsp:include page="/footer.jsp"/>

</body>
</html>