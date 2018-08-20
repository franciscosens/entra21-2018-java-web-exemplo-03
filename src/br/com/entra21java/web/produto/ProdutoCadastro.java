package br.com.entra21java.web.produto;

import br.com.entra21java.bean.CategoriaBean;
import br.com.entra21java.dao.CategoriaDAO;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/produtos/novo")
public class ProdutoCadastro extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        List<CategoriaBean> categorias = new CategoriaDAO().obterTodos();
        req.setAttribute("categorias", categorias);

        req.getRequestDispatcher("/produto/cadastro.jsp").include(req, resp);
    }
}
