
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
   <%@ page isELIgnored="false" %>
   <%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
   
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>

<body>
<c:choose>
   
    <c:when test="${action == 'All'}">
        <h1>Student Lists</h1>
         <table>
         <tr>
          <th>Name</th>
          <th>Id</th>
          <th>Course</th>
          
         </tr>
        <c:forEach var="stud" items="${sts}">
           <tr>
          <td>${stud.name}</td>
          <td>${stud.id}</td>
          <td>${stud.course}</td>
         
         </tr>
                 
            
        </c:forEach>
        </table>
    </c:when>
    <c:otherwise>
        <h1>Name: ${stu.name}</h1>
        <h1>Id: ${stu.id}</h1>
        <h1>Course: ${stu.course}</h1>
        
    </c:otherwise>
</c:choose>
</body>
</html>
