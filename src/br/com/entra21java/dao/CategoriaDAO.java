package br.com.entra21java.dao;

import br.com.entra21java.bean.CategoriaBean;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import static java.sql.Statement.RETURN_GENERATED_KEYS;

public class CategoriaDAO {

    public List<CategoriaBean> obterTodos() {
        List<CategoriaBean> categorias = new ArrayList<>();
        String sql = "SELECT id, nome FROM categorias";
        try{
            Statement st = ConexaoFactory.conectar().createStatement();
            st.execute(sql);
            ResultSet resultSet = st.getResultSet();
            while (resultSet.next()){
                CategoriaBean categoria = new CategoriaBean();
                categoria.setId(resultSet.getInt("id"));
                categoria.setNome(resultSet.getString("nome"));
                categorias.add(categoria);
            }
        }catch (SQLException e){
            e.printStackTrace();
        }finally {
            ConexaoFactory.desconectar();
        }
        return categorias;
    }

    public CategoriaBean obterPorId(int id) {
        CategoriaBean categoria = null;
        String sql = "SELECT id, nome FROM categorias WHERE id = ?";
        try{
            PreparedStatement pstm = ConexaoFactory.conectar().prepareStatement(sql);
            pstm.setInt(1, id);
            ResultSet resultSet = pstm.getResultSet();
            while (resultSet.next()){
                categoria = new CategoriaBean();
                categoria.setId(resultSet.getInt("id"));
                categoria.setNome(resultSet.getString("nome"));
            }
        }catch (SQLException e){
            e.printStackTrace();
        }finally {
            ConexaoFactory.desconectar();
        }
        return categoria;
    }

    public int inserir(CategoriaBean categoria) {
        String sql = "INSERT INTO categorias (nome) VALUE (?)";
        try {
            PreparedStatement pstm = ConexaoFactory.conectar().prepareStatement(sql, RETURN_GENERATED_KEYS);
            pstm.setString(1, categoria.getNome());

            pstm.execute();
            ResultSet resultSet = pstm.getResultSet();
            if (resultSet.last()) {
                return resultSet.getInt(1);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            ConexaoFactory.desconectar();
        }
        return -1;
    }

    public boolean alterar(CategoriaBean categoria) {
        String sql = "UPDATE categorias SET nome = ? WHERE id = ?";
        try {
            PreparedStatement pstm = ConexaoFactory.conectar().prepareStatement(sql);
            pstm.setString(1, categoria.getNome());
            pstm.setInt(2, categoria.getId());
            return pstm.executeUpdate() == 1;
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            ConexaoFactory.desconectar();
        }
        return false;
    }

    public boolean excluido(int id) {
        String sql = "DELETE FROM categorias WHERE id = ?";
        try {
            PreparedStatement pstm = ConexaoFactory.conectar().prepareStatement(sql);
            pstm.setInt(1, id);
            return pstm.executeUpdate() == 1;
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            ConexaoFactory.desconectar();
        }
        return false;
    }

}
