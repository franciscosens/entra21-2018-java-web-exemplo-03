<%@page import="br.com.entra21java.bean.CategoriaBean"%>
<%@include file="../master.jsp"%>

<% CategoriaBean categoria = (CategoriaBean) request.getAttribute("categoria");%>

<form action="/categorias/update" method="POST">
    <input type="hidden" class="form-control"  name="id" id="campo-id" value="<%= categoria.getId()%>">
    <div class="form-group">
        <label for="campo-nome">Nome</label>
        <input type="text" class="form-control"  name="nome" id="campo-nome" value="<%= categoria.getNome()%>">
    </div>
    <div>
        <input type="submit" class="btn btn-primary" value="Cadastrar">
    </div>
</form>


<jsp:include page="../rodape.jsp"/>