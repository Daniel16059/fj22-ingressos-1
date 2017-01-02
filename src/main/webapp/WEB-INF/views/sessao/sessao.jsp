<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib tagdir="/WEB-INF/tags/" prefix="ingresso"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>


<ingresso:template>
	<jsp:body>
    <form action='sessao' method="post">
         <div class="form-group">
            <label for="horario">Horario:</label>
            <input type="text" name="horario" class="form-control">
         </div>
         <div class="form-group">
            <label for="cinema">Cinema:</label>
            <select name="cinemaId" class="form-control">
            	<c:forEach var="cinema" items="${cinemas}">
            		<option value="${cinema.id}">${cinema.nome}</option>
            	</c:forEach>
            </select>
         </div>
         
           <div class="form-group">
            <label for="filme">Filme:</label>
            <select name="filmeId" class="form-control">
            	<c:forEach var="filme" items="${filmes}">
            		<option value="${filme.id}">${filme.nome}</option>
            	</c:forEach>
            </select>
         </div>

         <button type="submit" class="btn btn-primary">Gravar</button>
    </form>
</jsp:body>
</ingresso:template>