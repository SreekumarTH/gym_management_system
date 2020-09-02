<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@page import="java.util.ArrayList"%>
    <%@page import="org.sree.gym.servlets.Members"%> 
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>123 Gym</title>
</head>
<body>
<h1 style=text-align="center"> Members Details</h1>
<table border ="1" width="500" align="center"> 
         <tr bgcolor="00FF7F"> 
          <th><b>Member Name</b></th> 
          <th><b>Member Age</b></th> 
         </tr> 
        <%-- Fetching the attributes of the request object 
             which was previously set by the servlet  
              "StudentServlet.java" 
        --%>  
        <%ArrayList<Members> mem = (ArrayList<Members>)request.getAttribute("data"); 
        for(Members m:mem){%> 
        <%-- Arranging data in tabular form 
        --%> 
            <tr> 
                <td><%=m.getName()%></td> 
                <td><%=m.getAge()%></td> 
            </tr> 
            <%}%> 
        </table>  
        <hr/> 
</body>
</html>