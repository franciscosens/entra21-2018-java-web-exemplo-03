<%@include file="../master.jsp"%>
<form action="/categorias/store" method="POST">
    <div class="form-group">
        <label for="campo-nome">Nome</label>
        <input type="text" class="form-control"  name="nome" id="campo-nome">
    </div>
    <div>
        <input type="submit" class="btn btn-primary" value="Cadastrar">
    </div>
</form>

<jsp:include page="../rodape.jsp"/>