
package dao;

// caderno 12
import controledeestoque1.ConexaoBanco;
import java.sql.Connection;
import java.sql.PreparedStatement;
import javax.swing.JOptionPane;
import java.sql.SQLException;
import model.Clientes;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import model.Fornecedor;
import model.Produto;
public class ProdutoDAO {
    
    private Connection conn;
    
    
    public ProdutoDAO(){
        this.conn = new ConexaoBanco().pegarConexao();
    }
    
    
    
    
    


public boolean salvar(Produto obj) {
    
    try {
        // Verificar se produto já existe
        String sqlVerifica = "SELECT * FROM tb_produtos WHERE descricao = ?";

        PreparedStatement stmtVerifica = conn.prepareStatement(sqlVerifica);
        stmtVerifica.setString(1, obj.getDescricao());

        ResultSet rs = stmtVerifica.executeQuery();

        if (rs.next()) {
            JOptionPane.showMessageDialog(null,
                    "Produto já cadastrado!");
            return false;
        }

        // INSERT
        String sql = "INSERT INTO tb_produtos(descricao, preco, qtd_estoque, for_id) VALUES(?,?,?,?)";

        PreparedStatement stmt = conn.prepareStatement(sql);

        stmt.setString(1, obj.getDescricao());
        stmt.setDouble(2, obj.getPreco());
        stmt.setInt(3, obj.getQtd_estoque());
        stmt.setInt(4, obj.getFornecedor().getId());

        stmt.execute();
        
        stmt.close();
        return true;


    } catch (Exception erro) {
        JOptionPane.showMessageDialog(null,
                "Erro ao cadastrar produto: " + erro.getMessage());
        return false;
    }
}
    
    
    
  /*  public void Salvar(Produto cli){
        
        try {
            String sql = "insert into tb_Produtos (descricao,preco,qtd_estoque,for_id)" 
                          + "values(?,?,?,?)";
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setString(1,cli.getDescricao());
            stmt.setDouble(2,cli.getPreco());
            stmt.setInt(3,cli.getQtd_estoque());
            stmt.setInt(4,cli.getFornecedor().getId());
            stmt.execute();
            stmt.close();
            JOptionPane.showMessageDialog(null,"Produto salvo com sucesso");
        } catch (SQLException erro) {
            JOptionPane.showMessageDialog(null,"Erro ao salvar o Produto"+ erro);
        }
    }*/
    
    
     public void Editar(Produto cli){
        
        try {
            // 1 Criando o sql;
            String sql = "update tb_produtos set descricao=?, preco=?, qtd_estoque=?,for_id=? where id=?";
            // preparação conexao sql com banco
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setString(1,cli.getDescricao());
            stmt.setDouble(2,cli.getPreco());
            stmt.setInt(3,cli.getQtd_estoque());
            stmt.setInt(4,cli.getFornecedor().getId());
            stmt.setInt(5,cli.getId());
            
            
            stmt.executeUpdate();
            stmt.close();
            
            JOptionPane.showMessageDialog(null,"Produto Editado com sucesso");
                    
            
        } catch (SQLException erro) {
            JOptionPane.showMessageDialog(null,"Erro ao salvar o Produto"+ erro);
            
        }
        
        
    }
     
     
     
     public void Excluir(Produto obj){
         try {
             String sql="delete from tb_produtos where id=?";
             PreparedStatement stmt = conn.prepareStatement(sql);
             stmt.setInt(1, obj.getId());
             stmt.execute();
             stmt.close();
             
             JOptionPane.showMessageDialog(null,"Produto excluido");
             
                     
         } catch (SQLException e) {
             JOptionPane.showMessageDialog(null,"erro ao excluir o produto"+e);
         }
     }
    
    public Produto BuscarProdutos(String nome){
        
        try {
            String sql = "select p.id, p.descricao, p.preco, p.qtd_estoque, f.nome from tb_produtos as p inner join "
                    + "tb_fornecedores as f on  (p.for_id = f.id)where p.descricao =?";
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setString(1,nome);
            ResultSet rs = stmt.executeQuery();
            Produto obj = new Produto();
            Fornecedor f = new Fornecedor();
            
            if(rs.next()){
                obj.setId(rs.getInt("p.id"));
                obj.setDescricao(rs.getString("p.descricao"));
                obj.setPreco(rs.getDouble("p.preco"));
                obj.setQtd_estoque(rs.getInt("p.qtd_estoque"));
                
                f.setNome(rs.getString("f.nome"));
                
                obj.setFornecedor(f);
                
                
            } 
            return obj;
        } catch (Exception erro) {
            JOptionPane.showMessageDialog(null,"erro ao buscar Produto" + erro);
        }
        return null;
        
        // cap 14
    }
    
    
    
    
    
    
    public Produto BuscarProdutosCodigo(int id){
        
        try {
            String sql = "select p.id, p.descricao, p.preco, p.qtd_estoque, f.nome from tb_produtos as p inner join "
                    + "tb_fornecedores as f on  (p.for_id = f.id)where p.id =?";
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setInt(1,id);
            ResultSet rs = stmt.executeQuery();
            Produto obj = new Produto();
            Fornecedor f = new Fornecedor();
            
            if(rs.next()){
                obj.setId(rs.getInt("p.id"));
                obj.setDescricao(rs.getString("p.descricao"));
                obj.setPreco(rs.getDouble("p.preco"));
                obj.setQtd_estoque(rs.getInt("p.qtd_estoque"));
                
                f.setNome(rs.getString("f.nome"));
                
                obj.setFornecedor(f);
                
                
            } 
            return obj;
        } catch (Exception erro) {
            JOptionPane.showMessageDialog(null,"erro ao buscar Produto" + erro);
        }
        return null;
        
        // cap 14
    }
    
