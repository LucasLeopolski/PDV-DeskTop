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
import model.Produto;

/**
 *
 * @author Usuário
 */
public class ProdutoDao extends GenericDao<Produto>{

    @Override
    protected Produto construirObjeto(ResultSet rs) {
        Produto produto = null;
        
        try {
            produto = new Produto();
            produto.setIdProduto(rs.getInt("ID_PRODUTO"));
            produto.setDescricaoProduto(rs.getString("DESCRICAO_PRODUTO"));
            produto.setCategoriaProduto(rs.getString("CATEGORIA_PRODUTO"));
            produto.setValorProduto(rs.getBigDecimal("VALOR_PRODUTO"));
            
        } catch (SQLException ex) {
            Logger.getLogger(ProdutoDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        return produto;
    }

    @Override
    public boolean salvar(Produto obj) {
       String sql = "INSERT INTO public.\"Produto\""
                +"(\"ID_PRODUTO\", \"DESCRICAO_PRODUTO\", \"CATEGORIA_PRODUTO\", \"VALOR_PRODUTO\") VALUES (?, ?, ?, ?);";
        
        PreparedStatement ps = null;
        
        try {
            ps = conn.prepareStatement(sql);
            ps.setInt(1, obj.getIdProduto());
            ps.setString(2, obj.getDescricaoProduto());
            ps.setString(3, obj.getCategoriaProduto());
            ps.setBigDecimal(4, obj.getValorProduto());
            ps.executeUpdate();
            
            return true;
            
            
        } catch (SQLException ex) {
            Logger.getLogger(ProdutoDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }

    @Override
    public boolean atualizar(Produto obj) {
        String sql = "UPDATE public.\"Produto\" SET \"DESCRICAO_PRODUTO\" = ?, \"CATEGORIA_PRODUTO\" = ?, \"VALOR_PRODUTO\" = ? WHERE \"ID_PRODUTO\"= ?;";
        
       PreparedStatement ps = null;
       
        try {
            ps = conn.prepareStatement(sql);
            ps.setString(1, obj.getDescricaoProduto());
            ps.setString(2, obj.getCategoriaProduto());
            ps.setBigDecimal(3, obj.getValorProduto());
            ps.setInt(4,obj.getIdProduto());
            ps.executeUpdate();
            
            return true;
            
            
        } catch (SQLException ex) {
             Logger.getLogger(ProdutoDao.class.getName()).log(Level.SEVERE, null, ex);
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
