package br.com.entra21java.web.categoria;

import br.com.entra21java.bean.CategoriaBean;
import br.com.entra21java.dao.CategoriaDAO;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/categorias/update")
public class CategoriaUpdate extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("utf-8");

        CategoriaBean categoria = new CategoriaBean();
        categoria.setNome(req.getParameter("nome"));
        categoria.setId(Integer.parseInt(req.getParameter("id")));
        new CategoriaDAO().alterar(categoria);
        resp.sendRedirect("/categorias/editar?id=" + categoria.getId());
    }

}
