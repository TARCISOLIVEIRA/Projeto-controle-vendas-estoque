 
package dao;

// caderno 12
import controledeestoque1.ConexaoBanco;
import java.sql.Connection;
import java.sql.PreparedStatement;
import javax.swing.JOptionPane;
import java.sql.SQLException;
import model.Clientes;
import model.MateriaPrima;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
public class MateriaPrimaDAO {
    
    private Connection conn;
    
    
    public MateriaPrimaDAO(){
        this.conn = new ConexaoBanco().pegarConexao();
    }
    
    public void Salvar(MateriaPrima prima){
        
        try {
            // 1 Criando o sql;
            String sql = "insert into tb_materias_primas (descricao,unidade_medida,estoque,estoque_minimo, valor_unitario)" 
                          + "values(?,?,?,?,?)";
            // preparação conexao sql com banco
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setString(1,prima.getDescricao());
            stmt.setString(2,prima.getUnidadeMedida());
            stmt.setDouble(3,prima.getEstoque());
            stmt.setDouble(4,prima.getEstoqueMinimo());
            stmt.setDouble(5,prima.getValorUnitario());
            stmt.execute();
             JOptionPane.showMessageDialog(null,"salvou no banco ");
            
            stmt.close();
            
        } catch (SQLException erro) {
            JOptionPane.showMessageDialog(null,"Erro ao salvar o Matéria"+ erro);
        }
    }
    
    
    
     public void Editar(MateriaPrima prima){
        
        try {
            // 1 Alterando clinetes o sql;
            String sql = "update tb_materias_primas set descricao=?, unidade_medida=?, "
                    + "estoque=?,estoque_minimo=?, valor_unitario=?"
                    + " where id=?";
            // preparação conexao sql com banco
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setString(1,prima.getDescricao());
            stmt.setString(2,prima.getUnidadeMedida());
            stmt.setDouble(3,prima.getEstoque());
            stmt.setDouble(4,prima.getEstoqueMinimo());
            stmt.setDouble(5,prima.getValorUnitario());
            stmt.setInt(6,prima.getId());
            stmt.execute();
            stmt.close();
            
            JOptionPane.showMessageDialog(null,"Materia prima Editado com sucesso.!");
                    
            
        } catch (SQLException erro) {
            JOptionPane.showMessageDialog(null,"Erro ao editar Materia prima"+ erro);
            
        }
    }
     
     public void Excluir(MateriaPrima obj){
         try {
             String sql="delete from tb_materias_primas where id=?";
             PreparedStatement stmt = conn.prepareStatement(sql);
             stmt.setInt(1, obj.getId());
             stmt.execute();
             stmt.close();
             
             JOptionPane.showMessageDialog(null,"cliente excluido");
             
                     
         } catch (SQLException e) {
             JOptionPane.showMessageDialog(null,"erro ao excluir"+e);
         }
     }
    
    public MateriaPrima BuscarMateriaPrima(String descricao){
        try {
            String sql = "select * from tb_materias_primas where descricao =?";
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setString(1,descricao);
            ResultSet rs = stmt.executeQuery();
            MateriaPrima obj = new MateriaPrima();
            if(rs.next()){
                obj.setId(rs.getInt("id"));
                obj.setDescricao(rs.getString("descricao"));
                obj.setUnidadeMedida(rs.getString("unidade_medida"));
                obj.setEstoque(rs.getDouble("estoque"));
                obj.setEstoqueMinimo(rs.getDouble("estoque_minimo"));
                obj.setValorUnitario(rs.getDouble("valor_unitario"));
            } 
            return obj;
        } catch (Exception erro) {
            JOptionPane.showMessageDialog(null,"erro ao buscar Materia Prima" + erro);
        }
        return null;
        
        // cap 14
    }
    
    
   public Clientes BuscarClienteNome(String nome){
       

    try {

        String sql = "select * from tb_clientes where nome like ?";

        PreparedStatement stmt = conn.prepareStatement(sql);

        stmt.setString(1, "%" +nome+ "%" );
        System.out.println("digita o nome "+ nome);

        ResultSet rs = stmt.executeQuery();
        System.out.println("foi salvo " + rs);

        Clientes obj = new Clientes();

        if(rs.next()){
            
            
            obj.setId(rs.getInt("id"));
          
            obj.setNome(rs.getString("nome"));
            obj.setCpf(rs.getString("cpf"));
        }

        return obj;

    } catch (Exception erro) {

        JOptionPane.showMessageDialog(null,
        "Erro ao buscar cliente");

    }

    return null;
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
    
    public List<MateriaPrima> Listar(){
        List<MateriaPrima> lista = new ArrayList();
        try {
            String sql = "select * from tb_materias_primas";
            PreparedStatement stmt = conn.prepareStatement(sql);
            ResultSet rs = stmt.executeQuery();
            while (rs.next()){
                MateriaPrima obj = new MateriaPrima();
                obj.setId(rs.getInt("id"));
                obj.setDescricao(rs.getString("descricao"));
                obj.setUnidadeMedida(rs.getString("unidade_medida"));
                obj.setEstoque(rs.getDouble("estoque"));
                obj.setEstoqueMinimo(rs.getDouble("estoque_minimo"));
                obj.setValorUnitario(rs.getDouble("valor_unitario"));
                lista.add(obj);
                
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null,"erro ao criar a listar");
        }
        return lista;
    }
        
    public List<MateriaPrima>Filtrar(String descricao){
        List<MateriaPrima> lista = new ArrayList();
        try {
            String sql = "select * from tb_materias_primas where descricao like ?";
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setString(1, descricao + "%");
            ResultSet rs = stmt.executeQuery();
            while (rs.next()){
                MateriaPrima obj = new MateriaPrima();
                obj.setId(rs.getInt("id"));
                obj.setDescricao(rs.getString("descricao"));
                obj.setUnidadeMedida(rs.getString("unidade_medida"));
                obj.setEstoque(rs.getDouble("estoque"));
                obj.setEstoqueMinimo(rs.getDouble("estoque_minimo"));
                obj.setValorUnitario(rs.getDouble("valor_unitario"));
                lista.add(obj);
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null,"erro ao filtrar");
        }
        return lista;
    }
    
    
   

        
    
}
