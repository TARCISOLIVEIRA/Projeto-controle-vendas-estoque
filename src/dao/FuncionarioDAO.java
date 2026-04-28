
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
import model.Funcionario;
//import view.AreaTrabalho;
//import view.FormularioLogin;
public class FuncionarioDAO {
    
    private Connection conn;
    
    
    public FuncionarioDAO(){
        this.conn = new ConexaoBanco().pegarConexao();
    }
    
    public void Salvar(Funcionario cli){
        
        try {
            // 1 Criando o sql;
            String sql = "insert into tb_funcionarios (nome,rg,cpf,email,senha,cargo,nivel_acesso, telefone,celular,cep,endereco,numero,complemento, bairro, cidade, estado)" 
                          + "values(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
            // preparação conexao sql com banco
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setString(1,cli.getNome());
            stmt.setString(2,cli.getRg());
            stmt.setString(3,cli.getCpf());
            stmt.setString(4,cli.getEmail());
            
            
            stmt.setString(5,cli.getSenha());
            stmt.setString(6,cli.getCargo());
            stmt.setString(7,cli.getNivel());
            
            
            stmt.setString(8,cli.getTelefone());
            stmt.setString(9,cli.getCelular());
            stmt.setString(10,cli.getCep());
            stmt.setString(11,cli.getEndereco());
            stmt.setInt(12,cli.getNumero());
            stmt.setString(13,cli.getComplemento());
            stmt.setString(14,cli.getBairro());
            stmt.setString(15,cli.getCidade());
            stmt.setString(16,cli.getEstado());
            
            stmt.executeUpdate();
            stmt.close();
            
            JOptionPane.showMessageDialog(null,"Funcionario salvo com sucesso");
                    
            
        } catch (SQLException erro) {
            JOptionPane.showMessageDialog(null,"Erro ao salvar o Funcionario"+ erro);
            
        }
        
        
    }
    
    
     public void Editar(Funcionario cli){
        
        try {
            // 1 Criando o sql;
            String sql = "update tb_funcionarios set nome=?, rg=?, cpf=?,email=?,senha=?, cargo=?, nivel_acesso=?, telefone=?,celular=?, cep=?, endereco=?, numero=?,complemento=?,bairro=?,cidade=?, estado=? where id=?";
            // preparação conexao sql com banco
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setString(1,cli.getNome());
            stmt.setString(2,cli.getRg());
            stmt.setString(3,cli.getCpf());
            
            stmt.setString(4,cli.getEmail());
            
            stmt.setString(5,cli.getSenha());
            stmt.setString(6,cli.getCargo());
            stmt.setString(7,cli.getNivel());
            
            stmt.setString(8,cli.getTelefone());
            stmt.setString(9,cli.getCelular());
            stmt.setString(10,cli.getCep());
            stmt.setString(11,cli.getEndereco());
            
            if(cli.getNumero()==0){
                stmt.setNull(12, java.sql.Types.INTEGER);
            } else {
                stmt.setInt(12,cli.getNumero());
            }
            
            
            
            stmt.setString(13,cli.getComplemento());
            stmt.setString(14,cli.getBairro());
            stmt.setString(15,cli.getCidade());
            stmt.setString(16,cli.getEstado());
            stmt.setInt(17,cli.getId());
            
            stmt.execute();
            stmt.close();
            
            JOptionPane.showMessageDialog(null,"Funcionario Editado com sucesso");
                    
            
        } catch (SQLException erro) {
            JOptionPane.showMessageDialog(null,"Erro ao salvar o Funcionario"+ erro);
            
        }
        
        
    }
     
     
     
     public void Excluir(Funcionario obj){
         try {
             String sql="delete from tb_funcionarios where id=?";
             PreparedStatement stmt = conn.prepareStatement(sql);
             stmt.setInt(1, obj.getId());
             stmt.execute();
             stmt.close();
             
             JOptionPane.showMessageDialog(null,"Funcionario excluido");
             
                     
         } catch (SQLException e) {
             JOptionPane.showMessageDialog(null,"erro ao excluir"+e);
         }
     }
    
