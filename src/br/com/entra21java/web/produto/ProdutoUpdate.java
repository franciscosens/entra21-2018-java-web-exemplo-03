package br.com.entra21java.web.produto;

import br.com.entra21java.bean.ProdutoBean;
import br.com.entra21java.dao.CategoriaDAO;
import br.com.entra21java.dao.ProdutoDAO;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/produtos/update")
public class ProdutoUpdate extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("utf-8");

        ProdutoBean produto = new ProdutoBean();
        produto.setId(Integer.parseInt(req.getParameter("id")));
        produto.setNome(req.getParameter("nome"));
        produto.setPreco(Double.parseDouble(req.getParameter("preco")));
        produto.setIdCategoria(Integer.parseInt(req.getParameter("categoria")));

        new ProdutoDAO().alterar(produto);
        resp.sendRedirect("/produtos/editar?id=" + produto.getId());
    }

}
