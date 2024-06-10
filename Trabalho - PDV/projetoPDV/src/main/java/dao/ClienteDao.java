/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.Cliente;

/**
 *
 * @author Usuário
 */
public class ClienteDao extends GenericDao<Cliente>{

    @Override
    protected Cliente construirObjeto(ResultSet rs) {
        Cliente cliente = null;
        
        try {
            cliente = new Cliente();
            cliente.setId(rs.getInt("ID_CLIENTE"));
            cliente.setNome(rs.getString("NOME_CLIENTE"));
            cliente.setEmail(rs.getString("EMAIL_CLIENTE"));
            cliente.setTelefone(rs.getString("TELEFONE_CLIENTE"));
            
        } catch (SQLException ex) {
            Logger.getLogger(ClienteDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        return cliente;
    }

    @Override
    public boolean salvar(Cliente obj) {
        String sql = "INSERT INTO public.\"Cliente\""
                +"(\"ID_CLIENTE\", \"NOME_CLIENTE\", \"EMAIL_CLIENTE\", \"TELEFONE_CLIENTE\") VALUES (?, ?, ?, ?);";
        
        PreparedStatement ps = null;
        
        try {
            ps = conn.prepareStatement(sql);
            ps.setInt(1, obj.getId());
            ps.setString(2, obj.getNome());
            ps.setString(3, obj.getEmail());
            ps.setString(4, obj.getTelefone());
            ps.executeUpdate();
            
            return true;
            
            
        } catch (SQLException ex) {
            Logger.getLogger(ClienteDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }

    @Override
    public boolean atualizar(Cliente obj) {
        String sql = "UPDATE public.\"Cliente\" SET \"NOME_CLIENTE\" = ?, \"EMAIL_CLIENTE\" = ?, \"TELEFONE_CLIENTE\" = ? WHERE \"ID_CLIENTE\"= ?;";
        
       PreparedStatement ps = null;
       
        try {
            ps = conn.prepareStatement(sql);
            ps.setString(1, obj.getNome());
            ps.setString(2, obj.getEmail());
            ps.setString(3, obj.getTelefone());
            ps.setInt(4,obj.getId());
            ps.executeUpdate();
            
            return true;
            
            
        } catch (SQLException ex) {
             Logger.getLogger(ClienteDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return false;
      
    }
    
    public void gerarRelatorio(){
    
            try {
            String relatorioPath = "" // passar o caminho do relatório 
                    JasperPrint printer = JasperFillManager.fillReport(relatorioPath, null, conn);
                    
                    JasperViewer view = new JasperViewer(printer, false);
                    view.setVisible(true);
                    
        } catch (JRException ex) {
            Logger.getLogger(ClienteDao.class.getName()).log(Level.SEVERE, null, ex);
        }
    
        
        
    }
    
}
