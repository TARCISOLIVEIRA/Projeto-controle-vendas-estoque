/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package view;

import dao.MateriaPrimaDAO;
import dao.MovimentacaoEstoqueDAO;
import java.text.SimpleDateFormat;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import model.MateriaPrima;
import model.MovimentacaoEstoque;
import model.Produto;
import utilitario.Utilitarios;

/**
 *
 * @author Tarciso
 */
public class FormularioMovimentacaoEstoque extends javax.swing.JFrame {
    
    

    /**
     * Creates new form FormularioMovimentacaoEstoque
     */
    public FormularioMovimentacaoEstoque() {
        initComponents();
        carregarMateriaPrima();
        listar();
    }

    
    public void carregarMateriaPrima(){
        
        MateriaPrimaDAO dao = new MateriaPrimaDAO();
        try{
        for(MateriaPrima mp : dao.Listar()){
            cbmMateria.addItem(mp.getDescricao());
        }
    } catch(Exception e){
        JOptionPane.showMessageDialog(null, "Erro ao carregar mateir a prima"+ e);
         
     
          }   
        
    }  
    
    
    public void listar(){
        MovimentacaoEstoqueDAO dao = new MovimentacaoEstoqueDAO();
        
        DefaultTableModel dados = (DefaultTableModel)tabelaMovimentacao.getModel();
       dados.setNumRows(0);
       List<MovimentacaoEstoque>lista = dao.Listar();
       for(MovimentacaoEstoque obj : lista){
           dados.addRow(new Object[]{
           obj.getId(),
           obj.getDescricao(),
           obj.getTipo(),   
           obj.getQtd(),
           obj.getDataMovimentacao(),
           
          
          
       
           
       });
       }
        
        
        
    }
    
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        cbmMateria = new javax.swing.JComboBox<>();
        jLabel3 = new javax.swing.JLabel();
        cbmTipo = new javax.swing.JComboBox<>();
        jLabel4 = new javax.swing.JLabel();
        txtQuantidade = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        btnLimpar = new javax.swing.JButton();
        btnSalvar = new javax.swing.JButton();
        btnEditar = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tabelaMovimentacao = new javax.swing.JTable();
        txtData = new javax.swing.JFormattedTextField();
        jLabel6 = new javax.swing.JLabel();
        txtId = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setMaximumSize(new java.awt.Dimension(50, 20));
        setPreferredSize(new java.awt.Dimension(200, 30));
        getContentPane().setLayout(null);

        jLabel1.setFont(new java.awt.Font("Dialog", 1, 48)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Movimentação de Estoque");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 920, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(65, 65, 65))
        );

        getContentPane().add(jPanel1);
        jPanel1.setBounds(0, 2, 920, 120);

        jLabel2.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabel2.setText("Materia Prima");
        getContentPane().add(jLabel2);
        jLabel2.setBounds(10, 180, 140, 30);

        getContentPane().add(cbmMateria);
        cbmMateria.setBounds(160, 180, 190, 30);

        jLabel3.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabel3.setText("Tipo");
        getContentPane().add(jLabel3);
        jLabel3.setBounds(410, 190, 60, 19);

        cbmTipo.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        cbmTipo.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Entrada", "Saida" }));
        getContentPane().add(cbmTipo);
        cbmTipo.setBounds(540, 180, 190, 30);

        jLabel4.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabel4.setText("Quantidade");
        getContentPane().add(jLabel4);
        jLabel4.setBounds(10, 230, 120, 19);
        getContentPane().add(txtQuantidade);
        txtQuantidade.setBounds(140, 230, 190, 30);

        jLabel5.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabel5.setText("Data ");
        getContentPane().add(jLabel5);
        jLabel5.setBounds(410, 240, 60, 19);

