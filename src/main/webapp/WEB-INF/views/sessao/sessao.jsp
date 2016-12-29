<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
    <form action='sessao' method="post">
         <div>
            <label for="horario">Horario:</label>
            <input type="text" name="horario">
         </div>
         <div>
            <label for="cinema">Cinema:</label>
            <select name="cinemaId">
            	<c:forEach var="cinema" items="${cinemas}">
            		<option value="${cinema.id}">${cinema.nome}</option>
            	</c:forEach>
            </select>
         </div>

         <button type="submit" class="button">Gravar</button>
    </form>
</body>
</html>