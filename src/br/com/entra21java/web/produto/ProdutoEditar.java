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

@WebServlet("/produtos/editar")
public class ProdutoEditar extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html; charset=UTF-8");
        
        ProdutoBean produto = new ProdutoDAO().obterPorId(Integer.parseInt(req.getParameter("id")));
        req.setAttribute("produto", produto);

        List<CategoriaBean> categorias = new CategoriaDAO().obterTodos();
        req.setAttribute("categorias", categorias);

        req.getRequestDispatcher("/produto/editar.jsp").include(req, resp);
    }
}
