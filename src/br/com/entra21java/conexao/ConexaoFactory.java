package br.com.entra21java.conexao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConexaoFactory {

    private static String CLASS_NAME = "com.mysql.jdbc.Driver";
    private static String HOST = "jdbc:mysql://localhost/exemplo_web_03?useTimezone=true&serverTimezone=UTC";
    private static String LOGIN = "localhost";
    private static String SENHA = "localhost";
    private static Connection conexao;

    public static Connection conectar() {
        try {
            Class.forName(CLASS_NAME);
            conexao = DriverManager.getConnection(HOST, LOGIN, SENHA);
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return conexao;
    }

    public static void desconectar() {
        try {
            if (conexao != null) {
                conexao.close();
            }
        } catch (SQLException e) {
            e.printStackTrace();
    }
}


}
