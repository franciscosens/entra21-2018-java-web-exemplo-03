package br.com.entra21java.web.categoria;

import br.com.entra21java.bean.CategoriaBean;
import br.com.entra21java.dao.CategoriaDAO;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/categorias/editar")
public class CategoriaEditar extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int id = Integer.parseInt(req.getParameter("id"));
      
        resp.setContentType("text/html; charset=UTF-8");
        
        CategoriaBean categoria = new CategoriaDAO().obterPorId(id);
        req.setAttribute("categoria", categoria);

        req.getRequestDispatcher("/categoria/editar.jsp").include(req, resp);
    }
}
