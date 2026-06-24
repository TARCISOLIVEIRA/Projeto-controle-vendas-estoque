
package dao;

import java.sql.Statement;
import controledeestoque1.ConexaoBanco;
import java.sql.Connection;
import javax.swing.JOptionPane;
import model.Vendas;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import model.Funcionario;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import model.Clientes;


public class VendasDAO {
    
     private Connection conn;
    
    
    public VendasDAO(){
        this.conn = new ConexaoBanco().pegarConexao();
    }
     
    public void Salvar(Vendas obj){
        
        try {
            
            
            
            String sql = "insert into tb_vendas (cliente_id, data_venda, total_venda, observacoes,numero_nota, funcionarios_id, forma_pagamento)"
                    + "values (?,?,?,?,?,?,? )";
             PreparedStatement stmt = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
             stmt.setInt(1,obj.getClientes().getId());
             stmt.setDate(2,new java.sql.Date(obj.getData_venda().getTime()));
             stmt.setDouble(3,obj.getTotal_venda());
             stmt.setString(4,obj.getObservacao());
             stmt. setInt(5,obj.getNumeroNota());
             stmt.setInt(6,obj.getFuncionario().getId());
             stmt. setString(7,obj.getForma_pagamento());
             stmt.executeUpdate();
             ResultSet rs = stmt.getGeneratedKeys();
             if(rs.next()) {
               obj.setId(rs.getInt(1));
             }
             stmt.close();
             JOptionPane.showMessageDialog(null,"Venda realizada Sucesso");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null,"erro em salvar vendas" + e.getMessage());
        }
        
    }
    
    
    
    public List<Object[]> vendasPorFuncionario() {
    List<Object[]> lista = new ArrayList<>();
    try {
        String sql =
        "SELECT f.nome, COUNT(v.id), SUM(v.total_venda) " +
        "FROM tb_vendas v " +
        "INNER JOIN tb_funcionarios f " +
        "ON v.funcionarios_id = f.id " +
        "GROUP BY f.nome";
        PreparedStatement stmt = conn.prepareStatement(sql);
        ResultSet rs = stmt.executeQuery();
        while(rs.next()) {
            lista.add(new Object[] {
                rs.getString(1),
                rs.getInt(2),
                rs.getDouble(3)
            });
        }
    } catch(Exception erro) {
        JOptionPane.showMessageDialog(null, erro);
    }
    return lista;
}

    
    
    
    public ResultSet formaPagamento() {

    try {
        String sql =
        "SELECT forma_pagamento, "
      + "COUNT(id) AS quantidade, "
      + "SUM(total_venda) AS total "
      + "FROM tb_vendas "
      + "GROUP BY forma_pagamento";

        PreparedStatement pst = conn.prepareStatement(sql);

        ResultSet rs = pst.executeQuery();

        return rs;

    } catch (Exception erro) {

        JOptionPane.showMessageDialog(null, erro);

    }

    return null;
}

    
    // falta envia daqui
    public double totalVendasDia() {

    double total = 0;

    try {

        String sql =
        "SELECT SUM(total_venda) AS total "
      + "FROM tb_vendas "
      + "WHERE DATE(data_venda) = CURDATE()";

        PreparedStatement pst = conn.prepareStatement(sql);

        ResultSet rs = pst.executeQuery();

        if(rs.next()) {

            total = rs.getDouble("total");

        }

    } catch (Exception erro) {

        JOptionPane.showMessageDialog(null, erro);

    }

    return total;
}

    
    
    
    public void atualizarNumeroNota(Vendas v) {
    try {
        String sql = "UPDATE tb_vendas SET numero_nota = ? WHERE id = ?";

        PreparedStatement stmt = conn.prepareStatement(sql);
        stmt.setInt(1, v.getNumeroNota());
        stmt.setInt(2, v.getId());

        stmt.executeUpdate();
        stmt.close();

    } catch (Exception e) {
        JOptionPane.showMessageDialog(null, "Erro ao atualizar número da nota: " + e.getMessage());
    }
}


public ResultSet vendasPorCliente(String nome) {
    try {
        String sql =
        "SELECT c.nome, v.data_venda, v.total_venda "
      + "FROM tb_vendas v "
      + "INNER JOIN tb_clientes c "
      + "ON v.cliente_id = c.id "
      + "WHERE c.nome LIKE ?";

        PreparedStatement pst = conn.prepareStatement(sql);

        pst.setString(1, nome + "%");

        ResultSet rs = pst.executeQuery();

        return rs;

    } catch (Exception erro) {

        JOptionPane.showMessageDialog(null, erro);

    }

    return null;
}


