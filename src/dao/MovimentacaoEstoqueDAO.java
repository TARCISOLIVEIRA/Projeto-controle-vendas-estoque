
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
import model.MovimentacaoEstoque;
public class MovimentacaoEstoqueDAO {
    
    private Connection conn;
    
    
    public MovimentacaoEstoqueDAO(){
        this.conn = new ConexaoBanco().pegarConexao();
    }
    
    public void Salvar(MovimentacaoEstoque obj){
        
        try {
            // 1 Criando o sql;
            String sql = "insert into tb_movimentacoes_estoque (materia_prima_id,tipo,qtd,data_movimentacao)" 
                          + "values(?,?,?,?)";
            // preparação conexao sql com banco
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setInt(1,obj.getMateriaPrimaId());
            stmt.setString(2,obj.getTipo());
            stmt.setDouble(3,obj.getQtd());
            stmt.setTimestamp(4, new java.sql.Timestamp(obj.getDataMovimentacao().getTime()));
            stmt.execute();
             JOptionPane.showMessageDialog(null,"salvou o movimento de estoque ");
            stmt.close();
            
        } catch (SQLException erro) {
            JOptionPane.showMessageDialog(null,"Erro ao salvar o Movimento de estoque"+ erro);
        }
    }
     public void Editar(MovimentacaoEstoque estoque){
        
        try {
            // 1 Alterando clinetes o sql;
            String sql = "update tb_movimentacoes_estoque set materia_prima_id=?, tipo=?, "
                    + "qtd=?,data_movimentacao=?"
                    + " where id =?";
            // preparação conexao sql com banco
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setInt(1,estoque.getMateriaPrimaId());
            stmt.setString(2,estoque.getTipo());
            stmt.setDouble(3,estoque.getQtd());
            stmt.setTimestamp(4,new java.sql.Timestamp(estoque.getDataMovimentacao().getTime()));
            stmt.setInt(5,estoque.getId());
            stmt.execute();
            stmt.close();
            
            JOptionPane.showMessageDialog(null,"Movimento de estoque Editado com sucesso.!");
                    
            
        } catch (SQLException erro) {
            JOptionPane.showMessageDialog(null,"Erro ao editar movimento de estoque"+ erro);
            
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
    
  /*  public MovimentacaoEstoque BuscarMovimentacaoEstoque(String descricao){
        try {
            String sql = "select * from tb_movimentacoes_estoque where materia_prima =?";
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setString(1,materia_prima);
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
    }  */
    
    
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

  
   public ResultSet materiasPrimasMovimentadasPeriodo(Date dataInicial, Date dataFinal) {

    try {

        String sql =
        "SELECT "
         + "mp.id, " +
        "mp.descricao, " +
        "SUM(me.qtd) AS quantidade, " +
        "SUM(me.qtd * mp.valor_unitario) AS total " +
        "FROM tb_movimentacoes_estoque me " +
        "INNER JOIN tb_materias_primas mp " +
        "ON me.materia_prima_id = mp.id " +
        "WHERE me.data_movimentacao BETWEEN ? AND ? " +
        "GROUP BY mp.id, mp.descricao " +
        "ORDER BY quantidade DESC";

        PreparedStatement pst = conn.prepareStatement(sql);

        pst.setDate(1, new java.sql.Date(dataInicial.getTime()));
        pst.setDate(2, new java.sql.Date(dataFinal.getTime()));

        return pst.executeQuery();

    } catch (Exception erro) {
        JOptionPane.showMessageDialog(null, erro);
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
    
    public List<MovimentacaoEstoque> Listar(){
        List<MovimentacaoEstoque> lista = new ArrayList();
        try {
            String sql =
"SELECT m.id, m.materia_prima_id, mp.descricao, m.tipo, m.qtd, m.data_movimentacao " +
"FROM tb_movimentacoes_estoque m " +
"INNER JOIN tb_materias_primas mp "
                    + "ON m.materia_prima_id = mp.id";
            PreparedStatement stmt = conn.prepareStatement(sql);
            ResultSet rs = stmt.executeQuery();
            while (rs.next()){
                String descricao = rs.getString("descricao");
                
                MovimentacaoEstoque obj = new MovimentacaoEstoque();
                obj.setId(rs.getInt("id"));
                obj.setMateriaPrimaId(rs.getInt("materia_prima_id"));
                obj.setTipo(rs.getString("tipo"));
                obj.setDescricao(rs.getString("descricao"));
                obj.setQtd(rs.getDouble("qtd"));
                
                obj.setDataMovimentacao(rs.getTimestamp("data_movimentacao"));
                lista.add(obj);
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
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
