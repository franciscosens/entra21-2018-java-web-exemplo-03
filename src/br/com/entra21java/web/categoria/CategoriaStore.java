package br.com.entra21java.web.categoria;

import br.com.entra21java.bean.CategoriaBean;
import br.com.entra21java.dao.CategoriaDAO;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/categorias/store")
public class CategoriaStore extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        CategoriaBean categoria = new CategoriaBean();
        categoria.setNome(req.getParameter("nome"));
        categoria.setId(new CategoriaDAO().inserir(categoria));
        resp.sendRedirect("/categorias/editar?id=" + categoria.getId());
    }

}
