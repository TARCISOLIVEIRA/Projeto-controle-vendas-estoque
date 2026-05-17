
package view;

import javax.swing.JOptionPane;


public class FormularioDetalheVenda extends javax.swing.JFrame {

    
    public FormularioDetalheVenda() {
        initComponents();
    }

    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        txtIdVenda = new javax.swing.JTextField();
        txtCliente = new javax.swing.JTextField();
        txtDataVenda = new javax.swing.JFormattedTextField();
        txtTotalVenda = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        txtObs = new javax.swing.JTextArea();
        jScrollPane3 = new javax.swing.JScrollPane();
        carrinho = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Detalhe da venda");
        setResizable(false);
        getContentPane().setLayout(null);

        jLabel2.setText("Id da venda");
        getContentPane().add(jLabel2);
        jLabel2.setBounds(20, 120, 56, 15);

        jLabel3.setText("total da venda");
        getContentPane().add(jLabel3);
        jLabel3.setBounds(240, 120, 80, 15);

        jLabel4.setText("observacoes:");
        getContentPane().add(jLabel4);
        jLabel4.setBounds(260, 160, 100, 15);

        jLabel5.setText("Cliente:");
        getContentPane().add(jLabel5);
        jLabel5.setBounds(20, 160, 70, 15);

        jLabel6.setText("data da venda:");
        getContentPane().add(jLabel6);
        jLabel6.setBounds(20, 200, 90, 15);

        txtIdVenda.setEnabled(false);
        txtIdVenda.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtIdVendaActionPerformed(evt);
            }
        });
        getContentPane().add(txtIdVenda);
        txtIdVenda.setBounds(110, 109, 100, 30);

        txtCliente.setEnabled(false);
        getContentPane().add(txtCliente);
        txtCliente.setBounds(110, 160, 100, 30);

        try {
            txtDataVenda.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("##/##20##")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        txtDataVenda.setEnabled(false);
        getContentPane().add(txtDataVenda);
        txtDataVenda.setBounds(100, 200, 120, 30);

        txtTotalVenda.setEnabled(false);
        getContentPane().add(txtTotalVenda);
        txtTotalVenda.setBounds(350, 109, 220, 30);

        txtObs.setColumns(20);
        txtObs.setRows(5);
        txtObs.setEnabled(false);
        jScrollPane1.setViewportView(txtObs);

        getContentPane().add(jScrollPane1);
        jScrollPane1.setBounds(370, 150, 200, 110);

        carrinho.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "codigo", "produto", "qtd", "preco", "subtotal"
            }
        ));
        carrinho.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                carrinhoMouseClicked(evt);
            }
        });
        jScrollPane3.setViewportView(carrinho);

        getContentPane().add(jScrollPane3);
        jScrollPane3.setBounds(0, 273, 610, 170);

        jLabel1.setBackground(new java.awt.Color(255, 255, 255));
        jLabel1.setFont(new java.awt.Font("Dialog", 1, 24)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("DETALHE DE VENDAS");
        getContentPane().add(jLabel1);
        jLabel1.setBounds(0, 10, 610, 80);

        setBounds(0, 0, 622, 473);
    }// </editor-fold>//GEN-END:initComponents

    private void carrinhoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_carrinhoMouseClicked
    FormularioDetalheVenda fdv = new FormularioDetalheVenda();
    fdv.txtIdVenda.setText(carrinho.getValueAt(carrinho.getSelectedRow(),0).toString());
    fdv.txtCliente.setText(carrinho.getValueAt(carrinho.getSelectedRow(),1).toString());
    fdv.txtDataVenda.setText(carrinho.getValueAt(carrinho.getSelectedRow(),2).toString());
    fdv.txtTotalVenda.setText(carrinho.getValueAt(carrinho.getSelectedRow(),3).toString());
    fdv.txtObs.setText(carrinho.getValueAt(carrinho.getSelectedRow(),4).toString());

        
    
        
        
        
               
        
    }//GEN-LAST:event_carrinhoMouseClicked

    private void txtIdVendaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtIdVendaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtIdVendaActionPerformed

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
            java.util.logging.Logger.getLogger(FormularioDetalheVenda.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FormularioDetalheVenda.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FormularioDetalheVenda.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FormularioDetalheVenda.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new FormularioDetalheVenda().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    public javax.swing.JTable carrinho;
    public javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane3;
    public javax.swing.JTextField txtCliente;
    public javax.swing.JFormattedTextField txtDataVenda;
    public javax.swing.JTextField txtIdVenda;
    public javax.swing.JTextArea txtObs;
    public javax.swing.JTextField txtTotalVenda;
    // End of variables declaration//GEN-END:variables
}
