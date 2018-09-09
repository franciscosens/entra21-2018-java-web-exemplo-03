<%@ page import="br.com.entra21java.bean.CategoriaBean" %>
<%@ page import="java.util.List" %>
<%@ page import="br.com.entra21java.bean.ProdutoBean" %>


<jsp:include page="../master.jsp"/>
<a href="/produtos/novo" class="btn btn-primary pull-right">Cadastro</a>
<table class="table">
    <thead>
    <tr>
        <th>C�digo</th>
        <th>Nome</th>
        <th>Pre�o</th>
        <th>A��o</th>
    </tr>
    </thead>
    <tbody>
    <% for (ProdutoBean produto: (List<ProdutoBean>)request.getAttribute("produtos")){ %>
    <tr>
        <td><%=produto.getId()%></td>
        <td><%=produto.getNome()%></td>
        <td>R$ <%=produto.getPreco()%></td>
        <td>
            <a href="/produtos/editar?id=<%=produto.getId()%>">Editar</a>
            <a href="/produtos/excluir?id=<%=produto.getId()%>">Excluir</a>
        </td>
    </tr>
    <% } %>
    </tbody>
    <tfoot>
    <tr>
         <th>C�digo</th>
        <th>Nome</th>
        <th>Pre�o</th>
        <th>A��o</th>
    </tr>
    </tfoot>
</table>

<jsp:include page="../rodape.jsp"/>