<%@ page import="br.com.entra21java.bean.CategoriaBean" %>
<%@ page import="java.util.List" %>


<jsp:include page="../master.jsp"/>
<a href="/categorias/novo" class="btn btn-primary pull-right">Cadastro</a>
<table class="table">
    <thead>
    <tr>
        <th>Código</th>
        <th>Nome</th>
        <th>Ação</th>
    </tr>
    </thead>
    <tbody>
    <% for (CategoriaBean categoria: (List<CategoriaBean>)request.getAttribute("categorias")){ %>
        <tr>
            <td><%=categoria.getId()%></td>
            <td><%=categoria.getNome()%></td>
            <td>
                <a href="/categorias/editar?id=<%=categoria.getId()%>">Editar</a>
            </td>
        </tr>
    <% } %>
    </tbody>
    <tfoot>
    <tr>
        <th>Código</th>
        <th>Nome</th>
        <th>Ação</th>
    </tr>
    </tfoot>
</table>

<jsp:include page="../rodape.jsp"/>