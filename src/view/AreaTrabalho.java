
package view;

import controledeestoque1.ConexaoBanco;
import java.awt.Graphics;
import java.awt.Image;
import java.io.InputStream;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import model.Clientes;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.view.JasperViewer;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.PreparedStatement;
import dao.FuncionarioDAO;
import model.Funcionario;


public class AreaTrabalho extends javax.swing.JFrame{
 
    public String usuarioLogado;
    private Funcionario func;
    
    public AreaTrabalho(Funcionario f) {
        initComponents();
        this.func = f;
        lblLogado.setText("bem-vindo    " + f.getNome());
       
        aplicarPermissoes();
         alertaEstoqueTrigger();
        
       //  verificarEstoque();
        
        // verificarEstoque();
    }
    
   
     private Connection conn;
    
    
    private void verificarEstoque() {
    StringBuilder mensagem = new StringBuilder();
       
    
    
    try (Connection conn = new ConexaoBanco().pegarConexao();
         PreparedStatement stmt = conn.prepareStatement(
             "SELECT descricao FROM tb_produtos WHERE qtd_estoque = 0");
         ResultSet rs = stmt.executeQuery()) {

        while (rs.next()) {
            mensagem.append(rs.getString("descricao")).append("\n");
        }

        if (mensagem.length() > 0) {
            JOptionPane.showMessageDialog(null,
                "Produtos sem estoque:\n" + mensagem.toString());
        }

    } catch (Exception e) {
       JOptionPane.showMessageDialog(null, "Erro" + e.getMessage());
    }
}
    
    
    private void alertaEstoqueTrigger() {
    StringBuilder mensagem = new StringBuilder();

    try (Connection com = new ConexaoBanco().pegarConexao();
         PreparedStatement stmt = com.prepareStatement(
             "SELECT descricao FROM tb_alerta_estoque");
         ResultSet rs = stmt.executeQuery()) {

        while (rs.next()) {
            mensagem.append(rs.getString("descricao")).append("\n");
        }

        if (mensagem.length() > 0) {
            JOptionPane.showMessageDialog(null,
                "⚠ Produtos com estoque zerado:\n" + mensagem.toString());
             //  com.prepareStatement("DELETE from tb_alerta_estoque").executeUpdate();
        }

    } catch (Exception e) {
        JOptionPane.showMessageDialog(null, "Erro: " + e.getMessage());
    }
}


    
    
    
    private void aplicarPermissoes() {

    String nivel = func.getNivel();

    System.out.println("Nível: " + nivel); // pra testar

    if (nivel.equalsIgnoreCase("ADM")) {
        menu_funcionario.setEnabled(false);
    }

    else if (nivel.equalsIgnoreCase("Gerente")) {
        // exemplo: gerente não mexe em funcionários
       // btnFuncionarios.setEnabled(false);
    }

    else if (nivel.equalsIgnoreCase("Funcionario")) {

        menu_funcionario.setEnabled(true);
       // btnFornecedores.setEnabled(false);
      //  btnRelatorios.setEnabled(false);
       // btnConfiguracoes.setEnabled(false);
    }
}

    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jMenuBar2 = new javax.swing.JMenuBar();
        jMenu4 = new javax.swing.JMenu();
        jMenu9 = new javax.swing.JMenu();
        jMenuBar3 = new javax.swing.JMenuBar();
        jMenu10 = new javax.swing.JMenu();
        jMenu11 = new javax.swing.JMenu();
        jMenuItem12 = new javax.swing.JMenuItem();
        ImageIcon icon = new ImageIcon(getClass().getResource("/imgFundo/pordosol.jpg"));
        Image image = icon.getImage();
        painel_Desktop = new javax.swing.JDesktopPane(){
            public void paintComponent(Graphics g){
                g.drawImage(image,0,0,getWidth(),getHeight(),this);

            }
        };
        jPanel1 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        lblusuarioLogado = new javax.swing.JLabel();
        lblLogado = new javax.swing.JLabel();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        MenuClientes = new javax.swing.JMenuItem();
        jMenu2 = new javax.swing.JMenu();
        menu_funcionario = new javax.swing.JMenuItem();
        jMenu3 = new javax.swing.JMenu();
        menu_fornecedores = new javax.swing.JMenuItem();
        Meus_Produtos = new javax.swing.JMenu();
        menuSubProdutos = new javax.swing.JMenu();
        menu_estoque = new javax.swing.JMenuItem();
        menusubMenuconsulta = new javax.swing.JMenuItem();
        menuSubMenuFormularioProduto = new javax.swing.JMenuItem();
        menuHistoricoVenda = new javax.swing.JMenu();
        menuAbrirPdv = new javax.swing.JMenuItem();
        menuPosicaoDoDia = new javax.swing.JMenuItem();
        jMenuItem8 = new javax.swing.JMenuItem();
        menuTrocaUsuario = new javax.swing.JMenu();
        jMenuItem9 = new javax.swing.JMenuItem();
        jMenu12 = new javax.swing.JMenu();
        Produtos = new javax.swing.JMenuItem();
        jMenuItem4 = new javax.swing.JMenuItem();
        jMenuItem13 = new javax.swing.JMenuItem();
        jMenu7 = new javax.swing.JMenu();
        jMenuItem10 = new javax.swing.JMenuItem();

