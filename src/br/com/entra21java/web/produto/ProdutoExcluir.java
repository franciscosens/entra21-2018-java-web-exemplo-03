package br.com.entra21java.web.produto;

import br.com.entra21java.bean.CategoriaBean;
import br.com.entra21java.bean.ProdutoBean;
import br.com.entra21java.dao.CategoriaDAO;
import br.com.entra21java.dao.ProdutoDAO;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/produtos/excluir")
public class ProdutoExcluir extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html; charset=UTF-8");

        int id = Integer.parseInt(req.getParameter("id"));
        new ProdutoDAO().excluido(id);

        resp.sendRedirect("/produtos");
    }
}