        btnLimpar.setFont(new java.awt.Font("Dialog", 1, 12)); // NOI18N
        btnLimpar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagem/imgs/novo.png"))); // NOI18N
        btnLimpar.setText("Novo");
        btnLimpar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLimparActionPerformed(evt);
            }
        });
        getContentPane().add(btnLimpar);
        btnLimpar.setBounds(66, 305, 100, 42);

        btnSalvar.setFont(new java.awt.Font("Dialog", 1, 12)); // NOI18N
        btnSalvar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagem/imgs/salvar.png"))); // NOI18N
        btnSalvar.setText("Salvar");
        btnSalvar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSalvarActionPerformed(evt);
            }
        });
        getContentPane().add(btnSalvar);
        btnSalvar.setBounds(190, 310, 130, 40);

        btnEditar.setFont(new java.awt.Font("Dialog", 1, 12)); // NOI18N
        btnEditar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagem/imgs/editar.png"))); // NOI18N
        btnEditar.setText("Editar");
        btnEditar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEditarActionPerformed(evt);
            }
        });
        getContentPane().add(btnEditar);
        btnEditar.setBounds(350, 310, 110, 40);

        jButton4.setFont(new java.awt.Font("Dialog", 1, 12)); // NOI18N
        jButton4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagem/imgs/excluir.png"))); // NOI18N
        jButton4.setText("Excluir");
        getContentPane().add(jButton4);
        jButton4.setBounds(480, 310, 120, 40);

        tabelaMovimentacao.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "Id", "Materia Prima", "Tipo", "Quantidade", "Data"
            }
        ));
        tabelaMovimentacao.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tabelaMovimentacaoMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tabelaMovimentacao);

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 918, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 228, Short.MAX_VALUE))
        );

        getContentPane().add(jPanel2);
        jPanel2.setBounds(0, 360, 890, 240);

        try {
            txtData.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("##/##/####")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        getContentPane().add(txtData);
        txtData.setBounds(540, 230, 180, 40);

        jLabel6.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabel6.setText("Codigo");
        getContentPane().add(jLabel6);
        jLabel6.setBounds(20, 140, 58, 19);

        txtId.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtIdActionPerformed(evt);
            }
        });
        getContentPane().add(txtId);
        txtId.setBounds(150, 130, 139, 33);

        setSize(new java.awt.Dimension(938, 651));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btnSalvarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSalvarActionPerformed
    try {
        MovimentacaoEstoque obj = new MovimentacaoEstoque();
        if(cbmMateria.getSelectedItem()== null){
            JOptionPane.showMessageDialog(this, "Selecione uma materia prima");
            return;
        }       
        MateriaPrimaDAO mpdao = new MateriaPrimaDAO();
        MateriaPrima mp = mpdao.BuscarMateriaPrima(cbmMateria.getSelectedItem().toString());
        obj.setMateriaPrimaId(mp.getId());
        obj.setTipo(cbmTipo.getSelectedItem().toString());
        obj.setQtd(Double.parseDouble(txtQuantidade.getText().replace(",", "."))
        );
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        obj.setDataMovimentacao(sdf.parse(txtData.getText()));
        // se ja foi cadastrada
        MovimentacaoEstoqueDAO dao = new MovimentacaoEstoqueDAO();
        System.out.println(cbmMateria.getSelectedItem());
        System.out.println(mp.getId());
        dao.Salvar(obj);
        
        JOptionPane.showMessageDialog(null,"Movimentação salva com sucesso !");
        cbmMateria.setSelectedItem(0);
        cbmTipo.setSelectedItem(0);
        txtQuantidade.setText("");
        txtData.setText("");
   
    } catch (Exception e) {

        JOptionPane.showMessageDialog(null,
                "Erro ao salvar: " + e.getMessage());
    }

        
   
        
             
        
        
    }//GEN-LAST:event_btnSalvarActionPerformed

    private void btnLimparActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLimparActionPerformed
        // TODO add your handling code here:
        
        cbmMateria.setSelectedItem(0);
        cbmTipo.setSelectedItem(0);
        txtQuantidade.setText("");
        txtData.setText("");
        
        txtQuantidade.requestFocus();
        
        
        
        
        
        
        
    }//GEN-LAST:event_btnLimparActionPerformed

    private void tabelaMovimentacaoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tabelaMovimentacaoMouseClicked
        // TODO add your handling code here:
    int linha = tabelaMovimentacao.getSelectedRow();

    txtId.setText(tabelaMovimentacao.getValueAt(linha, 0).toString());
    cbmMateria.setSelectedItem(tabelaMovimentacao.getValueAt(linha, 1).toString());
    cbmTipo.setSelectedItem(tabelaMovimentacao.getValueAt(linha, 2).toString());
    txtQuantidade.setText(tabelaMovimentacao.getValueAt(linha, 3).toString());
    java.sql.Timestamp data = (java.sql.Timestamp)tabelaMovimentacao.getValueAt(linha, 4);
    txtData.setText(new java.text.SimpleDateFormat("dd/MM/yyyy").format(data));

        
        
    }//GEN-LAST:event_tabelaMovimentacaoMouseClicked

    private void btnEditarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEditarActionPerformed
    try {
        MovimentacaoEstoque obj = new MovimentacaoEstoque();
        obj.setId(Integer.parseInt(txtId.getText()));
        obj.setMateriaPrimaId(cbmMateria.getSelectedIndex()+1);
        obj.setTipo(cbmTipo.getSelectedItem().toString());
        obj.setQtd(Double.parseDouble(txtQuantidade.getText()));
        
        String dataTexto = txtData.getText().replace(".0","");
        java.text.SimpleDateFormat sdf = new java.text.SimpleDateFormat("dd/MM/yyyy");
        obj.setDataMovimentacao(sdf.parse(txtData.getText()));
        
        MovimentacaoEstoqueDAO dao = new MovimentacaoEstoqueDAO() ;
        dao.Editar(obj);
        Utilitarios util = new Utilitarios();
        util.LimpaTela(jPanel2);
        JOptionPane.showMessageDialog(null, "Estoque atualizado com sucesso!");

    } catch (Exception e) {
        
        JOptionPane.showMessageDialog(null, "Erro ao editar: " + e.getMessage());
    }
        
        
        
    }//GEN-LAST:event_btnEditarActionPerformed

    private void txtIdActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtIdActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtIdActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(FormularioMovimentacaoEstoque.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FormularioMovimentacaoEstoque.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FormularioMovimentacaoEstoque.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FormularioMovimentacaoEstoque.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new FormularioMovimentacaoEstoque().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnEditar;
    private javax.swing.JButton btnLimpar;
    private javax.swing.JButton btnSalvar;
    private javax.swing.JComboBox<String> cbmMateria;
    private javax.swing.JComboBox<String> cbmTipo;
    private javax.swing.JButton jButton4;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tabelaMovimentacao;
    private javax.swing.JFormattedTextField txtData;
    private javax.swing.JTextField txtId;
    private javax.swing.JTextField txtQuantidade;
    // End of variables declaration//GEN-END:variables
}