        jMenu4.setText("File");
        jMenuBar2.add(jMenu4);

        jMenu9.setText("Edit");
        jMenuBar2.add(jMenu9);

        jMenu10.setText("File");
        jMenuBar3.add(jMenu10);

        jMenu11.setText("Edit");
        jMenuBar3.add(jMenu11);

        jMenuItem12.setText("jMenuItem12");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowActivated(java.awt.event.WindowEvent evt) {
                formWindowActivated(evt);
            }
        });

        jPanel1.setBackground(new java.awt.Color(255, 204, 102));
        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder("Logado"));
        jPanel1.setForeground(new java.awt.Color(0, 0, 0));
        jPanel1.setFont(new java.awt.Font("Dialog", 1, 11)); // NOI18N

        jLabel3.setForeground(new java.awt.Color(0, 0, 0));
        jLabel3.setText("Nome do responsável:");

        lblusuarioLogado.setBackground(new java.awt.Color(0, 0, 0));
        lblusuarioLogado.setForeground(new java.awt.Color(0, 0, 0));

        lblLogado.setForeground(new java.awt.Color(51, 0, 51));

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 143, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(221, 221, 221)
                .addComponent(lblLogado, javax.swing.GroupLayout.PREFERRED_SIZE, 285, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblusuarioLogado, javax.swing.GroupLayout.PREFERRED_SIZE, 131, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(84, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(lblLogado)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel3)
                        .addContainerGap(45, Short.MAX_VALUE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(lblusuarioLogado, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(21, 21, 21))))
        );

        painel_Desktop.setLayer(jPanel1, javax.swing.JLayeredPane.DEFAULT_LAYER);

        javax.swing.GroupLayout painel_DesktopLayout = new javax.swing.GroupLayout(painel_Desktop);
        painel_Desktop.setLayout(painel_DesktopLayout);
        painel_DesktopLayout.setHorizontalGroup(
            painel_DesktopLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        painel_DesktopLayout.setVerticalGroup(
            painel_DesktopLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, painel_DesktopLayout.createSequentialGroup()
                .addContainerGap(386, Short.MAX_VALUE)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(2, 2, 2))
        );

        jMenu1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagem/imgs/clientes.png"))); // NOI18N
        jMenu1.setText("Clientes");

        MenuClientes.setText("Formulario Clientes");
        MenuClientes.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                MenuClientesActionPerformed(evt);
            }
        });
        jMenu1.add(MenuClientes);

        jMenuBar1.add(jMenu1);

        jMenu2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagem/imgs/funcionarios.png"))); // NOI18N
        jMenu2.setText("Funcionarios");

        menu_funcionario.setText("Formularios Funcionarios");
        menu_funcionario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menu_funcionarioActionPerformed(evt);
            }
        });
        jMenu2.add(menu_funcionario);

        jMenuBar1.add(jMenu2);

        jMenu3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagem/imgs/fornecedores_1.png"))); // NOI18N
        jMenu3.setText("Fornecedores");

        menu_fornecedores.setText("Formulario Fornecedores");
        menu_fornecedores.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menu_fornecedoresActionPerformed(evt);
            }
        });
        jMenu3.add(menu_fornecedores);

        jMenuBar1.add(jMenu3);

        Meus_Produtos.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagem/imgs/produtos.png"))); // NOI18N
        Meus_Produtos.setText("Produtos");

        menuSubProdutos.setText("meus Produtos");

        menu_estoque.setText("Controle de Estoque");
        menu_estoque.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menu_estoqueActionPerformed(evt);
            }
        });
        menuSubProdutos.add(menu_estoque);

        menusubMenuconsulta.setText("consulta de produto");
        menusubMenuconsulta.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menusubMenuconsultaActionPerformed(evt);
            }
        });
        menuSubProdutos.add(menusubMenuconsulta);

        menuSubMenuFormularioProduto.setText("Formulário de Produto");
        menuSubMenuFormularioProduto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuSubMenuFormularioProdutoActionPerformed(evt);
            }
        });
        menuSubProdutos.add(menuSubMenuFormularioProduto);

        Meus_Produtos.add(menuSubProdutos);

        jMenuBar1.add(Meus_Produtos);

        menuHistoricoVenda.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagem/imgs/vendas_1.png"))); // NOI18N
        menuHistoricoVenda.setText("Vendas");

        menuAbrirPdv.setText("abri PDV");
        menuAbrirPdv.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuAbrirPdvActionPerformed(evt);
            }
        });
        menuHistoricoVenda.add(menuAbrirPdv);

        menuPosicaoDoDia.setText("posição do dia");
        menuPosicaoDoDia.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuPosicaoDoDiaActionPerformed(evt);
            }
        });
        menuHistoricoVenda.add(menuPosicaoDoDia);

        jMenuItem8.setText("historico de vendas");
        jMenuItem8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem8ActionPerformed(evt);
            }
        });
        menuHistoricoVenda.add(jMenuItem8);

        jMenuBar1.add(menuHistoricoVenda);

        menuTrocaUsuario.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagem/imgs/configuracoes.png"))); // NOI18N
        menuTrocaUsuario.setText("Configurações");

        jMenuItem9.setText("troca de usuario");
        jMenuItem9.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem9ActionPerformed(evt);
            }
        });
        menuTrocaUsuario.add(jMenuItem9);

        jMenuBar1.add(menuTrocaUsuario);

        jMenu12.setIcon(new javax.swing.ImageIcon("C:\\Users\\Tarciso\\OneDrive\\Desktop\\Teste - Copia\\ControleDeEstoque1\\src\\imagem\\imgs\\printer.png")); // NOI18N
        jMenu12.setText("Relatórios");

        Produtos.setText("Produtos");
        Produtos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ProdutosActionPerformed(evt);
            }
        });
        jMenu12.add(Produtos);

        jMenuItem4.setText("Clientes");
        jMenuItem4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem4ActionPerformed(evt);
            }
        });
        jMenu12.add(jMenuItem4);

        jMenuItem13.setText("Funcionarios");
        jMenu12.add(jMenuItem13);

        jMenuBar1.add(jMenu12);

        jMenu7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagem/imgs/sair.png"))); // NOI18N
        jMenu7.setText("Sair");

        jMenuItem10.setText("sair do sistema");
        jMenuItem10.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem10ActionPerformed(evt);
            }
        });
        jMenu7.add(jMenuItem10);

        jMenuBar1.add(jMenu7);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(painel_Desktop)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(painel_Desktop)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void MenuClientesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_MenuClientesActionPerformed
        // TODO add your handling code here:
        
       FormularioCliente fc = new FormularioCliente();   // parentese (trhis,true)
       
       
       
       //fc.setModal(rootPaneCheckingEnabled);
       fc.setVisible(true);
       
        
        
    }//GEN-LAST:event_MenuClientesActionPerformed

    private void jMenuItem9ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem9ActionPerformed
        // TODO add your handling code here:
        
        FormularioLogin login = new FormularioLogin();
        this.dispose();
        login.setVisible(true);
        
        
        
    }//GEN-LAST:event_jMenuItem9ActionPerformed

    private void jMenuItem10ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem10ActionPerformed
        // TODO add your handling code here:
        
        
        int janela = JOptionPane.showConfirmDialog(null, "Tem Certeza que deseja sair");
        if(janela == 0){
            System.exit(0);
        }else if (janela == 2){
            JOptionPane.showMessageDialog(null,"cancelando....");
        }
        
    }//GEN-LAST:event_jMenuItem10ActionPerformed

    private void formWindowActivated(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowActivated
        // TODO add your handling code here:
        this.setExtendedState(this.MAXIMIZED_BOTH);
        //lblLogado.setText(usuarioLogado);
        
        
        
    }//GEN-LAST:event_formWindowActivated

    private void menu_funcionarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menu_funcionarioActionPerformed
        // TODO add your handling code here:
        FormularioFuncionarios ff = new FormularioFuncionarios();   //paresentes (this, true);
       // ff.setAlwaysOnTop(rootPaneCheckingEnabled);
        ff.setVisible(true);
        
        
    }//GEN-LAST:event_menu_funcionarioActionPerformed

    private void menu_fornecedoresActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menu_fornecedoresActionPerformed
        // TODO add your handling code here:
        FormularioFornecedor fcc = new FormularioFornecedor();   // paresentes(this,true)
        //fcc.setModal(rootPaneCheckingEnabled);
        fcc.setVisible(true); 
        
    }//GEN-LAST:event_menu_fornecedoresActionPerformed

    private void menuSubMenuFormularioProdutoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuSubMenuFormularioProdutoActionPerformed
        // TODO add your handling code here:
        
       // FormularioProduto fp = new FormularioProduto();
        
       // fp.setVisible(true);
        
        
        
    }//GEN-LAST:event_menuSubMenuFormularioProdutoActionPerformed

    private void menusubMenuconsultaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menusubMenuconsultaActionPerformed
        // TODO add your handling code here:
        
        //FormularioProduto fp = new FormularioProduto();
       // fp.painel_guias.setSelectedIndex(1);
        
       // fp.setVisible(true);
        
        
    }//GEN-LAST:event_menusubMenuconsultaActionPerformed

    private void menu_estoqueActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menu_estoqueActionPerformed
        // TODO add your handling code here:
        //FormularioEstoque fe = new FormularioEstoque(this, true);
       // fe.setModal(rootPaneCheckingEnabled);
        
       // fe.setVisible(true);
        
        
        
    }//GEN-LAST:event_menu_estoqueActionPerformed

    private void menuAbrirPdvActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuAbrirPdvActionPerformed
        // TODO add your handling code here:
        
        FormularioVendas fv = new FormularioVendas();
       fv.setVisible(true);
    }//GEN-LAST:event_menuAbrirPdvActionPerformed

    private void menuPosicaoDoDiaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuPosicaoDoDiaActionPerformed
        // TODO add your handling code here:
       // FormulariototalDoDia ftdd = new FormulariototalDoDia();
       // ftdd.setVisible(true);
    }//GEN-LAST:event_menuPosicaoDoDiaActionPerformed

    private void jMenuItem8ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem8ActionPerformed
        // TODO add your handling code here:
        
       // FormularioHistorico  fh = new FormularioHistorico();
       // fh.setVisible(true);
    }//GEN-LAST:event_jMenuItem8ActionPerformed

    private void ProdutosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ProdutosActionPerformed
        // TODO add your handling code here:
        
         try{
            Connection conn = new ConexaoBanco().pegarConexao();
            
            JasperPrint print = JasperFillManager.fillReport(getClass().getResourceAsStream("/relatorios/relatorioProdutos.Jasper"), null, conn);
            JasperViewer.viewReport(print,false);
        } catch (Exception e){
            JOptionPane.showMessageDialog(null, e); 
            
        }
        
        
        
        
        
    }//GEN-LAST:event_ProdutosActionPerformed

    private void jMenuItem4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem4ActionPerformed
        // TODO add your handling code here:
        
        try{
            Connection conn = new ConexaoBanco().pegarConexao();
            
            JasperPrint print = JasperFillManager.fillReport(getClass().getResourceAsStream("/relatorios/relatorioClientes.Jasper"), null, conn);
            JasperViewer.viewReport(print,false);
        } catch (Exception e){
            JOptionPane.showMessageDialog(null, e); 
            
        }
    }//GEN-LAST:event_jMenuItem4ActionPerformed

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
            java.util.logging.Logger.getLogger(AreaTrabalho.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(AreaTrabalho.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(AreaTrabalho.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(AreaTrabalho.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
           public void run() {
              // new AreaTrabalho().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenuItem MenuClientes;
    private javax.swing.JMenu Meus_Produtos;
    private javax.swing.JMenuItem Produtos;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu10;
    private javax.swing.JMenu jMenu11;
    private javax.swing.JMenu jMenu12;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenu jMenu3;
    private javax.swing.JMenu jMenu4;
    private javax.swing.JMenu jMenu7;
    private javax.swing.JMenu jMenu9;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuBar jMenuBar2;
    private javax.swing.JMenuBar jMenuBar3;
    private javax.swing.JMenuItem jMenuItem10;
    private javax.swing.JMenuItem jMenuItem12;
    private javax.swing.JMenuItem jMenuItem13;
    private javax.swing.JMenuItem jMenuItem4;
    private javax.swing.JMenuItem jMenuItem8;
    private javax.swing.JMenuItem jMenuItem9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JLabel lblLogado;
    private javax.swing.JLabel lblusuarioLogado;
    private javax.swing.JMenuItem menuAbrirPdv;
    private javax.swing.JMenu menuHistoricoVenda;
    private javax.swing.JMenuItem menuPosicaoDoDia;
    private javax.swing.JMenuItem menuSubMenuFormularioProduto;
    private javax.swing.JMenu menuSubProdutos;
    private javax.swing.JMenu menuTrocaUsuario;
    public javax.swing.JMenuItem menu_estoque;
    public javax.swing.JMenuItem menu_fornecedores;
    public javax.swing.JMenuItem menu_funcionario;
    private javax.swing.JMenuItem menusubMenuconsulta;
    private javax.swing.JDesktopPane painel_Desktop;
    // End of variables declaration//GEN-END:variables
}
