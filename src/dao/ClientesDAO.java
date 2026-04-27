
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
public class ClientesDAO {
    
    private Connection conn;
    
    
    public ClientesDAO(){
        this.conn = new ConexaoBanco().pegarConexao();
    }
    
    public void Salvar(Clientes cli){
        
        try {
            // 1 Criando o sql;
            String sql = "insert into tb_clientes (nome,rg,cpf,email, telefone,celular,cep,endereco,numero,complemento, bairro, cidade, estado)" 
                          + "values(?,?,?,?,?,?,?,?,?,?,?,?,?)";
            // preparação conexao sql com banco
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setString(1,cli.getNome());
            stmt.setString(2,cli.getRg());
            stmt.setString(3,cli.getCpf());
            stmt.setString(4,cli.getEmail());
            stmt.setString(5,cli.getTelefone());
            stmt.setString(6,cli.getCelular());
            stmt.setString(7,cli.getCep());
            stmt.setString(8,cli.getEndereco());
            stmt.setInt(9,cli.getNumero());
            stmt.setString(10,cli.getComplemento());
            stmt.setString(11,cli.getBairro());
            stmt.setString(12,cli.getCidade());
            stmt.setString(13,cli.getEstado());
            
            stmt.execute();
            stmt.close();
            
            JOptionPane.showMessageDialog(null,"cliente salvo com sucesso");
                    
            
        } catch (SQLException erro) {
            JOptionPane.showMessageDialog(null,"Erro ao salvar o cliente"+ erro);
            
        }
        
        
    }
    
    
     public void Editar(Clientes cli){
        
        try {
            // 1 Alterando clinetes o sql;
            String sql = "update tb_clientes set nome=?, rg=?, cpf=?,email=?,telefone=?,celular=?, cep=?, endereco=?, numero=?,complemento=?,bairro=?,cidade=?, estado=? where id=?";
            // preparação conexao sql com banco
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setString(1,cli.getNome());
            stmt.setString(2,cli.getRg());
            stmt.setString(3,cli.getCpf());
            stmt.setString(4,cli.getEmail());
            stmt.setString(5,cli.getTelefone());
            stmt.setString(6,cli.getCelular());
            stmt.setString(7,cli.getCep());
            stmt.setString(8,cli.getEndereco());
            stmt.setInt(9,cli.getNumero());
            stmt.setString(10,cli.getComplemento());
            stmt.setString(11,cli.getBairro());
            stmt.setString(12,cli.getCidade());
            stmt.setString(13,cli.getEstado());
            stmt.setInt(14,cli.getId());
            
            stmt.execute();
            stmt.close();
            
            JOptionPane.showMessageDialog(null,"Cliente Editado com sucesso.!");
                    
            
        } catch (SQLException erro) {
            JOptionPane.showMessageDialog(null,"Erro ao editar o Cliente"+ erro);
            
        }
        
        
    }
     
     
     
     public void Excluir(Clientes obj){
         try {
             String sql="delete from tb_clientes where id=?";
             PreparedStatement stmt = conn.prepareStatement(sql);
             stmt.setInt(1, obj.getId());
             stmt.execute();
             stmt.close();
             
             JOptionPane.showMessageDialog(null,"cliente excluido");
             
                     
         } catch (SQLException e) {
             JOptionPane.showMessageDialog(null,"erro ao excluir"+e);
         }
     }
    
    public Clientes BuscarCliente(String nome){
        
        try {
            String sql = "select * from tb_clientes where nome =?";
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setString(1,nome);
            ResultSet rs = stmt.executeQuery();
            Clientes obj = new Clientes();
            if(rs.next()){
                obj.setId(rs.getInt("id"));
                obj.setNome(rs.getString("nome"));
                obj.setRg(rs.getString("rg"));
                obj.setCpf(rs.getString("cpf"));
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
        } catch (Exception erro) {
            JOptionPane.showMessageDialog(null,"erro ao buscar cliente" + erro);
        }
        return null;
        
        // cap 14
    }
    
    
     public Clientes BuscarClienteCPF(String cpf){
        
        try {
            String sql = "select * from tb_clientes where cpf =?";
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setString(1, cpf);
            ResultSet rs = stmt.executeQuery();
            Clientes obj = new Clientes();
            if(rs.next()){
                obj.setId(rs.getInt("id"));
                obj.setNome(rs.getString("nome"));
                obj.setRg(rs.getString("rg"));
                obj.setCpf(rs.getString("cpf"));
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
        } catch (Exception erro) {
            JOptionPane.showMessageDialog(null,"erro ao buscar Cpf do Cliente " + erro);
        }
        return null;
        
        // cap 14
    }
    
    public List<Clientes> Listar(){
        List<Clientes> lista = new ArrayList();
        try {
            String sql = "select * from tb_clientes";
            PreparedStatement stmt = conn.prepareStatement(sql);
            ResultSet rs = stmt.executeQuery();
            while (rs.next()){
                Clientes obj = new Clientes();
                obj.setId(rs.getInt("id"));
                obj.setNome(rs.getString("nome"));
                obj.setRg(rs.getString("rg"));
                obj.setCpf(rs.getString("cpf"));
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
            JOptionPane.showMessageDialog(null,"erro ao criar a listar");
        }
        return lista;
    }
        
    public List<Clientes>Filtrar(String nome){
        List<Clientes> lista = new ArrayList();
        try {
            String sql = "select * from tb_clientes where nome like ?";
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setString(1, nome);
            ResultSet rs = stmt.executeQuery();
            while (rs.next()){
                Clientes obj = new Clientes();
                obj.setId(rs.getInt("id"));
                obj.setNome(rs.getString("nome"));
                obj.setRg(rs.getString("rg"));
                obj.setCpf(rs.getString("cpf"));
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
