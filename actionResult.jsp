<%@ page import="uk.ac.ucl.model.Model" %>
<%@ page import="uk.ac.ucl.model.ModelFactory" %><%--
  Created by IntelliJ IDEA.
  User: Phoen
  Date: 2021/5/24
  Time: 16:20
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <jsp:include page="/meta.jsp"/>
    <title>Action Result</title>
</head>
<body>
<jsp:include page="/header.jsp"/>

<div class="main">
    <h1>Action Result</h1>
    <%
        String result = (String) request.getAttribute("Result");
        String type = (String) request.getAttribute("actionType");
        String name = (String) request.getAttribute("name");
        String newName = (String) request.getAttribute("newName");
        String field = (String) request.getAttribute("field");
        String keyword = (String) request.getAttribute("keywords");
        String ID = (String) request.getAttribute("ID");
        Model model = ModelFactory.getModel();
        if (result==null&&type==null){
            result = "Approved";
            type = "View Autosave file";
        }
    %>
    <p> You have Chosen to <%=type%>.</p>
    <p> The result is: <%=result%>  </p>
    <%
        String decider;
        if (type.contains("LIST")) {
            decider = "list ";
        }
        else {
            decider = "patient ";
        }
        String res = "";
        boolean a = (!type.equals("LIST RENAME") ||!type.equals("OBJT REMOVE") ||!type.equals("OBJT ADD") ||!type.equals("OBJT EDIT"));
        if (result.equals("SUCCESS")&&a)
            res ="The "+decider+name+" was successfully "+type.substring(5)+" from the system.";
        if (result.equals("SUCCESS")&& type.equals("LIST RENAME"))
            res ="The "+decider+name+" was successfully "+type.substring(5)+" to "+ newName+".";
        if (result.equals("SUCCESS")&& type.equals("OBJT REMOVE"))
            res ="The "+decider+"with keyword  "+keyword+"  in "+field+" was successfully "+type.substring(5)+" from "+name+".";
        if (result.equals("SUCCESS")&& type.equals("OBJT ADD"))
            res ="The "+decider+"with name  "+keyword+" was successfully "+type.substring(5)+" to "+name+".";
        if (result.equals("SUCCESS")&& type.equals("OBJT EDIT"))
            res ="The "+decider+"with ID  "+ID+" in list "+name+" successfully got its "+field+" "+type.substring(5)+" to "+keyword+".";
        if (result.equals("FAIL") && type.equals("LIST REMOVE"))
            res = "The "+decider+name+" was not able to "+type.substring(5)+" from the system.\r\n" +
                    "This might be resulted from wrong names or repeated actions.";
        if (result.equals("FAIL") && type.equals("LIST LOAD"))
            res = "The "+decider+name+" was not able to "+type.substring(5)+" to the system.\r\n" +
                    "This might be resulted from wrong paths or the file itself does not exist.";
        if (result.equals("FAIL") && type.equals("LIST RENAME"))
            res = "The "+decider+name+" was not able to "+type.substring(5)+" to " + newName+"."+
                    "This might be resulted from wrong name of list.";
        if (result.equals("FAIL") && type.equals("LIST VIEW"))
            res = "The "+decider+name+" was not able to be "+type.substring(5)+". "+
                    "This might be resulted from wrong name of list.";
        if (result.equals("FAIL") && type.equals("OBJT REMOVE"))
            res = "The "+decider+"with keyword "+keyword+" was not able to be "+type.substring(5)+" from list "+name+". "+
                    "This might be resulted from wrong name of list.";
        if (result.equals("FAIL") && type.equals("OBJT ADD"))
            res = "The "+decider+"with name "+keyword+" was not able to be "+type.substring(5)+" to "+name+". "+
                    "This might be resulted from wrong name of list.";
        if (result.equals("FAIL") && type.equals("OBJT EDIT"))
            res = "The "+decider+"with name "+keyword+" was not able to "+type.substring(5)+" "+field+" to "+name+". "+
                    "This might be resulted from wrong name of list, or wrong ID";
        if (result.equals("Approved"))
            res = "The Auto Save file can be viewed at: "+model.getPath();
    %>
    <h2> <%=res%> </h2>

</div>
<jsp:include page="/footer.jsp"/>
</body>
</html>
