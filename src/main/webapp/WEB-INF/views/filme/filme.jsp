<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib tagdir="/WEB-INF/tags/" prefix="ingresso"%>

<ingresso:template>
	<jsp:body>
    <form action='filme' method="post">
         <div class="form-group">
            <label for="nome">Nome:</label>
            <input type="text" name="nome" class="form-control">
         </div>

         <div  class="form-group">
            <label for="genero">Genero:</label>
            <input type="text" name="genero" class="form-control">
         </div>

         <div class="form-group">
            <label for="duracao">Duracao:</label>
            <input type="text" name="duracao" class="form-control">
         </div>

         <button type="submit" class="btn btn-primary">Gravar</button>
    </form>
	</jsp:body>
</ingresso:template>