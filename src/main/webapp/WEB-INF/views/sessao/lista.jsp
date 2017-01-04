<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ taglib tagdir="/WEB-INF/tags/" prefix="ingresso" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<ingresso:template>
    <jsp:body>
        <table class="table table-hover ">
            <thead>
            <tr>
                <th>Nome</th>
                <th>Cinema</th>
                <th>Filme</th>
                <th>Duração</th>
            </tr>
            </thead>
            <tbody>
            <c:forEach var="sessao" items="${sessoes}">
                <tr>
                    <td>${sessao.horario}</td>
                    <td>${sessao.cinema.nome}</td>
                    <td>${sessao.filme.nome}</td>
                    <td>${sessao.filme.duracao.toMinutes()}</td>
                </tr>
            </c:forEach>
            </tbody>
        </table>
        <div class="col-md-6 col-md-offset-3">
            <a href="/sessao" class="btn btn-block btn-info">Nova</a>
        </div>
    </jsp:body>
</ingresso:template>