/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package conexaoBD;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Usuário
 */
public class ConexaoPostgres {

    private static final String DRIVER = "org.postgresql.Driver";
    private static final String URL = "jdbc:postgresql://localhost:5432/PDV-Desktop";
    private static final String USER = "postgres";
    private static final String PASSWORD = "postgres";

    //abrindol conexão com a BD
    public static Connection getConection() {
        try {
            Class.forName(DRIVER);

            return DriverManager.getConnection(URL, USER, PASSWORD);

        } catch (ClassNotFoundException ex) {
            Logger.getLogger(ConexaoPostgres.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(ConexaoPostgres.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    //fechando a conexão com a BD
    public static void closeConnection(Connection conn) {
        if (conn != null) { // verificando se há conexão em aberto 
            try {
                conn.close(); // fechando a conexão se ela estiver aberta
            } catch (SQLException ex) {
                Logger.getLogger(ConexaoPostgres.class.getCanonicalName()).log(Level.SEVERE, null, ex);
            }

        }
    }
    
    //fechando transação 
    public static void closeTransaction(Connection conn, PreparedStatement ps){
        if(ps != null){
            try {
                ps.close();
            } catch (SQLException ex) {
                Logger.getLogger(ConexaoPostgres.class.getName()).log(Level.SEVERE, null, ex);
            }
        
        }
        closeConnection(conn);
    }

}
