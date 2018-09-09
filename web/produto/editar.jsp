<%@page import="br.com.entra21java.bean.ProdutoBean"%>
<%@ page import="br.com.entra21java.bean.CategoriaBean" %>
<%@ page import="java.util.List" %>
<%@include file="../master.jsp" %>

<% ProdutoBean produto = (ProdutoBean) request.getAttribute("produto"); %>

<form action="/produtos/update" method="POST">
    <input type="hidden" name="id" value="<%=  produto.getId() %>">
    <div class="form-group">
        <label for="campo-categoria">Categoria</label>
        <select class="form-control" name="categoria" id="campo-categoria">
            <option selected="selected" disabled="disabled"></option>
            <% for (CategoriaBean categoria : (List<CategoriaBean>) request.getAttribute("categorias")) { %>

                <% if (categoria.getId() == produto.getIdCategoria()) {%>
                    <option value="<%= categoria.getId() %>" selected="selected"><%=categoria.getNome()%></option>
                <% } else {%>
                    <option value="<%= categoria.getId() %>"><%=categoria.getNome()%></option>
                <% } %>
            <% }%>
        </select>
    </div>
    <div class="form-group">
        <label for="campo-nome">Nome</label>
        <input type="text" class="form-control" name="nome" id="campo-nome" value="<%= produto.getNome() %>">
    </div>
    <div class="form-group">
        <label for="campo-preco">Preço</label>
        <input type="text" class="form-control" name="preco" id="campo-preco" value="<%= produto.getPreco() %>">
    </div>
    <div>
        <input type="submit" class="btn btn-primary" value="Alterar">
    </div>
</form>

<jsp:include page="../rodape.jsp"/>