    public List<Produto> Listar(){
        List<Produto> lista = new ArrayList();
        try {
            
           
            String sql ="select p.id, p.descricao, p.preco, p.qtd_estoque, f.id as fornecedor_id, "
                    + "f.nome as fornecedor_nome from tb_produtos p "
                    + "inner join tb_fornecedores f on p.for_id = f.id";
                    
            PreparedStatement stmt = conn.prepareStatement(sql);
            ResultSet rs = stmt.executeQuery();
            while (rs.next()){
               
                Fornecedor f = new Fornecedor();
                f.setId(rs.getInt("fornecedor_id"));
                f.setNome(rs.getString("fornecedor_nome"));
                
                Produto p = new Produto();
                
                p.setId(rs.getInt("id"));
                p.setDescricao(rs.getString("descricao"));
                p.setPreco(rs.getDouble("preco"));
                p.setQtd_estoque(rs.getInt("qtd_estoque"));
               
                p.setFornecedor(f);
                lista.add(p);
                
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null,"erro ao criar a listar de Produto e Fornecedor "+ e);
        }
        return lista;
    }
        
    public List<Produto>Filtrar(String nome){
        List<Produto> lista = new ArrayList();
        try {
            String sql = "select p.id,p.descricao,p.preco, p.qtd_estoque, f.nome "
                    + " from tb_produtos as p inner join"
                    + " tb_fornecedores as f on (p.for_id = f.id)"
                    + " where p.descricao like ?";
            
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setString(1, nome);
            ResultSet rs = stmt.executeQuery();
            while (rs.next()){
                Produto obj = new Produto();
                Fornecedor f = new Fornecedor();
                
                obj.setId(rs.getInt("p.id"));
                
                obj.setDescricao(rs.getString("p.descricao"));
                obj.setPreco(rs.getDouble("p.preco"));
                obj.setQtd_estoque(rs.getInt("p.qtd_estoque"));
                
                f.setNome(rs.getString("f.nome"));
                obj.setFornecedor(f);
                
                lista.add(obj);
                
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null,"erro ao filtrar Produtos" + e);
        }
        return lista;
    }
        
    public void adicionarEstoque( int id , int qtd_nova){
        try {
        String sql = "update tb_produtos set qtd_estoque=? where id=?";
        PreparedStatement stmt = conn.prepareStatement(sql);
        stmt.setInt(1, qtd_nova);
        stmt.setInt(2, id);
        stmt.execute();
        stmt.close();
        
        JOptionPane.showMessageDialog(null,"Adicionou estoque com Sucesso");
        
        } catch (Exception e) {
        JOptionPane.showMessageDialog(null,"erro adicionar"+ e); 
            
        }
        
    }
    
     public void baixaEstoque( int id, int qtd_nova){
        try {
         Connection conn = new ConexaoBanco().pegarConexao(); // GARANTE CONEXÃO

        String sql = "UPDATE tb_produtos SET qtd_estoque=? WHERE id=?";
        PreparedStatement stmt = conn.prepareStatement(sql);

        stmt.setInt(1, qtd_nova);
        stmt.setInt(2, id);

        stmt.executeUpdate(); //  melhor que execute()

        stmt.close();
        conn.close(); //  fecha conexão

    } catch (Exception e) {
        JOptionPane.showMessageDialog(null, "erro baixa estoque: " + e);
    }
}
        
        
    
     
     public int retornarQtdAtualEstoque(int id){
         try {
             int qtd_atual_estoque = 0;
             String sql ="select qtd_estoque from tb_produtos where id = ?";
             PreparedStatement stmt = conn.prepareStatement(sql);
             stmt.setInt(1,id);
             ResultSet rs = stmt.executeQuery();
             if(rs.next()){
                 qtd_atual_estoque =(rs.getInt("qtd_estoque"));
                 
             }
             return qtd_atual_estoque;
            // JOptionPane.showMessageDialog(null, "estoque atual com sucesso");
            
         } catch (SQLException e) {
             throw new RuntimeException("erro ao retornar a quantidade"+ e);
         }
         
     }
}
