<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib tagdir="/WEB-INF/tags/" prefix="ingresso"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>


<ingresso:template>
	<jsp:body>
	<table class="table table-hover ">
		<thead>
			<tr>
				<th>Nome</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach var="sessao" items="${sessoes}">
				<tr>
					<td>${sessao.horario}</td>
					<td>${sessao.cinema.nome}</td>
				</tr>
			</c:forEach>
		</tbody>
	</table>
</jsp:body>
</ingresso:template>