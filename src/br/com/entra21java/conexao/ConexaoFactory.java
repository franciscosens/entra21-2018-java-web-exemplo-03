package br.com.entra21java.conexao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConexaoFactory {

    private static String CLASS_NAME = "com.mysql.jdbc.Driver";
    private static String HOST = "jdbc:mysql://localhost/WebExemplo03?useTimezone=true&serverTimezone=UTC&useSSL=false";
    private static String LOGIN = "localhost";
    private static String SENHA = "localhost";
    private static Connection conexao;

    public static Connection conectar() {
        try {
            /*  String dbName = System.getProperty("RDS_DB_NAME");
            LOGIN = System.getProperty("RDS_USERNAME");
            SENHA = System.getProperty("RDS_PASSWORD");
            String hostname = System.getProperty("RDS_HOSTNAME");
            String port = System.getProperty("RDS_PORT");
            
            HOST = "jdbc:mysql://" + hostname + ":" + port + "/" + dbName;*/

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
