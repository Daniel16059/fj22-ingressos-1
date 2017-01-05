<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ taglib tagdir="/WEB-INF/tags/" prefix="ingresso" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<ingresso:template>
    <jsp:body>

        <form action='/sala' method="post">
            <div class="form-group">
                <label for="nome">Nome:</label>
                <input id="nome" type="text" name="nome" class="form-control">

                <c:if test="${result.hasFieldErrors('nome')}">
                    <span class="text-danger">
                            ${result.getFieldError("nome").defaultMessage}
                    </span>
                </c:if>

            </div>

            <button type="submit" class="btn btn-primary">Gravar</button>
        </form>
    </jsp:body>
</ingresso:template>