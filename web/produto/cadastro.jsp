<%@ page import="br.com.entra21java.bean.CategoriaBean" %>
<%@ page import="java.util.List" %>
<%@include file="../master.jsp" %>

<form action="/produtos/store" method="POST">
    <div class="form-group">
        <label for="campo-categoria">Categoria</label>
        <select class="form-control" name="categoria" id="campo-categoria">
            <option selected="selected" disabled="disabled"></option>
            <% for (CategoriaBean categoria: (List<CategoriaBean>)request.getAttribute("categorias")){ %>
            <option value=<%=categoria.getId()%>><%=categoria.getNome()%></option>
            <% } %>
        </select>
    </div>
    <div class="form-group">
        <label for="campo-nome">Nome</label>
        <input type="text" class="form-control" name="nome" id="campo-nome">
    </div>
    <div class="form-group">
        <label for="campo-preco">Preço</label>
        <input type="text" class="form-control" name="preco" id="campo-preco">
    </div>
    <div>
        <input type="submit" class="btn btn-primary" value="Cadastrar">
    </div>
</form>

<jsp:include page="../rodape.jsp"/>