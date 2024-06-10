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
import model.Venda;

/**
 *
 * @author Usuário
 */
public class VendaDao extends GenericDao<Venda> {

    @Override
    protected Venda construirObjeto(ResultSet rs) {
         Venda venda = null;
        
        try {
            venda = new Venda();
            venda.setIdVenda(rs.getInt("ID_VENDA"));
            venda.setObservacoes(rs.getString("OBSERVACOES_VENDA"));
            venda.setDataVenda(rs.getString("DATA_VENDA"));
            venda.setValorVenda(rs.getDouble("VALOR_VENDA"));
               
        } catch (SQLException ex) {
            Logger.getLogger(VendaDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        return venda;
    }

    @Override
    public boolean salvar(Venda obj) {
        String sql = "INSERT INTO public.\"Venda\""
                +"(\"ID_VENDA\", \"OBSERVACOES_VENDA\", \"DATA_VENDA\", \"VALOR_VENDA\") VALUES (?, ?, ?, ?);";
        
        PreparedStatement ps = null;
        
        try {
            ps = conn.prepareStatement(sql);
            ps.setInt(1, obj.getIdVenda());
            ps.setString(2, obj.getObservacoes());
            ps.setString(3, obj.getDataVenda());
            ps.setDouble(4, obj.getValorVenda());
            ps.executeUpdate();
            
            return true;
            
            
        } catch (SQLException ex) {
            Logger.getLogger(VendaDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }

    @Override
    public boolean atualizar(Venda obj) {
        String sql = "UPDATE public.\"Venda\" SET \"OBSERVACOES_VENDA\" = ?, \"DATA_VENDA\" = ?, \"VALOR_VENDA\" = ? WHERE \"ID_VENDA\"= ?;";
        
       PreparedStatement ps = null;
       
        try {
            ps = conn.prepareStatement(sql);
            ps.setString(1, obj.getObservacoes());
            ps.setString(2, obj.getDataVenda());
            ps.setDouble(3, obj.getValorVenda());
            ps.setInt(4,obj.getIdVenda());
            ps.executeUpdate();
            
            return true;
            
            
        } catch (SQLException ex) {
             Logger.getLogger(VendaDao.class.getName()).log(Level.SEVERE, null, ex);
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