public ResultSet produtosMaisVendidos() {

    try {

        String sql =
        "SELECT p.descricao, " +
        "SUM(iv.qtd) AS quantidade, " +
        "SUM(iv.subtotal) AS total " +
        "FROM tb_itensvendas iv " +
        "INNER JOIN tb_produtos p " +
        "ON iv.produto_id = p.id " +
        "GROUP BY p.descricao " +
        "ORDER BY quantidade DESC";

        PreparedStatement pst = conn.prepareStatement(sql);

        ResultSet rs = pst.executeQuery();

        return rs;

    } catch (Exception erro) {

        JOptionPane.showMessageDialog(null, erro);

    }

    return null;
}



    
 public double totalVendasPeriodo(String inicio, String fim) {

    double total = 0;

    try {

        String sql =
        "SELECT SUM(total_venda) AS total "
      + "FROM tb_vendas "
      + "WHERE data_venda BETWEEN ? AND ?";

        PreparedStatement pst = conn.prepareStatement(sql);

        pst.setString(1, inicio);
        pst.setString(2, fim);

        ResultSet rs = pst.executeQuery();

        if(rs.next()) {

            total = rs.getDouble("total");

        }

    } catch (Exception erro) {

        JOptionPane.showMessageDialog(null, erro);

    }

    return total;
}

    
    
    
    public int retornarUltimoIdVenda(){
        try {
            int ultimoId = 0;
            String sql = "select max(id) id from tb_vendas";
            PreparedStatement stmt = conn.prepareStatement(sql);
            ResultSet rs = stmt.executeQuery();
            
          if(rs.next()){
              int id = rs.getInt("id");
          
            
          if(rs.wasNull()){
              return -1;
          }
          
          return id;
        }
        return -1;
          
          
        } catch (Exception e) {
            throw new RuntimeException("erro ao retorna o ultimo ");
        }
        }
    
    
    
    
    
    public List<Vendas>historicoVendas(Date data_inicio, Date data_fim){
        try {
            List<Vendas>lista = new ArrayList<>();
          String sql = "select v.id, "
        + "c.nome as cliente, "
        + "f.nome as funcionario, "
        + "v.data_venda, "
        + "v.total_venda, "
        + "v.observacoes "
        + "from tb_vendas as v "
        + "inner join tb_clientes as c on (v.cliente_id = c.id) "
        + "inner join tb_funcionarios as f on (v.funcionarios_id = f.id) "
        + "where v.data_venda between ? and ?";
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setDate(1,new java.sql.Date(data_inicio.getTime()));
            stmt.setDate(2, new java.sql.Date(data_fim.getTime()));
            ResultSet rs = stmt.executeQuery();
            while(rs.next()){
                Vendas v = new Vendas();
                Clientes c = new Clientes();
                Funcionario f = new Funcionario();
                c.setNome(rs.getString("cliente"));
                f.setNome(rs.getString("funcionario"));
                v.setClientes(c);
               v.setFuncionario(f);
                v.setId(rs.getInt("id"));
                Date d = rs.getDate("data_venda");
                v.setData_venda(d);
                v.setTotal_venda(rs.getDouble("total_venda"));
                //c.setNome(rs.getString("cliente"));
                //v.setClientes(c);
                v.setObservacao(rs.getString("observacoes") == null ? "" : rs.getString("observacoes"));
                lista.add(v);
            }
           
            return lista;
            
        } catch (SQLException e) {
            throw new RuntimeException(" erro ao criar historico de vendas " + e.getMessage());
        }
        
    }
    
    public double posicaoDodia(java.sql.Date  data_venda){
        
            double total_do_dia=0;
            String sql ="select ifnull(sum(total_venda),0) as total from tb_vendas where data_venda= ?";
            
            
       try{
                
                PreparedStatement stmt = conn.prepareStatement(sql);
                stmt.setDate(1, data_venda);
                ResultSet rs = stmt.executeQuery();
               
                if(rs.next()){
                    total_do_dia = rs.getDouble("total");
                 
                }
               
                    
                }catch( SQLException e){
                        throw new RuntimeException("erro ao retornar"+ e.getMessage());
                        }
        return total_do_dia;
                        }
                
                
}
  
    