    public Funcionario buscarFuncionario(String nome){
        
        try {
            String sql = "select * from tb_funcionarios where nome =?";
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setString(1,nome);
            ResultSet rs = stmt.executeQuery();
            Funcionario obj = new Funcionario();
            if(rs.next()){
                obj.setId(rs.getInt("id"));
                obj.setNome(rs.getString("nome"));
                obj.setRg(rs.getString("rg"));
                obj.setCpf(rs.getString("cpf"));
                obj.setEmail(rs.getString("email"));
                
                obj.setSenha(rs.getString("Senha"));
                obj.setCargo(rs.getString("Cargo"));
                obj.setNivel(rs.getString("nivel"));
                
                
                
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
            JOptionPane.showMessageDialog(null,"erro ao buscar funcionarios" + erro);
        }
        return null;
        
       
    }
    
    public List<Funcionario> Listar(){
        List<Funcionario> lista = new ArrayList();
        try {
            String sql = "select * from tb_funcionarios";  
            PreparedStatement stmt = conn.prepareStatement(sql);
            ResultSet rs = stmt.executeQuery();
            while (rs.next()){
                
                Funcionario obj = new Funcionario();
                obj.setId(rs.getInt("id"));
                obj.setNome(rs.getString("nome"));
                obj.setRg(rs.getString("rg"));
                obj.setCpf(rs.getString("cpf")== null ?"": rs.getString("cpf"));
                obj.setEmail(rs.getString("email")== null ?"": rs.getString("email"));
                
                obj.setSenha(rs.getString("senha"));
                obj.setCargo(rs.getString("cargo"));
                obj.setNivel(rs.getString("nivel_acesso"));
                
                obj.setTelefone(rs.getString("telefone")== null ?"": rs.getString("telefone"));
                obj.setCelular(rs.getString("celular")== null ?"": rs.getString("celular"));
                obj.setCep(rs.getString("cep")== null ?"": rs.getString("cep"));
                
                
                obj.setEndereco(rs.getString("endereco"));
                obj.setNumero(rs.getInt("numero"));
                obj.setComplemento(rs.getString("complemento")== null ?"": rs.getString("complemento"));
                obj.setBairro(rs.getString("bairro")== null ?"": rs.getString("bairro"));
                obj.setCidade(rs.getString("cidade")== null ?"": rs.getString("cidade"));
                obj.setEstado(rs.getString("estado")== null ?"": rs.getString("estado"));
                
                
                lista.add(obj);
                
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null,"erro ao criar a listar de funcionario" + e);
        }
        return lista;
    }
        
    public List<Funcionario>Filtrar(String nome){
        List<Funcionario> lista = new ArrayList();
        try {
            String sql = "select * from tb_funcionarios where nome like ?";
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setString(1, nome);
            ResultSet rs = stmt.executeQuery();
            while (rs.next()){
                Funcionario obj = new Funcionario();
                obj.setId(rs.getInt("id"));
                obj.setNome(rs.getString("nome"));
                obj.setRg(rs.getString("rg"));
                obj.setCpf(rs.getString("cpf"));
               
                obj.setEmail(rs.getString("email"));
                obj.setSenha(rs.getString("senha"));
                obj.setCargo(rs.getString("cargo"));
                
                obj.setNivel(rs.getString("Nivel_acesso"));
                
                
                
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
    
    public Funcionario efetuarLogin(String nome, String senha) {

    try {
        String sql = "select * from tb_funcionarios where nome = ? and senha = ?";
        PreparedStatement stmt = conn.prepareStatement(sql);
        stmt.setString(1, nome);
        stmt.setString(2, senha);

        ResultSet rs = stmt.executeQuery();

        if (rs.next()) {
            Funcionario f = new Funcionario();
            f.setNome(rs.getString("nome"));
            f.setNivel(rs.getString("nivel_acesso"));
            return f;
        }
        return null;
        
    }catch (Exception e) {
        e.printStackTrace();
        return null;
    }
       
   
    
    }
    
}       
