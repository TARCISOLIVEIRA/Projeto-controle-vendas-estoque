
package dao;

import controledeestoque1.ConexaoBanco;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import model.ItemVendas;
import java.sql.PreparedStatement;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import model.Produto;


public class ItensVendasDAO {
    
     private Connection conn;
     
    
    
    public ItensVendasDAO(){
        this.conn = new ConexaoBanco().pegarConexao();
    }
    
    public void salvar(ItemVendas obj){
          
        try {
            String sql ="insert into tb_itensvendas (venda_id, produto_id, qtd, subtotal)values(?,?,?,?)";
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setInt(1,obj.getVendas().getId());
            stmt.setInt(2,obj.getProduto().getId());
            stmt.setInt(3,obj.getQtd());
            stmt.setDouble(4,obj.getSubtotal());
            stmt.execute();
            stmt.close();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, " erro ao salvar o Itens" + e.getMessage());
        }
    }
    
    
    public List<ItemVendas>listaItens(int venda_id){
        try {
            List<ItemVendas>lista = new ArrayList<>();
            String sql ="select p.id as prod_id, p.descricao as prod_desc, p.preco as prod_preco, i.qtd, i.subtotal from tb_itensvendas i inner join tb_produtos p on p.id = i.produto_id where i.venda_id = ? ";
                   
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setInt(1,venda_id);
            ResultSet rs = stmt.executeQuery();
            while(rs.next()) {
               ItemVendas item =  new ItemVendas();
               Produto p = new Produto();
               
               p.setId(rs.getInt("prod_id"));
               p.setDescricao(rs.getString("prod_desc"));
               p.setPreco(rs.getDouble("prod_preco"));
               item.setProduto(p);
               
                
               
               item.setQtd(rs.getInt("qtd"));
               item.setSubtotal(rs.getDouble("subtotal"));
               lista.add(item);
             }
            
            return lista;
            
            
        } catch (SQLException e) {
            
            throw new RuntimeException("Erro ao criar a lista de item " + e);
        }
        
        
    }
    
    
}
