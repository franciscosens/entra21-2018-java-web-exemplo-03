package br.com.entra21java.web.produto;

import br.com.entra21java.bean.ProdutoBean;
import br.com.entra21java.dao.ProdutoDAO;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;


@WebServlet("/produtos")
public class ProdutoIndex extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        List<ProdutoBean> produtos = new ProdutoDAO().obterTodos();

        req.setAttribute("produtos", produtos);
        req.getRequestDispatcher("/produto/index.jsp").include(req, resp);
    }
}


