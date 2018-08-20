<%@ page import="br.com.entra21java.bean.CategoriaBean" %>
<%@ page import="java.util.List" %>
<%@ page import="br.com.entra21java.bean.ProdutoBean" %>


<jsp:include page="../master.jsp"/>
<a href="/produtos/novo" class="btn btn-primary pull-right">Cadastro</a>
<table class="table">
    <thead>
    <tr>
        <th>Código</th>
        <th>Nome</th>
        <th>Preço</th>
        <th>Ação</th>
    </tr>
    </thead>
    <tbody>
    <% for (ProdutoBean produto: (List<ProdutoBean>)request.getAttribute("produtos")){ %>
    <tr>
        <td><%=produto.getId()%></td>
        <td><%=produto.getNome()%></td>
        <td><%=produto.getPreco()%></td>
        <td>
            <a href="/categorias/editar?id=<%=produto.getId()%>">Editar</a>
            <a href="/categorias/excluir?id=<%=produto.getId()%>">Excluír</a>
        </td>
    </tr>
    <% } %>
    </tbody>
    <tfoot>
    <tr>
        <th>Código</th>
        <th>Nome</th>
        <th>Preço</th>
        <th>Ação</th>
    </tr>
    </tfoot>
</table>

<jsp:include page="../rodape.jsp"/>