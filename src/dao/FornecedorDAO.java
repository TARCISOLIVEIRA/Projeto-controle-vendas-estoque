
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
import model.Funcionario;
public class FornecedorDAO {
    
    private Connection conn;
    
    
    public FornecedorDAO(){
        this.conn = new ConexaoBanco().pegarConexao();
    }
    
    public void Salvar(Fornecedor cli){
        
        try {
            // 1 Criando o sql;
            String sql = "insert into tb_fornecedores (nome,cnpj,email, telefone,celular,cep,endereco,numero,complemento, bairro, cidade, estado)" 
                          + "values(?,?,?,?,?,?,?,?,?,?,?,?)";
            // preparação conexao sql com banco
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setString(1,cli.getNome());
            
            stmt.setString(2,cli.getCnpj());
            stmt.setString(3,cli.getEmail());
            
            
            
            stmt.setString(4,cli.getTelefone());
            stmt.setString(5,cli.getCelular());
            stmt.setString(6,cli.getCep());
            stmt.setString(7,cli.getEndereco());
            stmt.setInt(8,cli.getNumero());
            stmt.setString(9,cli.getComplemento());
            stmt.setString(10,cli.getBairro());
            stmt.setString(11,cli.getCidade());
            stmt.setString(12,cli.getEstado());
            
            stmt.executeUpdate();
            stmt.close();
            
            JOptionPane.showMessageDialog(null,"Fornecedores salvo com sucesso");
                    
            
        } catch (SQLException erro) {
            JOptionPane.showMessageDialog(null,"Erro ao salvar o Fornecedores"+ erro);
            
        }
        
        
    }
    
    
     public void Editar(Fornecedor cli){
        
        try {
            // 1 Criando o sql;
            String sql = "update tb_fornecedores set nome=?, cnpj=?,email=?, telefone=?,celular=?, cep=?, endereco=?, numero=?,complemento=?,bairro=?,cidade=?, estado=? where id=?";
            // preparação conexao sql com banco
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setString(1,cli.getNome());
            
            stmt.setString(2,cli.getCnpj());
            
            stmt.setString(3,cli.getEmail());
            
            
            
            stmt.setString(4,cli.getTelefone());
            stmt.setString(5,cli.getCelular());
            stmt.setString(6,cli.getCep());
            stmt.setString(7,cli.getEndereco());
            
            if(cli.getNumero()==0){
                stmt.setNull(8, java.sql.Types.INTEGER);
            } else {
                stmt.setInt(8,cli.getNumero());
            }
            
            stmt.setString(9,cli.getComplemento());
            stmt.setString(10,cli.getBairro());
            stmt.setString(11,cli.getCidade());
            stmt.setString(12,cli.getEstado());
            stmt.setInt(13,cli.getId());
            
            stmt.execute();
            stmt.close();
            
            JOptionPane.showMessageDialog(null,"Fornecedor Editado com sucesso");
                    
            
        } catch (SQLException erro) {
            JOptionPane.showMessageDialog(null,"Erro ao salvar o Fornecedor"+ erro);
            
        }
        
        
    }
     
     
     
     public void Excluir(Fornecedor obj){
         try {
             String sql="delete from tb_fornecedores where id=?";
             PreparedStatement stmt = conn.prepareStatement(sql);
             stmt.setInt(1, obj.getId());
             stmt.execute();
             stmt.close();
             
             JOptionPane.showMessageDialog(null,"Fornecedor excluido");
             
                     
         } catch (SQLException e) {
             JOptionPane.showMessageDialog(null,"erro ao excluir"+e);
         }
     }
    
    public Fornecedor buscarFornecedor(String nome){
        
        try {
            String sql = "select * from tb_fornecedores where nome like ?";
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setString(1,"%" + nome.trim() + "%");
            ResultSet rs = stmt.executeQuery();
            Fornecedor obj = new Fornecedor();
            if(rs.next()){
                obj.setId(rs.getInt("id"));
                obj.setNome(rs.getString("nome"));
                obj.setCnpj(rs.getString("cnpj"));
                obj.setEmail(rs.getString("email"));
                obj.setTelefone(rs.getString("telefone"));
                obj.setCelular(rs.getString("celular"));
                obj.setCep(rs.getString("cep"));
                obj.setEndereco(rs.getString("endereco"));
                obj.setNumero(rs.getInt("numero"));
                obj.setComplemento(rs.getString("complemento"));
                obj.setBairro(rs.getString("bairro"));
                obj.setCidade(rs.getString("cidade"));
                obj.setEstado(rs.getString("estado"));
                
            } 
            return obj;
        } catch (SQLException erro) {
            JOptionPane.showMessageDialog(null,"erro ao buscar fornecedo!!!!!" + erro);
        }
        return null;
        
       
    }
    
    public List<Fornecedor> Listar(){
        List<Fornecedor> lista = new ArrayList();
        try {
            String sql = "select * from tb_fornecedores";  
            PreparedStatement stmt = conn.prepareStatement(sql);
            ResultSet rs = stmt.executeQuery();
            
            while (rs.next()){
                
                Fornecedor obj = new Fornecedor();
                obj.setId(rs.getInt("id"));
                obj.setNome(rs.getString("nome"));
           
                obj.setCnpj(rs.getString("cnpj"));
                obj.setEmail(rs.getString("email"));
               obj.setTelefone(rs.getString("telefone"));
               obj.setCelular(rs.getString("celular"));
               obj.setCep(rs.getString("Cep"));
                
                
                obj.setEndereco(rs.getString("endereco"));
               
                obj.setNumero(rs.getInt("numero"));
                
                obj.setComplemento(rs.getString("complemento"));
                obj.setBairro(rs.getString("bairro"));
                obj.setCidade(rs.getString("cidade"));
                obj.setEstado(rs.getString("estado"));
                
                
                
               
                
                
                lista.add(obj);
                
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null,"erro ao criar a listar de fornecedor " + e);
        }
        return lista;
    }
        
    public List<Fornecedor>Filtrar(String nome){
        List<Fornecedor> lista = new ArrayList();
        try {
            String sql = "select * from tb_fornecedores where nome like ?";
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setString(1, nome);
            ResultSet rs = stmt.executeQuery();
            while (rs.next()){
                Fornecedor obj = new Fornecedor();
                obj.setId(rs.getInt("id"));
                obj.setNome(rs.getString("nome"));
               
                obj.setCnpj(rs.getString("cnpj"));
               
                obj.setEmail(rs.getString("email"));
               
                
                
                
                obj.setTelefone(rs.getString("telefone"));
                obj.setCelular(rs.getString("celular"));
                obj.setCep(rs.getString("cep"));
                obj.setEndereco(rs.getString("endereco"));
                obj.setNumero(rs.getInt("numero"));
                obj.setComplemento(rs.getString("complemento"));
                obj.setBairro(rs.getString("bairro"));
                obj.setCidade(rs.getString("cidade"));
                obj.setEstado(rs.getString("estado"));
                
                lista.add(obj);
                
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null,"erro ao filtrar");
        }
        return lista;
    }
        
    
}
