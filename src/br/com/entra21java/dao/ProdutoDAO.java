package br.com.entra21java.dao;

import br.com.entra21java.bean.ProdutoBean;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import static java.sql.Statement.RETURN_GENERATED_KEYS;

public class ProdutoDAO {

    public List<ProdutoBean> obterTodos() {
        List<ProdutoBean> produtos = new ArrayList<>();
        String sql = "SELECT id, id_categoria, nome, preco FROM produtos";
        try {
            Statement st = ConexaoFactory.conectar().createStatement();
            st.execute(sql);
            ResultSet resultSet = st.getResultSet();
            while (resultSet.next()) {
                ProdutoBean produto = new ProdutoBean();
                produto.setId(resultSet.getInt("id"));
                produto.setIdCategoria(resultSet.getInt("id_categoria"));
                produto.setNome(resultSet.getString("nome"));
                produto.setPreco(resultSet.getDouble("preco"));
                produtos.add(produto);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            ConexaoFactory.desconectar();
        }
        return produtos;
    }

    public ProdutoBean obterPorId(int id) {
        ProdutoBean produto = null;
        String sql = "SELECT id, id_categoria, nome, preco FROM produtos WHERE id = ?";
        try {
            PreparedStatement pstm = ConexaoFactory.conectar().prepareStatement(sql);
            pstm.setInt(1, id);
            ResultSet resultSet = pstm.getResultSet();
            while (resultSet.next()) {
                produto = new ProdutoBean();
                produto.setId(resultSet.getInt("id"));
                produto.setIdCategoria(resultSet.getInt("id_categoria"));
                produto.setNome(resultSet.getString("nome"));
                produto.setPreco(resultSet.getDouble("preco"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            ConexaoFactory.desconectar();
        }
        return produto;
    }

    public int inserir(ProdutoBean produto) {
        String sql = "INSERT INTO produtos (id_categoria, nome, preco) VALUE (?)";
        try {
            PreparedStatement pstm = ConexaoFactory.conectar().prepareStatement(sql, RETURN_GENERATED_KEYS);
            pstm.setInt(1, produto.getIdCategoria());
            pstm.setString(2, produto.getNome());
            pstm.setDouble(3, produto.getPreco());

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

    public boolean alterar(ProdutoBean produto) {
        String sql = "UPDATE produtos SET id_categoria = ?, nome = ?, preco = ? WHERE id = ?";
        try {
            PreparedStatement pstm = ConexaoFactory.conectar().prepareStatement(sql);
            pstm.setInt(1, produto.getIdCategoria());
            pstm.setString(1, produto.getNome());
            pstm.setDouble(3, produto.getPreco());
            return pstm.executeUpdate() == 1;
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            ConexaoFactory.desconectar();
        }
        return false;
    }

    public boolean excluido(int id) {
        String sql = "DELETE FROM produtos WHERE id = ?";
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
