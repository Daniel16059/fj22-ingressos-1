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
				<th>Ações</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach var="sala" items="${salas}">
				<tr>
					<td>${sala.nome}</td>
					<td>
						<a href="/sessoes/${sala.id}" class="btn btn-primary">
							<span class="glyphicon glyphicon-blackboard" aria-hidden="true"></span>Sessões
						</a>
					</td>
				</tr>
			</c:forEach>
		</tbody>
	</table>
	<div class="col-md-6 col-md-offset-3">
		<a href="/sala" class="btn btn-block btn-info">Novo</a>
	</div>
	</jsp:body>
</ingresso:template>
